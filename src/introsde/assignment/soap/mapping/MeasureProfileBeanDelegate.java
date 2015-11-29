package introsde.assignment.soap.mapping;

import java.util.Arrays;
import java.util.List;
import org.dozer.DozerBeanMapper;

import introsde.assignment.soap.bean.MeasureBean;
import introsde.assignment.soap.model.Measure;

public class MeasureProfileBeanDelegate {

    public final static List<String> myMappingFiles = Arrays.asList("dozerMappings.xml");

    
    /**
	 * This function map a MeasureBean Presentation Layer into a
	 * Measure Domain Model using Dozer
	 * 
	 * @param bean
	 * an object dozerproject.transfer.MeasureBean
	 * @return 
	 * an object dozerproject.entity.Measure
	 */
	public static introsde.assignment.soap.model.Measure mapToMeasure(introsde.assignment.soap.bean.MeasureBean bean) {
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.model.Measure) mapper.map(bean, introsde.assignment.soap.model.Measure.class);
	}
    
	/**
	 * This function map a Person Domain Model into a MeasureBean
	 * Presentation Layer using Dozer
	 * 
	 * @param person
	 * an object dozerproject.entity.MeasureStore
	 * @return 
	 * an object dozerproject.transfer.MeasureBean
	 */
	public static introsde.assignment.soap.bean.MeasureBean mapFromMeasure(introsde.assignment.soap.model.Measure person) {
	
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.bean.MeasureBean) mapper.map(person, introsde.assignment.soap.bean.MeasureBean.class);
	}
}
