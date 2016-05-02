package cz.csob.bpm.components.fes.rest.dto.client;

public class Address {
	
	// attributes
	
	private String street;
	
	private String city;
	
	private String postCode;
		
	// getters and setters

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	// default methods
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", postCode=" + postCode + "]";
	} 
}
