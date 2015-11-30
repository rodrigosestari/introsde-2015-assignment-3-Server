package introsde.assignment.soap.mapping;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class MeasureProfileBeanDelegate {

	public final static List<String> myMappingFiles = Arrays.asList("dozerMappings.xml");

	public static introsde.assignment.soap.model.Measure mapToMeasure(
			introsde.assignment.soap.bean.MeasureBean measurebean) {

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.model.Measure) mapper.map(measurebean,
				introsde.assignment.soap.model.Measure.class);
	}

	public static introsde.assignment.soap.bean.MeasureBean mapFromMeasure(
			introsde.assignment.soap.model.Measure measure) {

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.bean.MeasureBean) mapper.map(measure,
				introsde.assignment.soap.bean.MeasureBean.class);
	}
}
