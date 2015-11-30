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
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PersonBean implements Serializable  {
     /**
	 * 
	 */
	private static final long serialVersionUID = 3166894122446393096L;

	@Mapping("id")
	 private Long id;
     
     @Mapping("firstname")
     private String firstname;
     
     @Mapping("lastname")
     private String lastname;
     
    
     private  List<MeasureBean> currentHealth; // one for each type of measure
     
     @XmlElement(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
    @XmlElement(name = "firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
    @XmlElement(name = "lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setCurrentHealth(List<MeasureBean> currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	 @XmlElement(name = "currentHealth")
	public List<MeasureBean> getCurrentHealth() {	      
        
		 return  MeasureBeanDelegate.mapFromMeasureList(Measure.getListCurrentMeasureByPerson(getId()));
    }
	@Override
	public String toString() {
		return "PersonBean [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", currentHealth="
				+ currentHealth + "]";
	}
	



}
