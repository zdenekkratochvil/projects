package cz.csob.bpm.components.fes.rest.dto.client;

public class Role {

	// attributes

	private short type;

	// getters and setters

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	// default methods

	@Override
	public String toString() {
		return "Role [type=" + type + "]";
	}

}
