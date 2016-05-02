package cz.csob.bpm.components.fes.rest.dto.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientListItem {

	// attributes

	private String cuid;

	private String ippid;

	private String name;

	private String surname;

	private String title;

	private String birthNumber;

	private Date birthDate;

	private boolean riskFlag;

	private List<Address> addresses;

	private List<Account> accounts;

	private List<Email> emails;

	private List<Role> roles;

	// getters and setters

	public String getCuid() {
		return cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}

	public String getIppid() {
		return ippid;
	}

	public void setIppid(String ippid) {
		this.ippid = ippid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBirthNumber() {
		return birthNumber;
	}

	public void setBirthNumber(String birthNumber) {
		this.birthNumber = birthNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isRiskFlag() {
		return riskFlag;
	}

	public void setRiskFlag(boolean riskFlag) {
		this.riskFlag = riskFlag;
	}

	public List<Address> getAddresses() {
		if (addresses == null){
			addresses = new ArrayList<Address>();
		}
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Account> getAccounts() {
		if (accounts == null){
			accounts = new ArrayList<Account>();
		}
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Email> getEmails() {
		if (emails == null){
			emails = new ArrayList<Email>();
		}
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Role> getRoles() {
		if (roles == null){
			roles = new ArrayList<Role>();
		}
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	// default methods

	@Override
	public String toString() {
		return "ClientListItem [cuid=" + cuid + ", ippid=" + ippid + ", name=" + name + ", surname=" + surname
				+ ", title=" + title + ", birthNumber=" + birthNumber + ", birthDate=" + birthDate + ", riskFlag="
				+ riskFlag + ", addresses=" + addresses + ", accounts=" + accounts + ", emails=" + emails + ", roles="
				+ roles + "]";
	}

}
