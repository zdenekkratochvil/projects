package cz.csob.bpm.components.service.rest.client.impl;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ibm.cz.csob.thub.THUBCallSequence;
import com.ibm.cz.csob.thub.THUBServiceHandler;

import cz.csob.bpm.components.fes.rest.dto.client.AccountRole;
import cz.csob.bpm.components.fes.rest.dto.client.Address;
import cz.csob.bpm.components.fes.rest.dto.client.ClientListData;
import cz.csob.bpm.components.fes.rest.dto.client.ClientListItem;
import cz.csob.bpm.components.service.rest.client.ClientService;
import cz.csob.thub.ws.clients.clientlist.GetClientListReq;
import cz.csob.thub.ws.clients.clientlist.GetClientListReq.Data.Requestset;
import cz.csob.thub.ws.clients.clientlist.GetClientListReq.Data.Requestset.Request;
import cz.csob.thub.ws.clients.clientlist.GetClientListRes;
import cz.csob.thub.ws.clients.clientlist.GetClientListRes.Data.Resultset.Result;
import cz.csob.thub.ws.clients.clientlist.GetClientListRes.Data.Resultset.Result.Company;
import cz.csob.thub.ws.clients.clientlist.GetClientListRes.Data.Resultset.Result.Company.CompanyRow;
import cz.csob.thub.ws.clients.clientlist.GetClientListRes.Data.Resultset.Result.Person;
import cz.csob.thub.ws.clients.clientlist.GetClientListRes.Data.Resultset.Result.Person.PersonRow;
import cz.csob.thub.ws.clients.clientlist.GetClientList_v2HttpProxy;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductReq;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductReq.ProductFilterList;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductReq.ProductFilterList.ProductFilter;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductRes;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductRes.Resultset.Result.RightList;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductRes.Resultset.Result.RightList.Right;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductRes.Resultset.Result.RightList.Right.DisponentList;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductRes.Resultset.Result.RightList.Right.DisponentList.Disponent;
import cz.csob.thub.ws.clients.disprights.GetDrListByProduct_v1HttpProxy;

@Component("THUBClientService")
public class ClientServiceThub implements ClientService {
	
	private static Logger log = Logger.getLogger(ClientServiceThub.class);
	
	// Constants for THUB MetaHeader generation
	private static final BigInteger HEADER_ID = BigInteger.valueOf(1);
	private static final BigInteger COMPANY_ID = BigInteger.valueOf(1);
	private static final String SYSTEM_ID = "DMBPM";
	private static final String CALL_ID = "REST";
	
	@Value("${csob.thub.ws.drlist.url}")
	String drListEndpointUrl;

	@Value("${csob.thub.ws.clilist.url}")
	String cliListEndpointUrl;
	
