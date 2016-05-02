package cz.csob.bpm.components.service.security;

/**
 * Provide LTPAToken2 hash for BPM application authentication
 * 
 * @author Zack
 *
 */
public interface ILTPATokenProvider {

	/**
	 * @return hash part of LTPAToken2 cookie
	 */
	String provide();
	
	/**
	 * @return name of authenticated user
	 */
	String getPrincipalName();
}
