package cz.csob.bpm.components.fes.rest.dto.task;

import java.util.List;

/**
 * @author Zdenek Kratochvil
 *
 */
public class BulkTaskDetailsData {

	private List<BulkTaskDetailsItem> tasks;

	public List<BulkTaskDetailsItem> getTasks() {
		return tasks;
	}

	public void setTasks(List<BulkTaskDetailsItem> tasks) {
		this.tasks = tasks;
	}
	
}