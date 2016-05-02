package cz.csob.bpm.components.service.rest;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import cz.csob.bpm.components.fault.CSOBBPMRuntimeException;
import cz.csob.bpm.components.fes.rest.dto.AbstractBPMResponse;
import cz.csob.bpm.components.service.security.ILTPATokenProvider;

@Component
public class BPMRESTTemplate {

	private static final Logger LOG = LoggerFactory.getLogger(BPMRESTTemplate.class);
	private static final MediaType MEDIA_TYPE_JSON = new MediaType("application", "json", Charset.forName("utf8"));
	private static final String COOKIE = "Cookie";
	private static final String LTPA_TOKEN2 = "LtpaToken2=";

	@Autowired private ILTPATokenProvider tokenProvider;
	@Value("${bpm.url}") private String backendUrl;
	
	private RestTemplate template = new RestTemplate();
	/**
	 * Jackson object mapper
	 */
	private ObjectMapper objectMapper;
	
	public BPMRESTTemplate() {
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	protected HttpHeaders getLtpaTokenHeaders() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Arrays.asList(MEDIA_TYPE_JSON));

		String ltpaToken = tokenProvider.provide();
		requestHeaders.add(COOKIE, LTPA_TOKEN2 + ltpaToken);

		return requestHeaders;
	}

	public<T extends AbstractBPMResponse<?>> T getResult(UriComponentsBuilder uriBuilder, HttpMethod httpMethod, Class<T> resultClass) {
		byte[] resultBytes = getResult(uriBuilder, httpMethod);
		try {
			T value = objectMapper.readValue(resultBytes, resultClass);
			if(value.ok()) {
				return value;
			}
			throw new IllegalStateException("Rest call failed with http status: " + value.getStatus());
		} catch (Exception e) {
			try {
				LOG.error("Unable to parse REST response from {}: {}", uriBuilder.toUriString(), new String(resultBytes, "utf8"), e);
			} catch (UnsupportedEncodingException e1) {
				//ignore
			}
			throw new CSOBBPMRuntimeException(e);
		}
	}
	
    public byte[] getResult(UriComponentsBuilder uriBuilder, HttpMethod httpMethod) {
		return getResult(uriBuilder, null, httpMethod);
	}

	public byte[] getResult(UriComponentsBuilder uriBuilder, String body, HttpMethod httpMethod) {
		URI uri = uriBuilder.build().toUri();
		LOG.info("Calling on: {}", uri);

		ResponseEntity<byte[]> result;
		HttpEntity<String> httpEntity = new HttpEntity<String>(new HttpHeaders());
		try {
			if (body == null) {
				httpEntity = new HttpEntity<String>(getLtpaTokenHeaders());
			} else {
				LOG.debug("Request body: {}", body);
				httpEntity = new HttpEntity<String>(body, getLtpaTokenHeaders());
			}
			result = template.exchange(uri, httpMethod, httpEntity, byte[].class);
		} catch (HttpClientErrorException e) {
			LOG.error("{}: Response body: {}", httpMethod, e.getResponseBodyAsString(), e);
			throw e;
		}

		byte[] responseValue = result.getBody();
		if(LOG.isDebugEnabled()) {
			try {
				LOG.debug("Response body: {}", new String(responseValue, "utf8"));
			} catch (UnsupportedEncodingException e) {}
		}
		return responseValue;
	}
	
	public String getBackendUrl() {
		return backendUrl;
	}
	

}
