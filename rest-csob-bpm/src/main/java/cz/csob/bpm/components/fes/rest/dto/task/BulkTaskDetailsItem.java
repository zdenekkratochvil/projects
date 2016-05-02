package cz.csob.bpm.components.fes.rest.dto.task;


/**
 * @author Zdenek Kratochvil
 *
 */
public class BulkTaskDetailsItem {

	private long tkiid;
	private BulkTaskDetailsItemProcessData processData;

	public long getTkiid() {
		return tkiid;
	}

	public void setTkiid(long tkiid) {
		this.tkiid = tkiid;
	}

	public BulkTaskDetailsItemProcessData getProcessData() {
		return processData;
	}

	public void setProcessData(BulkTaskDetailsItemProcessData processData) {
		this.processData = processData;
	}
}
