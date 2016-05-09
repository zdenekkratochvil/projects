package cz.csob.bpm.components.fault.client;

public class CSOBClientSearchRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 7768655866401811962L;

	public CSOBClientSearchRuntimeException() {
		super();
	}

	public CSOBClientSearchRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public CSOBClientSearchRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CSOBClientSearchRuntimeException(String message) {
		super(message);
	}

	public CSOBClientSearchRuntimeException(Throwable cause) {
		super(cause);
	}

	
}
