package cz.csob.bpm.components.fes.rest.dto.client;

import java.io.Serializable;

public class ErrorInfo implements Serializable {
	
	private String errorCode;
	
	private String errorMessage;
	
	private String stackTrace; 

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

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	@Override
	public String toString() {
		return "ErrorInfo [errorCode=" + errorCode + ", errorMessage="
				+ errorMessage + ", stackTrace=\n" + stackTrace + "]";
	}
	
}
