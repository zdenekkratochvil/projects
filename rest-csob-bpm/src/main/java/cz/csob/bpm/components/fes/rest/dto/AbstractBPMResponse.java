package cz.csob.bpm.components.fes.rest.dto;

public class AbstractBPMResponse<T> {
	
	private String status;
	private T data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean ok() {
		return "200".equals(status);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
