package introsde.assignment.soap.ws;
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

@WebService(endpointInterface = "introsde.assignment.soap.ws.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {

    @Override
    public Person readPerson(Long id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getFirstname());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }

    @Override
    public List<PersonBean> getPeople() {
    	List<PersonBean> pl = PersonBeanDelegate.mapFromPersonList(Person.getAll());
    	return pl;
    }

    @Override
    public Long addPerson(PersonBean person) {
    	if ((person.getCurrentHealth() != null) && (person.getCurrentHealth().size() > 0)){
    		for (MeasureBean mb :  person.getCurrentHealth()){
    			Measure m = MeasureBeanDelegate.mapToMeasure(mb);
    			Measure.saveMeasureDefinition(m);
    		}
    	}
    	Person p = PersonBeanDelegate.mapToPerson(person);
    	
        Person.savePerson(p);
        return person.getId();
    }

    @Override
    public Long updatePerson(PersonBean person) {
    	Person p = PersonBeanDelegate.mapToPerson(person);
        Person.updatePerson(p);
        return person.getId();
    }

    @Override
    public int deletePerson(Long id) {
        Person p = Person.getPersonById(id);
        if (p!=null) {
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
	public MeasureProfile readMeasureTypes() {
		MeasureProfile mp = new MeasureProfile();
		mp.setCurrentHealthAll();
		return mp;
	}

	@Override
	public MeasureProfile readPersonMeasure(Long id, String type, Long mid) {
		MeasureProfile mp = new MeasureProfile();
		mp.setCurrentHealthPersonTypeMid(id, type,mid);
		return mp;
	}



}
