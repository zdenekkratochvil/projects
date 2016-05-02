package cz.csob.bpm.components.fes.rest.dto.task;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Zdenek Kratochvil
 *
 */
public class TaskQueryEntityListItem {

	private long tkiid;
	private String due;
	private int priority;
	private String assignedToRoleDisplayName;
	private String name;
	private String state;
	private String processInstanceDisplayName;
	private long processInstancePIID;

	public long getTkiid() {
		return tkiid;
	}

	@JsonProperty("TKIID")
	public void setTkiid(long tkiid) {
		this.tkiid = tkiid;
	}

	public String getDue() {
		return due;
	}

	@JsonProperty("DUE")
	public void setDue(String due) {
		this.due = due;
	}

	public int getPriority() {
		return priority;
	}

	@JsonProperty("PRIORITY")
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getAssignedToRoleDisplayName() {
		return assignedToRoleDisplayName;
	}

	@JsonProperty("ASSIGNED_TO_ROLE_DISPLAY_NAME")
	public void setAssignedToRoleDisplayName(String assignedToRoleDisplayName) {
		this.assignedToRoleDisplayName = assignedToRoleDisplayName;
	}

	public String getName() {
		return name;
	}

	@JsonProperty("NAME")
	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	@JsonProperty("STATE")
	public void setState(String state) {
		this.state = state;
	}

	public String getProcessInstanceDisplayName() {
		return processInstanceDisplayName;
	}

	@JsonProperty("PI_DISPLAY_NAME")
	public void setProcessInstanceDisplayName(String processInstanceDisplayName) {
		this.processInstanceDisplayName = processInstanceDisplayName;
	}

	public long getProcessInstancePIID() {
		return processInstancePIID;
	}

	@JsonProperty("PROCESS_INSTANCE.PIID")
	public void setProcessInstancePIID(long processInstancePIID) {
		this.processInstancePIID = processInstancePIID;
	}

}
