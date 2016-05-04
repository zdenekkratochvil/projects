package cz.csob.bpm.components.service.rest;

import org.springframework.web.util.UriComponentsBuilder;

public class UriComponentsUtils {

	private static final String TASKS_QUERY_ENTITY_LIST = "/tasks/query/IBM.DEFAULTALLTASKSLIST_75";
	
	public static final String PARAM_PARTS_ALL = "all";
	public static final String PARAM_PARTS_NONE = "none";
	public static final String PARAM_PARTS = "parts";
	public static final String PARAM_SNAPSHOT_ID = "snapshotId";
	public static final String PARAM_CREATE_TASK = "createTask";
	public static final String PARAM_ACTION_VALUE = "start";
	public static final String PARAM_ACTION = "action";
	public static final String PARAM_USERNAME = "userName";
	
	public static final String SIZE = "size";
	public static final String DUE_PRIORITY = "DUE,PRIORITY";
	public static final String SORT_ATTRIBUTES = "sortAttributes";
	public static final String ASSESS_AVAILABLE = "ASSESS_AVAILABLE";
	public static final String INTERACTION_FILTER = "interactionFilter";
	public static final String CALC_STATS = "calcStats";
	public static final String PARAMS = "params";
	public static final String TASK_IDS = "taskIDs";
	public static final String CLAIM = "claim";
	public static final String GET_DETAILS = "getdetails";
	public static final String REFRESH_USER = "refreshUser";
	public static final String INCLUDE_INTERNAL_MEMBERSHIPS = "includeInternalMemberships";
	
	public static final String PATH_TASK = "/task";
	public static final String PATH_USER = "/user/";
	public static final String PATH_SLASH = "/";

	private static String backendUrl;
	private static String csobBpmServiceUrl;

	public static UriComponentsBuilder createGetUser(String username) {
		return UriComponentsBuilder.fromUriString(backendUrl).path(PATH_USER + PATH_SLASH).path(username).queryParam(INCLUDE_INTERNAL_MEMBERSHIPS, false)
				.queryParam(REFRESH_USER, false).queryParam(PARAM_PARTS, PARAM_PARTS_NONE);
	}

	public static UriComponentsBuilder createGetTaskDetails(long tkiid) {
		return UriComponentsBuilder.fromUriString(backendUrl).path(PATH_TASK).queryParam(PARAM_ACTION, GET_DETAILS)
				.queryParam(TASK_IDS, tkiid).queryParam(PARAM_PARTS, PARAM_PARTS_ALL);
	}

	public static UriComponentsBuilder createUriComponentsBuilder(String serviceId, String snapshotId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(backendUrl).path(serviceId).queryParam(PARAM_ACTION, PARAM_ACTION_VALUE)
				.queryParam(PARAM_CREATE_TASK, false).queryParam(PARAM_PARTS, PARAM_PARTS_ALL);
		if(snapshotId != null) {
			uriBuilder.queryParam(PARAM_SNAPSHOT_ID, snapshotId);
		}
		return uriBuilder;
	}

	public static UriComponentsBuilder createBatchClaimBuilder(String ids) {
		return UriComponentsBuilder.fromUriString(backendUrl).path(PATH_TASK).queryParam(PARAM_ACTION, CLAIM).queryParam(TASK_IDS, ids);
	}

	public static UriComponentsBuilder createTaskQueryEntityListBuilder(int size) {
		return UriComponentsBuilder.fromUriString(backendUrl).path(TASKS_QUERY_ENTITY_LIST).queryParam(CALC_STATS, false)
				.queryParam(INTERACTION_FILTER, ASSESS_AVAILABLE).queryParam(SORT_ATTRIBUTES, DUE_PRIORITY).queryParam(SIZE, size);
	}
	
	public static UriComponentsBuilder createFindUserBuilder(String username) {
		return UriComponentsBuilder.fromUriString(csobBpmServiceUrl).path(PATH_USER).queryParam(PARAM_USERNAME, username);
	}

	public void setBackendUrl(String backendUrl) {
		UriComponentsUtils.backendUrl = backendUrl;
	}
	
	public void setCsobBpmServiceUrl(String csobBpmServiceUrl) {
		UriComponentsUtils.csobBpmServiceUrl = csobBpmServiceUrl;
	}
	

}
