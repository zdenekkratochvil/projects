package cz.csob.bpm.components.fes.rest.dto.client;

public class Account {

	// attributes

	private String id;

	private String bankId;

	private String iban;

	// getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	// default methods

	@Override
	public String toString() {
		return "Account [id=" + id + ", bankId=" + bankId + ", iban=" + iban + "]";
	}

}
