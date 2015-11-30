package introsde.assignment.soap.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.dozer.Mapping;


@XmlRootElement(name = "measure")
@XmlType(propOrder = { "mid", "dateRegistered", "measureType", "measureValue","measureValueType" })
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasureBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3114667130740699756L;

	@Mapping("mid")
	private Long mid;
	 
	@Mapping("dateRegistered")
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
	@Override
	public String toString() {
		return "MeasureBean [mid=" + mid + ", dateRegistered=" + dateRegistered + ", measureType=" + measureType
				+ ", measureValue=" + measureValue + ", measureValueType=" + measureValueType + "]";
	}

	 
	 
}
