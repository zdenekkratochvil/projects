package cz.csob.bpm.components.fes.rest.dto.client;

import java.io.Serializable;

public class ErrorInfo implements Serializable {
	
	private String errorCode;
	
	private String errorMessage;
	
	private String processId;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Override
	public String toString() {
		return "ErrorInfo [errorCode=" + errorCode + ", errorMessage="
				+ errorMessage + ", processId=" + processId + "]";
	}
	
}