	@Value("${bpm.default.thub.userid}")
	String defaultTHUBUser;

	
	@Override
	public ClientListData getClientListByCuid(String cuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientListData getClientListByIppid(String ippid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientListData getClientListByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientListData getDisponentListByAccountNumber(String accountNumber) {
		log.debug("Entering getDisponentListByAccountNumber with accountNumber = " + accountNumber);
		
		if ((accountNumber == null) || ("".equals(accountNumber))) {
			//throw new CSOBBPMException("AccountNumber is not provided. Please provide account number.");
		}
		
		// TODO should be parameter of the call - can be null
		//String piid = "1587898";
		String piid = null;
		
		ClientListData clientListData = null;
		
		// Init proxies - set endpoint and handler
		GetDrListByProduct_v1HttpProxy drListProxy = setupGetDrListByProduct();
		GetClientList_v2HttpProxy cliListProxy = setupGetGetClientList();
		
		cz.csob.thub.ws.clients.disprights.MetaHeader drListMetaHeader = getDrListMetaheader(piid);
		
		log.debug("Set GetDrListByProduct data...");
		GetDrListByProductReq getDrListByProductReq = new GetDrListByProductReq();
		ProductFilterList filterList = new ProductFilterList();
		ProductFilter productFilter = new ProductFilter();
		
		// TODO should be call parameter 
		//productFilter.setProductNumber("9934715");
		//productFilter.setProductNumber("9946126");
		productFilter.setProductNumber(accountNumber);
		
		// GetDrByProductNumber call constants
		productFilter.setHomeCurrency(BigInteger.valueOf(39));
		productFilter.setBankSystem(BigInteger.valueOf(2));
		RightTypeList rightTypeList = new RightTypeList();
		rightTypeList.getRightType().add(BigInteger.valueOf(2));
		productFilter.setRightTypeList(rightTypeList);
		filterList.getProductFilter().add(productFilter);
		getDrListByProductReq.setProductFilterList(filterList);
		
		try {
			GetDrListByProductRes dispList = drListProxy.getDrListByProductV1(getDrListByProductReq, drListMetaHeader);
			BigInteger accountOwnerId = dispList.getResultset().getResult().get(0).getCuid();
			if (accountOwnerId != null) {
				
				// Account owner CUID is returned in direct data
				log.debug("Found account owner CUID: " + accountOwnerId.toString());	
									
				cz.csob.thub.ws.clients.clientlist.MetaHeader cliListListMetaHeader = getCliListMetaheader(piid);
				GetClientListReq getClientListReqV2 = getCliListReq(accountOwnerId);
				try {
					GetClientListRes ownerList = cliListProxy.getClientListV2(getClientListReqV2, cliListListMetaHeader);
					// Result cliListResult = ownerList.getData().getResultset().getResult().get(0);
					List<Result> drListResult = ownerList.getData().getResultset().getResult();
					
					//for (Result cliListResult : ownerList.getData().getResultset().getResult()) {
					if (!drListResult.isEmpty()) {		
						Result drResult = drListResult.get(0);
						log.debug("Account owner found");
						
						clientListData = new ClientListData();
						ArrayList<ClientListItem> clientList = new ArrayList<ClientListItem>();						
						
						ClientListItem ownerClientListItem = mapClientToVO(drResult, accountNumber, "owner");
						if (ownerClientListItem != null) {
							clientList.add(ownerClientListItem);
						}	
					    
						// Iterate over all disponents 
						for (cz.csob.thub.ws.clients.disprights.GetDrListByProductRes.Resultset.Result dispRightResult : dispList.getResultset().getResult()) {
							RightList rightList = dispRightResult.getRightList();							
							for (Right right : rightList.getRight()) {
								DisponentList disponentsList = right.getDisponentList();
								for (Disponent disponent : disponentsList.getDisponent()) {
									BigInteger disponentId = disponent.getIdCmdPartyPk();
									log.debug("Found disponent " + disponentId);
									cliListListMetaHeader = getCliListMetaheader(piid);
									getClientListReqV2 = getCliListReq(disponentId);
									try {
										GetClientListRes dispPersonList = cliListProxy.getClientListV2(getClientListReqV2, cliListListMetaHeader);
										// Result cliListResult = ownerList.getData().getResultset().getResult().get(0);
										List<Result> dispListResult = dispPersonList.getData().getResultset().getResult();
										if (!dispListResult.isEmpty()) {		
											Result disponentResult = dispListResult.get(0);
											log.debug("Disponent found");
											ClientListItem disponentClientListItem = mapClientToVO(disponentResult, accountNumber, "delegate");
											if (disponentClientListItem != null) {
												clientList.add(disponentClientListItem);
											}	
										}										
									} catch (cz.csob.thub.ws.clients.clientlist.GeneralFaultV1 clfe) {
										log.error("THUB Service GetClientList_v2 failed for CUID: ", clfe);			
									}
								}
							}
						}						
						clientListData.setClientList(clientList);						
					}
				} catch (cz.csob.thub.ws.clients.clientlist.GeneralFaultV1 clfe) {
					log.error("THUB Service GetClientList_v2 failed for CUID: ", clfe);			
				}
			}			
		} catch (cz.csob.thub.ws.clients.disprights.GeneralFaultV1 drlfe) {
			log.error("THUB Service GetDrListByProduct failed ", drlfe);
		}
		
		return clientListData;
	}

	private ClientListItem mapClientToVO(Result drResult, String accountNumber, String roleType) {
		ClientListItem clientListItem = null;
		Company companyOwner = drResult.getCompany();
		Person personOwner = drResult.getPerson();						
		if (personOwner != null) {
			PersonRow personRow = personOwner.getPersonRow().get(0); 
			log.debug("Found person type Physical Person " + personOwner.getPersonRow().get(0).getIdCmdPartyPk());
			clientListItem = new ClientListItem();
			clientListItem.setCuid(personRow.getIdCmdPartyPk().toString());
			clientListItem.setType("physical");
			clientListItem.setFirstName(personRow.getName());
			clientListItem.setLastName(personRow.getSurname());
			clientListItem.setBirthNumber(personRow.getFictBirthNumber());
			//clientListItem.setBirthDate(personRow.getDateOfBirth());
			if (personRow.getDateOfBirth() != null) {
				log.debug("Date of Birth " + personRow.getDateOfBirth().toString() + " - " + personRow.getDateOfBirth().toGregorianCalendar().getTime());
				Date birthDate = personRow.getDateOfBirth().toGregorianCalendar().getTime();
				clientListItem.setBirthDate(birthDate);
			}
			
			// Address
			Address basicAddress = new Address();
			basicAddress.setStreet(personRow.getStreet());
			basicAddress.setCity(personRow.getCity());			
			basicAddress.setPostCode(personRow.getPostalCode());			
			ArrayList<Address> addressList = new ArrayList<Address>();
			addressList.add(basicAddress);			
			clientListItem.setAddresses(addressList);
			
			// Account Role
			ArrayList<AccountRole> accountRoleList = new ArrayList<AccountRole>();
			AccountRole accountRole = new AccountRole();
			accountRole.setAccountNumber(accountNumber);
			accountRole.setRoleType(roleType);
			accountRoleList.add(accountRole);
			clientListItem.setAccountRoles(accountRoleList);
		} else {
			CompanyRow companyRow = companyOwner.getCompanyRow().get(0);
			log.debug("Found person type Legal Person " + companyOwner.getCompanyRow().get(0).getIdCmdPartyPk());
			clientListItem = new ClientListItem();
			clientListItem.setCuid(companyRow.getIdCmdPartyPk().toString());
			clientListItem.setType("legal");
			clientListItem.setCompanyName(companyRow.getNameOfCompanyLong());
			clientListItem.setCompanyGovIdNumber(companyRow.getFictIdNumber());
			
			// Address processing
			Address basicAddress = new Address();
			basicAddress.setStreet(companyRow.getStreet());
			basicAddress.setCity(companyRow.getCity());			
			basicAddress.setPostCode(companyRow.getPostalCode());			
			ArrayList<Address> addressList = new ArrayList<Address>();
			addressList.add(basicAddress);			
			clientListItem.setAddresses(addressList);
			
			// Account Role
			ArrayList<AccountRole> accountRoleList = new ArrayList<AccountRole>();
			AccountRole accountRole = new AccountRole();
			accountRole.setAccountNumber(accountNumber);
			accountRole.setRoleType(roleType);
			accountRoleList.add(accountRole);
			clientListItem.setAccountRoles(accountRoleList);
		}
		return clientListItem;
	}

	private GetClientListReq getCliListReq(BigInteger cuid) {
		GetClientListReq getClientListReqV2 = new GetClientListReq();
		cz.csob.thub.ws.clients.clientlist.GetClientListReq.Data clientListReqData = new cz.csob.thub.ws.clients.clientlist.GetClientListReq.Data();
		Requestset clientListReqSet = new Requestset();
		Request clientListReqRequest = new Request();
		clientListReqRequest.setIdCmdPartyPk(cuid);
		clientListReqSet.getRequest().add(clientListReqRequest);			
		clientListReqData.setRequestset(clientListReqSet);
		getClientListReqV2.setData(clientListReqData);
		return getClientListReqV2;
	}

	private GetDrListByProduct_v1HttpProxy setupGetDrListByProduct() {
		GetDrListByProduct_v1HttpProxy drListProxy = new GetDrListByProduct_v1HttpProxy();
		//https://a-thub-dmsucf.cz.int.intapp.eu:7519/services/distribution/ClientIdentification/getClientList/v2		
	
		// TODO Add read from cfg		
		drListProxy._getDescriptor().setEndpoint(drListEndpointUrl);
		//drListProxy._getDescriptor().setEndpoint("http://W2AB0095:8080/cmdb/getdrlistbyproduct_v1");

		// Add SOAP Handler for T-HUB invocation
		BindingProvider proxyBindingProvider = (BindingProvider) drListProxy._getDescriptor().getProxy();
		Binding proxyBinding = proxyBindingProvider.getBinding();
		List<Handler> handlerChain = proxyBinding.getHandlerChain();
		if (handlerChain == null) {			
			handlerChain = new ArrayList<Handler>();
		}	
		handlerChain.add(new THUBServiceHandler());
		proxyBinding.setHandlerChain(handlerChain);
		log.debug("SOAP Handler for T-HUB invocation set. Service endpoint: " + drListProxy._getDescriptor().getEndpoint());
		return drListProxy;
	}
	
	private GetClientList_v2HttpProxy setupGetGetClientList() {
		GetClientList_v2HttpProxy cliListProxy = new GetClientList_v2HttpProxy();
		//https://a-thub-dmsucf.cz.int.intapp.eu:7519/services/distribution/ClientIdentification/getClientList/v2		
	
		// TODO Add read from cfg
		cliListProxy ._getDescriptor().setEndpoint(cliListEndpointUrl);

		// Add SOAP Handler for T-HUB invocation
		BindingProvider proxyBindingProvider = (BindingProvider) cliListProxy ._getDescriptor().getProxy();
		Binding proxyBinding = proxyBindingProvider.getBinding();
		List<Handler> handlerChain = proxyBinding.getHandlerChain();
		if (handlerChain == null) {			
			handlerChain = new ArrayList<Handler>();
		}	
		handlerChain.add(new THUBServiceHandler());
		proxyBinding.setHandlerChain(handlerChain);
		log.debug("SOAP Handler for T-HUB invocation set. Service endpoint: " + cliListProxy ._getDescriptor().getEndpoint());
		return cliListProxy;
	}
	
	private cz.csob.thub.ws.clients.disprights.MetaHeader getDrListMetaheader(String piid) {
		
		cz.csob.thub.ws.clients.disprights.MetaHeader metaHeader = new cz.csob.thub.ws.clients.disprights.MetaHeader();
		metaHeader.setHeaderVersion(HEADER_ID);
		// TODO Extend call with ProcessId
		String sessionId = generateSessionID(piid, CALL_ID);
		//metaHeader.setSessionID("NynnDMUCFfnappczfetinta800000022");
		metaHeader.setSessionID(sessionId);
		String businessSessionId = generateBusinessSessionID(piid, CALL_ID);
		//metaHeader.setBusinessUniqueID("NynnDMUCFfnappczfetinta800000022");
		metaHeader.setBusinessUniqueID(businessSessionId);
		cz.csob.thub.ws.clients.disprights.OriginalSource origSrc = new cz.csob.thub.ws.clients.disprights.OriginalSource();
		try {
			GregorianCalendar currentCal = new GregorianCalendar();
			XMLGregorianCalendar timeStamp;
			timeStamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(currentCal);
			origSrc.setTimeStamp(timeStamp);
		} catch (DatatypeConfigurationException dce) {
			log.error("Problem to generate GregorianCalendar. Probably the THUB call will fail", dce);			
		}
		origSrc.setSystem(SYSTEM_ID);
		origSrc.setCompany(COMPANY_ID);
		
		// TODO Add correct mapped User ID
		origSrc.setUser(defaultTHUBUser);
		metaHeader.setOriginalSource(origSrc);

		return metaHeader;
		
	}

	private cz.csob.thub.ws.clients.clientlist.MetaHeader getCliListMetaheader(String piid) {
		
		cz.csob.thub.ws.clients.clientlist.MetaHeader metaHeader = new cz.csob.thub.ws.clients.clientlist.MetaHeader();
		metaHeader.setHeaderVersion(HEADER_ID);
		// TODO Extend call with ProcessId
		String sessionId = generateSessionID(piid, CALL_ID);
		//metaHeader.setSessionID("NynnDMUCFfnappczfetinta800000022");
		metaHeader.setSessionID(sessionId);
		String businessSessionId = generateBusinessSessionID(piid, CALL_ID);
		//metaHeader.setBusinessUniqueID("NynnDMUCFfnappczfetinta800000022");
		metaHeader.setBusinessUniqueID(businessSessionId);
		cz.csob.thub.ws.clients.clientlist.OriginalSource origSrc = new cz.csob.thub.ws.clients.clientlist.OriginalSource();
		try {
			GregorianCalendar currentCal = new GregorianCalendar();
			XMLGregorianCalendar timeStamp;
			timeStamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(currentCal);
			origSrc.setTimeStamp(timeStamp);
		} catch (DatatypeConfigurationException dce) {
			log.error("Problem to generate GregorianCalendar. Probably the THUB call will fail", dce);			
		}
		origSrc.setSystem(SYSTEM_ID);
		origSrc.setCompany(COMPANY_ID);
		
		// TODO Add correct mapped User ID
		origSrc.setUser(defaultTHUBUser);
		metaHeader.setOriginalSource(origSrc);

		return metaHeader;
		
	}

	/**
	 * Generate SessionID for T-HUB call
	 * @param processId - callId have to be send by BPM client to identify set of calls
	 * @param callId - callId can be send by client to identify call place
	 * @return sessionId - session for service call
	 */
	private String generateSessionID(String processId, String callId) {
		StringBuilder sessionIdSB = new StringBuilder();
		
		String _processId = processId;
		if ((processId == null) || "".equals(processId))
			// Generate random number when processId is not provided
			_processId = RandomStringUtils.randomNumeric(9);
		
		String _callId = callId; 				
		if ((callId == null) || "".equals(callId))
			_callId = "SRVR";
		
		sessionIdSB.append(_callId);
		sessionIdSB.append(SYSTEM_ID);
		
		String hostName;
		try {
			hostName = InetAddress.getLocalHost().getHostName();
			log.debug("Hostname for T-HUB call: " + hostName);
			hostName = hostName.replaceAll("[^a-zA-Z0-9]", "");
			if (hostName.length() > 10) { 
				hostName = hostName.substring(0, 10);
			}			
		} catch (UnknownHostException e) {
			hostName = "notfound";
			log.warn("T-HUB header has no node info, because host name can't be resolved.", e);
		}		
		sessionIdSB.append(hostName);		
		sessionIdSB.append(_processId);
		
		// sessionIdSB.append(RandomStringUtils.randomNumeric(23 - hostName.length() - 8));
		
		int currentLenght = sessionIdSB.length();		
		int maxLenght = 32;
		String newCallId = String.valueOf(THUBCallSequence.getInstance().getNewCallId());
		//int requiredPaddLenght = maxLenght - currentLenght - newCallId.length()+1;
		int requiredPaddLenght = maxLenght - currentLenght;
		if (requiredPaddLenght + currentLenght > 32) {
			log.warn("T-HUB sequence lenght exeeded. T-HUB invocation will fail. Restat of this application can help - it will reset the sequence.");
			requiredPaddLenght = 0;
		}
		
		//String newCallIdS = padRight(newCallId, requiredPaddLenght);		
		String newCallIdS = StringUtils.leftPad(newCallId, requiredPaddLenght, '0');

		if (log.isDebugEnabled()) {
			log.debug("SessionID construction: currentIdSB: " + sessionIdSB + "(" + currentLenght + "), newCallId: " + newCallId + " newCallIdS: " + newCallIdS + "(" + newCallIdS.length() + ") -> requiredPaddLenght: " + requiredPaddLenght);
		}			

		sessionIdSB.append(newCallIdS);

		
		String sessionId = sessionIdSB.toString();
		log.debug("Generated SessionId for T-HUB call: " + sessionId + "(" + sessionId.length() + ")");
		return sessionId;
	}
	
	/**
	 * Generate SessionID for T-HUB call
	 * @param processId - callId have to be send by BPM client to identify set of calls
	 * @param callId - callId can be send by client to identify call place
	 * @return sessionId - session for service call
	 */
	private String generateBusinessSessionID(String processId, String callId) {
		StringBuilder sessionIdSB = new StringBuilder();
		
		String _processId = processId;
		if ((processId == null) || "".equals(processId))
			// Generate random number when processId is not provided
			_processId = RandomStringUtils.randomNumeric(10);
		
		String _callId = callId; 				
		if ((callId == null) || "".equals(callId))
			_callId = "SRVR";
		
		sessionIdSB.append(_callId);
		sessionIdSB.append(SYSTEM_ID);		
		sessionIdSB.append(_processId);
		
		// sessionIdSB.append(RandomStringUtils.randomNumeric(23 - hostName.length() - 8));		 
		String sessionId = sessionIdSB.toString();
		log.debug("Generated Business Session Id for T-HUB call: " + sessionId);
		return sessionId;
	}
}
