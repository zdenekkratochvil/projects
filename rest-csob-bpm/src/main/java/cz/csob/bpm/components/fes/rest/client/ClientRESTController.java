package cz.csob.bpm.components.fes.rest.client;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.SOAPFaultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.util.UriComponentsBuilder;

import cz.csob.bpm.components.fault.client.CSOBClientSearchRuntimeException;
import cz.csob.bpm.components.fes.rest.AbstractRESTController;
import cz.csob.bpm.components.fes.rest.dto.GetPriorityTaskResponse;
import cz.csob.bpm.components.fes.rest.dto.client.ClientListData;
import cz.csob.bpm.components.fes.rest.dto.client.ErrorInfo;
import cz.csob.bpm.components.fes.rest.dto.user.UserList;
import cz.csob.bpm.components.fes.rest.dto.user.UserListItem;
import cz.csob.bpm.components.service.rest.UriComponentsUtils;
import cz.csob.bpm.components.service.rest.client.ClientService;
import cz.csob.bpm.components.service.security.ILTPATokenProvider;

@RestController
@RequestMapping(path="/rest/client")
public class ClientRESTController extends AbstractRESTController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ClientRESTController.class);
	
	private MappingJackson2JsonView  jsonView = new MappingJackson2JsonView();
	
	@Autowired 
	@Qualifier("THUBClientService")
	//@Qualifier("MockClientService")
	private ClientService clientService;
	
	@Autowired 
	private ILTPATokenProvider tokenProvider;

	@RequestMapping(path="getClientListByCuid", method = RequestMethod.POST)
	public @ResponseBody ClientListData getClientListByCuid(@RequestParam(required=true) String cuid) throws IOException {
		LOG.debug("getClientListByCuid - cuid: {}", cuid );
		LOG.debug("getClientListByCuid - user: {}", tokenProvider.getPrincipalName());
		ClientListData result = clientService.getClientListByCuid(cuid);
		
		// delete
		getUserIdByUserName(cuid);
		
		return result;
	}

	@RequestMapping(path="getClientListByIppid", method = RequestMethod.POST)
	public @ResponseBody ClientListData getClientListByIppid(@RequestParam(required=true) String ippid) throws IOException {
		LOG.debug("getClientListByIppid - ippid: {}", ippid );
		LOG.debug("getClientListByIppid - user: {}", tokenProvider.getPrincipalName());
		ClientListData result = clientService.getClientListByIppid(ippid);
		return result;
	}

	@RequestMapping(path="getClientListByAccountNumber", method = RequestMethod.POST)
	public @ResponseBody ClientListData getClientListByAccountNumber(@RequestParam(required=true) String accountNumber) throws IOException {
		LOG.debug("getClientListByAccountNumber - accountNumber: {}", accountNumber );
		LOG.debug("getClientListByAccountNumber - user: {}", tokenProvider.getPrincipalName());
		ClientListData result = clientService.getClientListByAccountNumber(accountNumber);
		return result;
	}
	
	@RequestMapping(path="getDisponentListByAccountNumber", method = RequestMethod.GET)
	public @ResponseBody ClientListData getDisponentListByAccountNumber(
			@RequestParam(required=true) String accountNumber,
			@RequestParam(required=false, defaultValue="") String processId) throws IOException {
		LOG.debug("getDisponentListByAccountNumber - accountNumber: {}", accountNumber );
		LOG.debug("getDisponentListByAccountNumber - user: {}", tokenProvider.getPrincipalName());
		ClientListData result = clientService.getDisponentListByAccountNumber(accountNumber, processId);
		return result;
	}
	
	// @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Backend failure") 
	//@ExceptionHandler(value = SOAPFaultException.class)
	@ExceptionHandler(value = CSOBClientSearchRuntimeException.class)
	public ResponseEntity<ErrorInfo> handleClientSearchFault(HttpServletRequest request, Exception searchException) {
		LOG.debug("Entering to REST service exception handling with exception: ", searchException.getClass().getName());
		String stackTrace = org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(searchException);
		ErrorInfo errInfo = new ErrorInfo();
		if (searchException.getCause() instanceof SOAPFaultException) {
			errInfo.setErrorCode("BACKEND");
			errInfo.setErrorMessage(searchException.getMessage());
			errInfo.setStackTrace(stackTrace);
		} else {
			errInfo.setErrorCode("SERVICE");
			errInfo.setErrorMessage(searchException.getMessage());
			errInfo.setStackTrace(stackTrace);
		}
		LOG.debug("Final ErrorInfo for REST service exception handler: " + errInfo.toString());
		return new ResponseEntity<ErrorInfo>(errInfo, HttpStatus.INTERNAL_SERVER_ERROR);
	    // return errInfo; 
	}

	
	public Long getUserIdByUserName(String username) {
		UriComponentsBuilder uriBuilder = UriComponentsUtils.createFindUserBuilder(username);

		UserList value = getTemplate().getResult(uriBuilder, HttpMethod.GET, UserList.class);

		GetPriorityTaskResponse resp = new GetPriorityTaskResponse();
		if (value != null && value.getData() != null && value.getData().getItems() != null
				&& value.getData().getItems().size() > 0) {

			UserListItem firstItem = value.getData().getItems().get(0);

			LOG.debug("Result User: {}", firstItem.getId());
			return firstItem.getId();

		} else {
			LOG.debug("getUserIdByUserName result empty: {}", username);
			return null;
		}
	}


}
