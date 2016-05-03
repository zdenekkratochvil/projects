package cz.csob.bpm.components.service.rest.client.impl;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
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

import com.ibm.cz.csob.thub.THUBCallSequence;
import com.ibm.cz.csob.thub.THUBServiceHandler;

import cz.csob.bpm.components.fes.rest.dto.client.ClientListData;
import cz.csob.bpm.components.service.rest.client.ClientService;
import cz.csob.thub.ws.clients.disprights.GeneralFaultV1;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductReq;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductReq.ProductFilterList;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductReq.ProductFilterList.ProductFilter;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductReq.ProductFilterList.ProductFilter.RightTypeList;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductRes;
import cz.csob.thub.ws.clients.disprights.GetDrListByProductRes.Resultset.Result.RightList;
import cz.csob.thub.ws.clients.disprights.GetDrListByProduct_v1HttpProxy;
import cz.csob.thub.ws.clients.disprights.MetaHeader;
import cz.csob.thub.ws.clients.disprights.OriginalSource;

public class ClientServiceThub implements ClientService {
	
	private static Logger log = Logger.getLogger(ClientServiceThub.class);

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
		GetDrListByProduct_v1HttpProxy drListProxy = new GetDrListByProduct_v1HttpProxy();
		
		// TODO Add read from cfg
		drListProxy._getDescriptor().setEndpoint("https://a-thub-dmsbpm.cz.int.intapp.eu:7519/services/distribution/DispositionalRights/getDrListByProduct/v1");

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
		
		MetaHeader metaHeader = new MetaHeader();
		metaHeader.setHeaderVersion(BigInteger.valueOf(1));
		// TODO Extend call with ProcessId
		String sessionId = generateSessionID("1587898", "P001");
		//metaHeader.setSessionID("NynnDMUCFfnappczfetinta800000022");
		metaHeader.setSessionID(sessionId);
		//metaHeader.setBusinessUniqueID("121212121212");
		String businessSessionId = generateBusinessSessionID("1587898", "P001");
		// metaHeader.setBusinessUniqueID("NynnDMUCFfnappczfetinta800000022");
		metaHeader.setBusinessUniqueID(businessSessionId);
		OriginalSource origSrc = new OriginalSource();
		try {
			GregorianCalendar currentCal = new GregorianCalendar();
			XMLGregorianCalendar timeStamp;
			timeStamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(currentCal);
			origSrc.setTimeStamp(timeStamp);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		origSrc.setSystem("DMBPM");
		origSrc.setCompany(BigInteger.valueOf(1));
		
		// TODO Add correct mapped User ID
		origSrc.setUser("0");
		metaHeader.setOriginalSource(origSrc);
		
		log.debug("Set GetDrListByProduct data...");
		GetDrListByProductReq getDrListByProductReq = new GetDrListByProductReq();
		ProductFilterList filterList = new ProductFilterList();
		ProductFilter productFilter = new ProductFilter();
		productFilter.setProductNumber("9934715");
		//productFilter.setProductNumber("9946126");
		productFilter.setHomeCurrency(BigInteger.valueOf(39));
		productFilter.setBankSystem(BigInteger.valueOf(2));
		RightTypeList rightTypeList = new RightTypeList();
		rightTypeList.getRightType().add(BigInteger.valueOf(2));
		productFilter.setRightTypeList(rightTypeList);
		filterList.getProductFilter().add(productFilter);
		
		try {
			GetDrListByProductRes dispList = drListProxy.getDrListByProductV1(getDrListByProductReq, metaHeader);
			
			RightList rightList = (RightList) dispList.getResultset().getResult().get(0).getRightList();
			log.debug("Found right: " + rightList.getRight().get(0).getIdCmdRight());
			
		} catch (GeneralFaultV1 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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
			_processId = RandomStringUtils.randomNumeric(10);
		
		String _callId = callId; 				
		if ((callId == null) || "".equals(callId))
			_callId = "SRVR";
		
		sessionIdSB.append(_callId);
		sessionIdSB.append("DMBPM");
		
		String hostName;
		try {
			hostName = InetAddress.getLocalHost().getHostName();
			System.out.println("Hostname for T-HUB call: " + hostName);
			hostName = hostName.replaceAll("[^a-zA-Z0-9]", "");
			if (hostName.length() > 10) { 
				hostName = hostName.substring(0, 10);
			}
			System.out.println("Hostname for T-HUB call: " + hostName);
		} catch (UnknownHostException e) {
			hostName = "notfound";
			e.printStackTrace();
		}		
		sessionIdSB.append(hostName);		
		sessionIdSB.append(_processId);
		
		// sessionIdSB.append(RandomStringUtils.randomNumeric(23 - hostName.length() - 8));
		
		int currentLenght = sessionIdSB.length();
		System.out.println("Current leght: " + sessionIdSB.length());
		int maxLenght = 32;
		String newCallId = String.valueOf(THUBCallSequence.getInstance().getNewCallId());
		int requiredPaddLenght = maxLenght - currentLenght - newCallId.length()+1;
		if (requiredPaddLenght <= 0) {
			System.err.println("T-HUB sequence lenght exeeded. T-HUB invocation can fail. Restat of application can help - it will reset the sequence.");
			requiredPaddLenght = 0;
		}
		
		//String newCallIdS = padRight(newCallId, requiredPaddLenght);
		String newCallIdS = StringUtils.leftPad(newCallId, requiredPaddLenght, '0');
		sessionIdSB.append(newCallIdS);
		
		System.out.println("Current leght: " + sessionIdSB.length() + " CallID: " + newCallId + " time: " + System.currentTimeMillis());
		
		String sessionId = sessionIdSB.toString();
		System.out.println("Generated SessionId for T-HUB call: " + sessionId + "(" + sessionId.length() + ")");
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
		sessionIdSB.append("DMBPM");
		
		sessionIdSB.append(_processId);
		
		long newCallId = THUBCallSequence.getInstance().getNewCallId();
		
		// sessionIdSB.append(RandomStringUtils.randomNumeric(23 - hostName.length() - 8));
		 
		System.out.println("CallID: " + newCallId + " time: " + System.currentTimeMillis());
		
		String sessionId = sessionIdSB.toString();
		System.out.println("Generated SessionId for T-HUB call: " + sessionId);
		return sessionId;
	}
}
