package hibernate1;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
public class Persons {
	@Id @GeneratedValue
	@Column(name = "personid")
	private int personid;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	
	public Persons() {}
	
	public Persons(int personid, String lastname, String firstname, String address, String city) {
		super();
		this.personid = personid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.city = city;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Persons [personid=" + personid + ", lastname=" + lastname + ", firstname=" + firstname + ", address="
				+ address + ", city=" + city + "]";
	}

	
}
