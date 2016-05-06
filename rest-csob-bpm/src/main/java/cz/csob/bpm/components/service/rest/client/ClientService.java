package cz.csob.bpm.components.service.rest.client;

import org.springframework.web.bind.annotation.RequestParam;

import cz.csob.bpm.components.fes.rest.dto.client.ClientListData;

public interface ClientService {
	
	/**
	 * 
	 * @param cuid
	 * @return
	 */
	ClientListData getClientListByCuid(String cuid);	
	
	/**
	 * 
	 * @param ippid
	 * @return
	 */
	ClientListData getClientListByIppid(String ippid);
	
	/**
	 * 
	 * @param accountNumber
	 * @return
	 */
	ClientListData getClientListByAccountNumber(String accountNumber);
	
	/**
	 * 
	 * @param accountNumber
	 * @return
	 */
	ClientListData getDisponentListByAccountNumber(String accountNumber, String processId);
	

}
