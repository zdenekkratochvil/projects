package cz.csob.bpm.components.fes.rest.dto.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ClientListItem {

	// attributes

	private String cuid;

	private String ippid;
	
	private String type;

	private String firstName;

	private String lastName;
	
	private String companyName;

	private String title;

	private String birthNumber;
	
	private String companyGovIdNumber;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd. MM. yyyy")
	private Date birthDate;

	private boolean riskFlag;

	private List<Address> addresses;

	private List<AccountRole> accountRoles;

	private List<Email> emails;

	// private List<Role> roles;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getCompanyGovIdNumber() {
		return companyGovIdNumber;
	}

	public void setCompanyGovIdNumber(String companyGovIdNumber) {
		this.companyGovIdNumber = companyGovIdNumber;
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

	public List<AccountRole> getAccountsRoles() {
		if (accountRoles == null){
			accountRoles = new ArrayList<AccountRole>();
		}
		return accountRoles;
	}

	public void setAccountRoles(List<AccountRole> accountRoles) {
		this.accountRoles = accountRoles;
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


	// default methods
	@Override
	public String toString() {
		return "ClientListItem [cuid=" + cuid + ", ippid=" + ippid + ", type="
				+ type + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", companyName=" + companyName + ", title=" + title
				+ ", birthNumber=" + birthNumber + ", companyGovIdNumber="
				+ companyGovIdNumber + ", birthDate=" + birthDate
				+ ", riskFlag=" + riskFlag + ", addresses=" + addresses
				+ ", accountRoles=" + accountRoles + ", emails=" + emails + "]";
	}

}
