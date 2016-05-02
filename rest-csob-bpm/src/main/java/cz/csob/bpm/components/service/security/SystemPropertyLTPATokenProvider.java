package cz.csob.bpm.components.service.security;

import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Mock implementation used for development outside WAS
 * @author Zack
 *
 */
@Profile("local")
@Component
public class SystemPropertyLTPATokenProvider implements ILTPATokenProvider {

	private static final String LTPA_TOKEN2 = "LtpaToken2";

	@Override
	public String provide() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		if(requestAttributes != null) {
			Cookie[] cookies = requestAttributes.getRequest().getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(LTPA_TOKEN2.equals(cookie.getName())) {
						return cookie.getValue();
					}
				}
			}
		}
		
		return System.getProperty("security.ltpa");
	}

	@Override
	public String getPrincipalName() {
		return System.getProperty("security.principalName");
	}

}
