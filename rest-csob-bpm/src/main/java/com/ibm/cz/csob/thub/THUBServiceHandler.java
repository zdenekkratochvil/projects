package com.ibm.cz.csob.thub;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.resource.spi.security.PasswordCredential;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecUsernameToken;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ibm.websphere.security.NotImplementedException;
import com.ibm.wsspi.security.auth.callback.Constants;
import com.ibm.wsspi.security.auth.callback.WSMappingCallbackHandlerFactory;


/**
 * Custom SOAP Message handler for T-HUB service calls.
 * 
 * This SOAP Message handler covers two key tasks:
 * <ul>
 * 	<li>Add WS-Security UserName token with password type Digest</li>
 *  <li>Monitor T-HUB service invocation status</li> 
 * </ul>
 * 
 * @author Jiri Melichna
 *
 */
public class THUBServiceHandler implements SOAPHandler<SOAPMessageContext> {
	
	private static Logger log = Logger.getLogger(THUBServiceHandler.class);
	
	private static final String START_TIME_KEY = "callStartTime";
	
	private static final String OPERATION_NAME_KEY = "opName";
	
	private static final String BUID_KEY = "callBuid";
	
	private static final String AUTH_ALIAS_NAME = "ThubJ2CAlias";
	
	ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	@Override
	public void close(MessageContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		log.debug("THUBServiceHandler handleFault...");
        Long startTime = (Long) context.get(START_TIME_KEY);
        String requestName = (String) context.get(OPERATION_NAME_KEY);
        String buid = (String) context.get(BUID_KEY);		
        if ((startTime != null) && (requestName != null)) {
            // log.info("Response time (" + serviceName + "): " + (System.currentTimeMillis() - startTime.get()) + " ms");
        	// System.err.println("CALL-FAIL: Business Transaction: " + buid + " for request: " + requestName + " was processed: " + (System.currentTimeMillis() - startTime.longValue()) + " ms");
        	log.info("CALL-FAIL: " + requestName + ": Transaction: " + buid + " resp. time: " + (System.currentTimeMillis() - startTime.longValue()) + " ms");
        }
		return true;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		log.debug("THUBServiceHandler handleMessage...");
		Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty.booleanValue()) {
        	// Request processing
        	log.debug("THUBServiceHandler try to process request message");
        	SOAPMessage soapMessage = context.getMessage();
        	
        	try {
	        	// Prepare correlation properties - service call identification
	            NodeList buidList = soapMessage.getSOAPHeader().getElementsByTagNameNS("http://ed6.kbc.com/metaheader.1", "BusinessUniqueID");
	            Node buidNode = buidList.item(0);
	            String buid = buidNode.getTextContent();
	            NodeList bodyList = soapMessage.getSOAPBody().getChildNodes();
	            Node bodyNode = bodyList.item(0);
	            String requestName = bodyNode.getNodeName();
	            log.debug("THUBServiceHandler will monitor BUID: " + buid + " for " + requestName);
            
	            // Read authentication data for T-HUB call from J2C Authentization alias
            	ServiceCredentials srvCred = getCfgCredentials();            	
            	if (srvCred != null) { 
          
	                // Add UserName token with password type Digest which is not supported in WAS at this moment
	                SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
	                SOAPHeader soapHeader = soapEnvelope.getHeader();
	                if (soapHeader == null) {
	                    soapHeader = soapEnvelope.addHeader();
	                }
	                WSSecHeader secHeader = new WSSecHeader();
	                secHeader.insertSecurityHeader(soapEnvelope.getOwnerDocument());
	                WSSecUsernameToken builder = new WSSecUsernameToken();
	                builder.setPasswordType(WSConstants.PASSWORD_DIGEST);
	                builder.addNonce();
	                builder.setUserInfo(srvCred.getUserName(), srvCred.getPassword());
	                builder.build(soapEnvelope.getOwnerDocument(), secHeader);
	                	                
	                // Store changes to SOAP request
	                soapMessage.saveChanges();
            	} else {
            		log.debug("THUBServiceHandler was not able to retrieve J2C authentication alias " + AUTH_ALIAS_NAME);      
            	}
            	
                // Store shared ctx data to context for reuse on response processing
                Long startTime = Long.valueOf(System.currentTimeMillis()); 
                context.put(START_TIME_KEY, startTime);
                context.put(BUID_KEY, buid);
                context.put(OPERATION_NAME_KEY, requestName);
            	
                if (log.isDebugEnabled()) {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    soapMessage.writeTo(outputStream);
                    log.debug("Request: " + outputStream.toString("UTF-8"));
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        } else {
        	// Response processing
            try {
                SOAPMessage soapMessage = context.getMessage();
                log.debug("THUBServiceHandler proces service response message...");
                Long startTime = (Long) context.get(START_TIME_KEY);
                String requestName = (String) context.get(OPERATION_NAME_KEY);
                String buid = (String) context.get(BUID_KEY);		
                if ((startTime != null) && (requestName != null)) {
                	log.info("CALL-OK: " + requestName + ": Transaction: " + buid + " resp. time: " + (System.currentTimeMillis() - startTime.longValue()) + " ms");
                }
                if (log.isDebugEnabled()) {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    soapMessage.writeTo(outputStream);
                    log.debug("Serivice response: " + outputStream.toString("UTF-8"));
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return true;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Container class for J2C authentization data 
	 * @author Jiri Melichna
	 *
	 */
	public class ServiceCredentials {
		protected String userName;
		
		protected String password;
		
		public String getUserName() {
			return userName;
		}

		public String getPassword() {
			return password;
		}
		
		public ServiceCredentials() {
			super();
		}
		
		public ServiceCredentials(String userName, String password) {
			super();
			this.userName = userName;
			this.password = password;
		}

		@Override
		public String toString() {
			return "ServiceCredentials [userName=" + userName + "]";
		}
		
	}
	
	/**
	 * Read Username and Password for WebService call from WAS configuration (J2C alias)
	 * @return ServiceCredentials
	 */
	private ServiceCredentials getCfgCredentials() {
		log.debug("Try to read J2C Alias: " + AUTH_ALIAS_NAME);
		Map map = new HashMap();
		ServiceCredentials serviceCredentials = null;
		map.put(Constants.MAPPING_ALIAS, AUTH_ALIAS_NAME);
		LoginContext loginContext;
		try {
			CallbackHandler callbackHandler = WSMappingCallbackHandlerFactory.getInstance().getCallbackHandler(map, null);

			loginContext = new LoginContext("DefaultPrincipalMapping", callbackHandler);
			loginContext.login();
			Subject subject = loginContext.getSubject();
			Set credentials = subject.getPrivateCredentials();

			PasswordCredential passwordCredential = (PasswordCredential) credentials.iterator().next();

			String user = passwordCredential.getUserName();
			String password = new String(passwordCredential.getPassword());
			log.debug("Auth alias " + AUTH_ALIAS_NAME + " contains: " + user);
			serviceCredentials = new ServiceCredentials(user, password);			
		} catch (LoginException e) {
			log.error("Auth alias retrival error: " + e.getMessage(), e);
		} catch (NotImplementedException e) {
			log.error("Auth alias retrival error: " + e.getMessage(), e);
		}
		return serviceCredentials;
	}

}
