package cz.csob.bpm.components.fes.rest.dto.client;

public class AccountRole {

	// attributes
	private String accountNumber;

	private String roleType;

	// getters and setters
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRoleType() {
		return roleType;
	}
	

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}


	// default methods
	@Override
	public String toString() {
		return "AccountRole [accountNumber=" + accountNumber + ", roleType="
				+ roleType + "]";
	}
	
	

}
