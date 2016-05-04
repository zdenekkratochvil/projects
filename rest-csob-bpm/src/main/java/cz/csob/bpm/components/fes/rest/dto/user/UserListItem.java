package cz.csob.bpm.components.fes.rest.dto.user;

import java.util.Date;

public class UserListItem {

	// attributes

	private Long id;
	private String personalNo;
	private Date validFrom;
	private Date validTo;
	private String emailAddress;
	private String userName;

	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonalNo() {
		return personalNo;
	}

	public void setPersonalNo(String personalNo) {
		this.personalNo = personalNo;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// default methods
	
	@Override
	public String toString() {
		return "User [id=" + id + ", personalNo=" + personalNo + ", validFrom=" + validFrom + ", validTo=" + validTo
				+ ", emailAddress=" + emailAddress + ", userName=" + userName + "]";
	}

}
