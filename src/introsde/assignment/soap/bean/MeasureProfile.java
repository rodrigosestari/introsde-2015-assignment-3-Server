package introsde.assignment.soap.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import introsde.assignment.soap.mapping.MeasureBeanDelegate;
import introsde.assignment.soap.model.Measure;

@XmlRootElement(name = "healthProfile-history")
@XmlAccessorType(XmlAccessType.FIELD)
public class MeasureProfile {
	
	@XmlElement(name = "currentHealth")
	private List<MeasureBean> currentHealth = null;
	 

	public List<MeasureBean> setCurrentHealthPerson(Long idPerson) {	      
		 return  MeasureBeanDelegate.mapFromMeasureList(Measure.getListMeasureByPerson(idPerson));
   }
	
	
	public void setCurrentHealthPersonType(Long idPerson,String type) {	      
		 setCurrentHealth(MeasureBeanDelegate.mapFromMeasureList(Measure.getListMeasureByPersonType(idPerson, type)));
  }
	
	public void setCurrentHealthPersonTypeMid(Long idPerson,String type,Long mid) {	      
		 setCurrentHealth(MeasureBeanDelegate.mapFromMeasureList(Measure.getListMeasureByPersonTypeMid(idPerson, type,mid)));
 }
	
	public void setCurrentHealthAll() {	      
		 setCurrentHealth(MeasureBeanDelegate.mapFromMeasureList(Measure.getAll()));
 }


	public List<MeasureBean> getCurrentHealth() {
		return currentHealth;
	}


	public void setCurrentHealth(List<MeasureBean> currentHealth) {
		this.currentHealth = currentHealth;
	}


	@Override
	public String toString() {
		return "MeasureProfile [currentHealth=" + currentHealth + "]";
	}
	
	
	
}
