package introsde.assignment.soap.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.dozer.Mapping;

import introsde.assignment.soap.mapping.MeasureBeanDelegate;
import introsde.assignment.soap.model.Measure;


@XmlRootElement(name = "person")
@XmlType(propOrder = { "id", "firstname", "lastname", "currentHealth" })
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonBean implements Serializable  {
     /**
	 * 
	 */
	private static final long serialVersionUID = 3166894122446393096L;

	@Mapping("id")
    @XmlElement(name = "id")
	 private Long id;
     
     @Mapping("firstname")
     @XmlElement(name = "firstname")
     private String firstname;
     
     @Mapping("lastname")
     @XmlElement(name = "lastname")
     private String lastname;
     
     @XmlElement(name = "currentHealth")
     private  List<MeasureBean> currentHealth = null; // one for each type of measure
     

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
  
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setCurrentHealth(List<MeasureBean> currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	
	public List<MeasureBean> getCurrentHealth() {	      
        if (currentHealth == null){
        	currentHealth =MeasureBeanDelegate.mapFromMeasureList(Measure.getListCurrentMeasureByPerson(getId()));
        }
		        
        	return	currentHealth;
    }
	@Override
	public String toString() {
		return "PersonBean [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", currentHealth="
				+ currentHealth + "]";
	}
	



}
