package cz.csob.bpm.components.service.security;

import javax.security.auth.Subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ibm.websphere.security.auth.WSSubject;
import com.ibm.websphere.security.web.WebSecurityHelper;

/**
 * LTPA token provider implementation for Websphere app server
 * @author Zack
 *
 */
@Profile("!local")
@Component
public class WASLTPATokenProvider implements ILTPATokenProvider {

	private static final Logger LOG = LoggerFactory.getLogger(WASLTPATokenProvider.class);
	
	@Override
	public String provide() {
		return retrieveSecurityToken();
	}

	private String retrieveSecurityToken() {
		Subject callerSubject = null;
		Subject runAsSubject = null;
		
		try {
			callerSubject = WSSubject.getCallerSubject();
			runAsSubject = WSSubject.getRunAsSubject();
			return WebSecurityHelper.getSSOCookieFromSSOToken().getValue();
		} catch (Exception e) {
			LOG.error(String.format("LTPA binary key not retrieved. Debug data: \nCallerSubject %s, \nRunAsSubject: %s", callerSubject, runAsSubject));
			throw new SecurityException("LTPA binary token could not be retrieved from the current security context!");
		}
	}

	@Override
	public String getPrincipalName() {
		Subject callerSubject = null;		
		try {
			callerSubject = WSSubject.getCallerSubject();
			return callerSubject.getPrincipals().iterator().next().getName();
		} catch (Exception e) {
			LOG.error(String.format("LTPA binary key not retrieved. Debug data: \nCallerSubject %s: %s", callerSubject));
			throw new SecurityException("LTPA binary token could not be retrieved from the current security context!");
		}
	}
	
}
