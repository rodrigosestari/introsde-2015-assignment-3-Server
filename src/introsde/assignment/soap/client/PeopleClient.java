package introsde.assignment.soap.client;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import introsde.assignment.soap.bean.MeasureBean;
import introsde.assignment.soap.bean.MeasureProfile;
import introsde.assignment.soap.bean.PersonBean;
import introsde.assignment.soap.ws.People;

public class PeopleClient {
	private static FileWriter writer = null;
	private static People people = null;
	private static List<PersonBean> peopleList = null;
	private static MeasureProfile measureList = null;
	private static PersonBean personB, newPersonB = null;
	private static MeasureBean newMeasureB = null;
	private static List<String> measureType = null;
	private static Long idperson;
	private static String type;
	private static MeasureBean newmb = null;

	private static void write(String line) {
		try {
			System.out.println(line);
			writer.append(line + " \n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://10.218.223.157:6902/ws/people?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.soap.assignment.introsde/", "PeopleService");
		/// introsde.assignment.soap.ws.People
		Service service = Service.create(url, qname);

		people = service.getPort(People.class);

		writer = new FileWriter("client-server-xml.log");
		try {
			try {
				System.out.println("START client XML");
				write("URL BASE: http://rodrigo-sestari-soap-server.herokuapp.com/ws/people?wsdl");
				write("------------- \n");
				write("Request 1 : readPersonList");
				request1();
				write("------------- \n");

				write("Request 2 : readPerson");
				request2();
				write("------------- \n");

				write("Request 3 : updatePerson");
				request3();
				write("------------- \n");

				write("Request 4 : createPerson");
				request4();
				write("------------- \n");

				write("Request 5 : deletePerson");
				request5();
				write("------------- \n");

				write("Request 6 : readPersonHistory");
				request6();
				write("------------- \n");

				write("Request 7 : readMeasureTypes");
				request7();
				write("------------- \n");

				write("Request 8 : readPersonMeasure");
				request8();
				write("------------- \n");

				write("Request 9 : savePersonMeasure");
				request9();
				write("------------- \n");

				write("Request 10 : savePersonMeasure");
				request10();
				write("------------- \n");

				System.out.println("END client XML");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			writer.flush();
			writer.close();
		}

	}

	public static void request1() {
		try {
			peopleList = people.getPeople();
			if (peopleList != null) {
				for (PersonBean pb : peopleList) {
					write(pb.toString());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request2() {
		try {
			if ((peopleList != null) && (peopleList.size() > 0)) {
				idperson = peopleList.get(0).getId();
				personB = people.readPerson(idperson);
				write(personB.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request3() {
		try {
			if ((peopleList != null) && (peopleList.size() > 0)) {
				PersonBean pUpdate = peopleList.get(peopleList.size() - 1);

				write("id: " + pUpdate.getId());
				write("before:"+pUpdate.getFirstname()); 
				String uuid = UUID.randomUUID().toString();

				pUpdate.setFirstname("change" + uuid);
				Long id = people.updatePerson(pUpdate);
				pUpdate = people.readPerson(id);				
				write("after:"+pUpdate.getFirstname());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request4() {
		try {

			newPersonB = new PersonBean();
			String uuid = UUID.randomUUID().toString();
			newPersonB.setFirstname("create " + uuid);
			newPersonB.setLastname("last: " + new Date());
			newMeasureB = new MeasureBean();
			newMeasureB.setMeasureType("height");
			Random nr = new Random();
			newMeasureB.setMeasureValue(""+ nr.nextInt(100));
			newMeasureB.setMeasureValueType("integer");
			newMeasureB.setDateRegistered(new Date());
			List<MeasureBean> ml = new ArrayList<MeasureBean>();
			ml.add(newMeasureB);
			newPersonB.setCurrentHealth(ml);
			Long id = people.addPerson(newPersonB);

			newPersonB = people.readPerson(id);
			write(newPersonB.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request5() {
		try {

			if (newPersonB != null) {
				Long id = newPersonB.getId();
				people.deletePerson(id);
				newPersonB = people.readPerson(id);
				if (newPersonB == null) {
					write("OK");
				} else {
					write(newPersonB.toString());
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request6() {
		try {
			if (idperson != null) {
				measureList = people.readPersonHistory(idperson, "weight");
				if ((measureList != null) && (measureList.getCurrentHealth() != null)) {
					for (MeasureBean mb : measureList.getCurrentHealth()) {
						write(mb.toString());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request7() {
		try {
			measureType = people.readMeasureTypes();
			if (measureType != null) {
				for (String mt : measureType) {
					write(mt);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request8() {
		try {
			if ((measureList != null) && (measureList.getCurrentHealth().size() > 0)) {
				Long mid = measureList.getCurrentHealth().get(0).getMid();
				type = measureList.getCurrentHealth().get(0).getMeasureType();

				measureList = people.readPersonMeasure(idperson, type, mid);
				if (measureList != null) {
					for (MeasureBean mb : measureList.getCurrentHealth()) {
						write(mb.toString());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request9() {
		try {
			newmb = new MeasureBean();
			newmb.setMeasureType("newType");
			Random nr = new Random();
			newmb.setMeasureValue("" + nr.nextInt(100));
			newmb.setMeasureValueType("integer");
			newmb.setDateRegistered(new Date());

			Long mid = people.savePersonMeasure(idperson, newmb);
			newmb.setMid(mid);
			measureList = people.readPersonMeasure(idperson, "newType", mid);
			if ((measureList != null) && (measureList.getCurrentHealth() != null)) {
				for (MeasureBean mb : measureList.getCurrentHealth()) {					
					write(mb.toString());
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void request10() {
		try {

			if (newmb != null) {
				Random rd = new Random();

				Integer newvalue = rd.nextInt(100);
				newmb.setMeasureValue(newvalue.toString());
				newmb.setDateRegistered(new Date());
				people.updatePersonMeasure(idperson, newmb);

				measureList = people.readPersonMeasure(idperson, newmb.getMeasureType(), newmb.getMid());
				if (measureList != null) {
					for (MeasureBean mb : measureList.getCurrentHealth()) {
						write(mb.toString());
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
