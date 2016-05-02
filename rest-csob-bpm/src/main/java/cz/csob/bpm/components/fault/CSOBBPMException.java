package cz.csob.bpm.components.fault;

public class CSOBBPMException extends Exception {

	private static final long serialVersionUID = -4793405241581833009L;

	public CSOBBPMException() {
		super();
	}

	public CSOBBPMException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CSOBBPMException(String message, Throwable cause) {
		super(message, cause);
	}

	public CSOBBPMException(String message) {
		super(message);
	}

	public CSOBBPMException(Throwable cause) {
		super(cause);
	}

}
