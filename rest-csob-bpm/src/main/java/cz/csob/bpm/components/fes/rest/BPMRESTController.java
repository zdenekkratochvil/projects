package cz.csob.bpm.components.fes.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import cz.csob.bpm.components.fes.rest.dto.GetPriorityTaskResponse;
import cz.csob.bpm.components.fes.rest.dto.task.BulkTaskDetails;
import cz.csob.bpm.components.fes.rest.dto.task.BulkTaskDetailsItem;
import cz.csob.bpm.components.fes.rest.dto.task.BulkTaskDetailsItemBusinessData;
import cz.csob.bpm.components.fes.rest.dto.task.TaskQueryEntityList;
import cz.csob.bpm.components.fes.rest.dto.task.TaskQueryEntityListItem;
import cz.csob.bpm.components.service.rest.UriComponentsUtils;

@RestController
@RequestMapping(path="/rest/bpm")
public class BPMRESTController extends AbstractRESTController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BPMRESTController.class);
	
	private static final String GET_ALL_MANAGER_SUB_TEAMS_SERVICE_ID = "/service/1.4100e122-8d2e-4c5f-8a95-27e5236bb297";
	private static final String LOAD_TEAM_TASKS_SERVICE_ID = "/service/1.460ce2a6-2084-4e0e-ae0f-a37e2a658756";

	@RequestMapping(path="getAllManagerSubTeams", method = RequestMethod.POST)
	public void getAllManagerSubTeams(@RequestParam(required=false) String snapshotId, HttpServletResponse resp) throws IOException {
		UriComponentsBuilder uriBuilder = UriComponentsUtils.createUriComponentsBuilder(GET_ALL_MANAGER_SUB_TEAMS_SERVICE_ID, snapshotId);
		
		byte[] result = getTemplate().getResult(uriBuilder, HttpMethod.POST);
		writeJSONResponse(resp, result);
	}

	@RequestMapping(path="loadTeamTasks", method = RequestMethod.POST)
	public void loadTeamTasks(@RequestParam(required=false) String snapshotId, @RequestParam String params, HttpServletResponse resp) throws IOException {
		LOG.debug("Accepted params: {}", params);
		UriComponentsBuilder uriBuilder = UriComponentsUtils.createUriComponentsBuilder(LOAD_TEAM_TASKS_SERVICE_ID, snapshotId);
		uriBuilder.queryParam(UriComponentsUtils.PARAMS, params);
		
		byte[] result = getTemplate().getResult(uriBuilder, HttpMethod.POST);
		writeJSONResponse(resp, result);
	}
	
	@RequestMapping(path="getUserTasks", method = RequestMethod.GET)
	public GetPriorityTaskResponse getUserTasks() {
		UriComponentsBuilder uriBuilder = UriComponentsUtils.createTaskQueryEntityListBuilder(1);
		
		TaskQueryEntityList value = getTemplate().getResult(uriBuilder, HttpMethod.GET, TaskQueryEntityList.class);
		
		GetPriorityTaskResponse resp = new GetPriorityTaskResponse();
		if(value != null && value.getData() != null && value.getData().getItems() != null && value.getData().getItems().size() > 0) {
			
			TaskQueryEntityListItem firstItem = value.getData().getItems().get(0);
			
			long tkiid = firstItem.getTkiid();
			
			uriBuilder = UriComponentsUtils.createGetTaskDetails(tkiid);
			
			BulkTaskDetails taskDetails = getTemplate().getResult(uriBuilder, HttpMethod.GET, BulkTaskDetails.class);
			
			Assert.isTrue("200".equals(taskDetails.getStatus()), "GetTaskDetails call failed");
			Assert.notEmpty(taskDetails.getData().getTasks(), "GetTaskDetails call failed");
			
			BulkTaskDetailsItem bulkTaskDetailsItem = taskDetails.getData().getTasks().get(0);
			
			String cuid = findBusinessDataValueByAlias(bulkTaskDetailsItem, "cuid");
			
			String ids;
			if(StringUtils.isNotBlank(cuid)) {
				uriBuilder = UriComponentsUtils.createTaskQueryEntityListBuilder(5).queryParam("searchFilter", "cuid: " + cuid);
				value = getTemplate().getResult(uriBuilder, HttpMethod.GET, TaskQueryEntityList.class);
				
				Assert.notEmpty(value.getData().getItems(), "No tasks for cuid: " + cuid);
				
				ids = parseTaskIds(value.getData().getItems());
			} else {
				ids = "" + firstItem.getTkiid();
			}
			
			uriBuilder = UriComponentsUtils.createBatchClaimBuilder(ids);
			getTemplate().getResult(uriBuilder, HttpMethod.PUT);
				
			resp.setPriorityTaskId(firstItem.getTkiid());
		}
		return resp;
	}

	private String findBusinessDataValueByAlias(BulkTaskDetailsItem bulkTaskDetailsItem, String alias) {
		Assert.notNull(bulkTaskDetailsItem);
		Assert.notNull(bulkTaskDetailsItem.getProcessData());
		
		List<BulkTaskDetailsItemBusinessData> businessData = bulkTaskDetailsItem.getProcessData().getBusinessData();
		if(businessData != null) {
			for(BulkTaskDetailsItemBusinessData item : businessData) {
				if(StringUtils.equals(alias, item.getAlias())) {
					return item.getValue();
				}
			}
		}
		return null;
	}

	private String parseTaskIds(List<TaskQueryEntityListItem> items) {
		StringBuilder sb = new StringBuilder();
		
		for(TaskQueryEntityListItem item : items) {
			if(sb.length() > 0) {
				sb.append(',');
			}
			sb.append(item.getTkiid());
		}
		return sb.toString();
	}

}
