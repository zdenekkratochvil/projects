package cz.csob.bpm.components.fes.rest.dto.task;

import java.util.List;

/**
 * @author Zdenek Kratochvil
 *
 */
public class TaskQueryEntityListData {

	private List<TaskQueryEntityListItem> items;

	public List<TaskQueryEntityListItem> getItems() {
		return items;
	}

	public void setItems(List<TaskQueryEntityListItem> items) {
		this.items = items;
	}


}
