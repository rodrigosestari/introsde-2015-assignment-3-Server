package introsde.assignment.soap.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.dozer.Mapping;
import org.joda.time.DateTime;

import introsde.assignment.soap.model.Measure;
import introsde.assignment.soap.util.DateTimeAdapter;


@XmlRootElement(name = "measure")
//@XmlType(propOrder = { "firstname", "lastname", "birthdate", "healthprofile" })
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasureBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3114667130740699756L;

	@Mapping("mid")
	private Long mid;
	 
	@Mapping("dateRegistered")
	 @XmlJavaTypeAdapter(type = DateTime.class, value = DateTimeAdapter.class)
	private Date dateRegistered;
	 
	 @Mapping("measureType")
	 private String measureType;
	 
	 @Mapping("measureValue")
	 private String measureValue;
	 
	 @Mapping("measureValueType")
	 private String measureValueType; // string, integer, real
	 

	 
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public Date getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public String getMeasureType() {
		return measureType;
	}
	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}
	public String getMeasureValue() {
		return measureValue;
	}
	public void setMeasureValue(String measureValue) {
		this.measureValue = measureValue;
	}
	public String getMeasureValueType() {
		return measureValueType;
	}
	public void setMeasureValueType(String measureValueType) {
		this.measureValueType = measureValueType;
	}

	 
	 
}
