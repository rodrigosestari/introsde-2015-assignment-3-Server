package introsde.assignment.soap.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.dozer.Mapping;

import introsde.assignment.soap.model.Measure;

@XmlRootElement(name = "person")
//@XmlType(propOrder = { "firstname", "lastname", "birthdate", "healthprofile" })
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonBean implements Serializable  {
     /**
	 * 
	 */
	private static final long serialVersionUID = 3166894122446393096L;

	@Mapping("id")
	 Long id;
     
     @Mapping("firstname")
	 String firstname;
     
     @Mapping("lastname")
	 String lastname;
     
     @XmlElement(name = "currentHealth")
	 List<Measure> currentHealth; // one for each type of measure
     
     @XmlElement(name = "healthHistory")
	 List<Measure> healthHistory; // all measurements
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
	public List<Measure> getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(List<Measure> currentHealth) {
		this.currentHealth = currentHealth;
	}
	public List<Measure> getHealthHistory() {
		return healthHistory;
	}
	public void setHealthHistory(List<Measure> healthHistory) {
		this.healthHistory = healthHistory;
	}
	 
	 
}
