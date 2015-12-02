package introsde.assignment.soap.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;

import introsde.assignment.soap.bean.PersonBean;
import introsde.assignment.soap.model.Measure;

public class PersonBeanDelegate {

	public final static List<String> myMappingFiles = Arrays.asList("dozerMappings.xml");

	public static introsde.assignment.soap.model.Person mapToPerson(
			introsde.assignment.soap.bean.PersonBean personbean) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.model.Person) mapper.map(personbean,
				introsde.assignment.soap.model.Person.class);
	}

	public static introsde.assignment.soap.bean.PersonBean mapFromPerson(introsde.assignment.soap.model.Person person) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		PersonBean pb =(introsde.assignment.soap.bean.PersonBean) mapper.map(person,
				introsde.assignment.soap.bean.PersonBean.class);
		pb.setCurrentHealth(MeasureBeanDelegate.mapFromMeasureList(Measure.getListCurrentMeasureByPerson(pb.getId())));
		return pb;
	}

	public static List<introsde.assignment.soap.bean.PersonBean> mapFromPersonList(
			List<introsde.assignment.soap.model.Person> personList) {
		List<introsde.assignment.soap.bean.PersonBean> result = null;
		if ((personList != null) && (personList.size() > 0)) {
			result = new ArrayList<introsde.assignment.soap.bean.PersonBean>();
			for (introsde.assignment.soap.model.Person p : personList) {
				PersonBean pb = mapFromPerson(p);
				pb.setCurrentHealth(MeasureBeanDelegate.mapFromMeasureList(Measure.getListCurrentMeasureByPerson(pb.getId())));				
				result.add(pb);
			}

		}
		return result;

	}
}
