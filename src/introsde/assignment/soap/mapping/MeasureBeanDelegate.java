package introsde.assignment.soap.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class MeasureBeanDelegate {

	public final static List<String> myMappingFiles = Arrays.asList("dozerMappings.xml");

	public static introsde.assignment.soap.model.Measure mapToMeasure(introsde.assignment.soap.bean.MeasureBean bean) {

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.model.Measure) mapper.map(bean, introsde.assignment.soap.model.Measure.class);
	}

	public static introsde.assignment.soap.bean.MeasureBean mapFromMeasure(
			introsde.assignment.soap.model.Measure measure) {

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		return (introsde.assignment.soap.bean.MeasureBean) mapper.map(measure,
				introsde.assignment.soap.bean.MeasureBean.class);
	}

	public static List<introsde.assignment.soap.bean.MeasureBean> mapFromMeasureList(
			List<introsde.assignment.soap.model.Measure> measurel) {
		ArrayList<introsde.assignment.soap.bean.MeasureBean> bl = null;
		if ((measurel != null) && (measurel.size() > 0)) {
			bl = new ArrayList<introsde.assignment.soap.bean.MeasureBean>();
			for (introsde.assignment.soap.model.Measure p : measurel) {
				bl.add(mapFromMeasure(p));
			}
		}
		return bl;
	}

}
