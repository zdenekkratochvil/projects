package cz.csob.bpm.components.fes.rest.dto.task;

import java.util.List;

/**
 * @author Zdenek Kratochvil
 *
 */
public class BulkTaskDetailsItemProcessData {

	private List<BulkTaskDetailsItemBusinessData> businessData;

	public List<BulkTaskDetailsItemBusinessData> getBusinessData() {
		return businessData;
	}

	public void setBusinessData(List<BulkTaskDetailsItemBusinessData> businessData) {
		this.businessData = businessData;
	}
}
