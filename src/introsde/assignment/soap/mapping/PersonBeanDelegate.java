package introsde.assignment.soap.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class PersonBeanDelegate {

    public final static List<String> myMappingFiles = Arrays.asList("dozerMappings.xml");
    
    /**
	 * This function map a PersonBean Presentation Layer into a
	 * Person Domain Model using Dozer
	 * 
	 * @param bean
	 * an object dozerproject.transfer.PersonBean
	 * @return 
	 * an object dozerproject.entity.Person
	 */
	public static introsde.assignment.soap.model.Person mapToPerson(introsde.assignment.soap.bean.PersonBean bean) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.model.Person) mapper.map(bean, introsde.assignment.soap.model.Person.class);
	}
    
	/**
	 * This function map a Person Domain Model into a PersonBean
	 * Presentation Layer using Dozer
	 * 
	 * @param person
	 * an object dozerproject.entity.PeopleStore
	 * @return 
	 * an object dozerproject.transfer.PersonBean
	 */
	public static introsde.assignment.soap.bean.PersonBean mapFromPerson(introsde.assignment.soap.model.Person person) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.bean.PersonBean) mapper.map(person, introsde.assignment.soap.bean.PersonBean.class);
	}
	
	public static List<introsde.assignment.soap.bean.PersonBean> mapFromPersonList(List<introsde.assignment.soap.model.Person> personList){
		List<introsde.assignment.soap.bean.PersonBean> result =  null;
		if ((personList !=null)  && (personList.size() > 0)){
			result =  new ArrayList<introsde.assignment.soap.bean.PersonBean>();
			for ( introsde.assignment.soap.model.Person p :personList){
				result.add(mapFromPerson(p));
			}
			
		}
		return result;
		
	}
}
