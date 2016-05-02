package cz.csob.bpm.components.fes.rest.dto.client;

public class Email {

	// attributes

	private String email;

	// getters and setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// default methods

	@Override
	public String toString() {
		return "Email [email=" + email + "]";
	}

}
