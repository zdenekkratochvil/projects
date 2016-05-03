package cz.csob.bpm.components.fault;

public class CSOBBPMRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 7768655866401811961L;

	public CSOBBPMRuntimeException() {
		super();
	}

	/*
	public CSOBBPMRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
*/
	public CSOBBPMRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CSOBBPMRuntimeException(String message) {
		super(message);
	}

	public CSOBBPMRuntimeException(Throwable cause) {
		super(cause);
	}

	
}
