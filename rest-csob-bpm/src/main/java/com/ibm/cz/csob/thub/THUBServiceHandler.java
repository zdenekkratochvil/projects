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

// import com.ibm.cz.swg.jme.TestDr.ServiceCredentials;
import com.ibm.websphere.security.NotImplementedException;
import com.ibm.wsspi.security.auth.callback.Constants;
import com.ibm.wsspi.security.auth.callback.WSMappingCallbackHandlerFactory;


/**
 * Custom SOAP Message handler for T-HUB service calls.
 * 
 * This SOAP Message handler covers two key tasks:
 * <ul>
 * 	<li>Add WS-Security UserName token</li>
 *  <li>Measure T-HUB service response time</li> 
 * </ul>
 * 
 * @author Jiri Melichna
 *
 */
public class THUBServiceHandler implements SOAPHandler<SOAPMessageContext> {

}
