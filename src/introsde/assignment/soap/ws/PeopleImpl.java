package introsde.assignment.soap.ws;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import introsde.assignment.soap.bean.MeasureBean;
import introsde.assignment.soap.bean.MeasureProfile;
import introsde.assignment.soap.bean.PersonBean;
import introsde.assignment.soap.mapping.MeasureBeanDelegate;
import introsde.assignment.soap.mapping.PersonBeanDelegate;
import introsde.assignment.soap.model.Measure;
import introsde.assignment.soap.model.Person;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment.soap.ws.People", serviceName = "PeopleService")
public class PeopleImpl implements People {

	@Override
	public PersonBean readPerson(Long id) {
		System.out.println("---> Reading Person by id = " + id);
		PersonBean pb = null;
		Person p = Person.getPersonById(id);
		if (p != null) {
			System.out.println("---> Found Person by id = " + id + " => " + p.getFirstname());
			pb =  PersonBeanDelegate.mapFromPerson(p);
		} else {
			System.out.println("---> Didn't find any Person with  id = " + id);
			 
		}
		
		return pb;
	}

	@Override
	public List<PersonBean> getPeople() {
		List<PersonBean> pl = PersonBeanDelegate.mapFromPersonList(Person.getAll());
		return pl;
	}

	@Override
	public Long addPerson(PersonBean person) {
		Person p = PersonBeanDelegate.mapToPerson(person);
		p = Person.savePerson(p);
		if ((person.getCurrentHealth() != null) && (person.getCurrentHealth().size() > 0)) {
			for (MeasureBean mb : person.getCurrentHealth()) {
				Measure m = MeasureBeanDelegate.mapToMeasure(mb);
				m.setPerson(p);
				Measure.saveMeasureDefinition(m);
			}
		}
		
		return p.getId();
	}

	@Override
	public Long updatePerson(PersonBean person) {
		Person p =  PersonBeanDelegate.mapToPerson(person);		
		p = Person.updatePerson(p);
		return p.getId();
	}

	@Override
	public int deletePerson(Long id) {
		Person p = Person.getPersonById(id);
		if (p != null) {
			Person.removePerson(p);
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public MeasureProfile readPersonHistory(Long id, String type) {
		MeasureProfile mp = new MeasureProfile();
		mp.setCurrentHealthPersonType(id, type);
		return mp;
	}

	@Override
	public List<String> readMeasureTypes() {
		List<String> list = Measure.getAllMeasureType();
		return list;
	}

	@Override
	public MeasureProfile readPersonMeasure(Long id, String type, Long mid) {
		MeasureProfile mp = new MeasureProfile();
		mp.setCurrentHealthPersonTypeMid(id, type, mid);
		return mp;
	}

	@Override
	public Long savePersonMeasure(Long id, MeasureBean m) {
		if (null != m) {
			Measure measure = MeasureBeanDelegate.mapToMeasure(m);
			Person p = Person.getPersonById(id);
			measure.setMid(Long.valueOf(0));
			measure.setPerson(p);
			measure.setDateRegistered(new Date());
			measure = Measure.saveMeasureDefinition(measure);
			return measure.getMid();
		}
		return null;
	}

	@Override
	public Long updatePersonMeasure(Long id, MeasureBean m) {
		if (null != m) {
			Measure measure = MeasureBeanDelegate.mapToMeasure(m);
			Person p = Person.getPersonById(id);
			measure.setPerson(p);
			measure = Measure.updateMeasureDefinition(measure);
			return measure.getMid();
		}
		return null;
	}

}
