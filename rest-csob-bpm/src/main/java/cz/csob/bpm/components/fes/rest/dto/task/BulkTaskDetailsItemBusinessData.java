package cz.csob.bpm.components.fes.rest.dto.task;

/**
 * @author Zdenek Kratochvil
 *
 */
public class BulkTaskDetailsItemBusinessData {

	private String name;
	private String type;
	private String alias;
	private String label;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
