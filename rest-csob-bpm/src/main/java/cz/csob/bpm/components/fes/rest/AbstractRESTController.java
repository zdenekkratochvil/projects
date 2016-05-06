package cz.csob.bpm.components.fes.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import cz.csob.bpm.components.service.rest.BPMRESTTemplate;

public abstract class AbstractRESTController {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractRESTController.class);
	
	@Autowired private BPMRESTTemplate template;
	
	@ExceptionHandler(value = Exception.class)
	public void defaultErrorHandler(HttpServletResponse resp, Exception e) throws IOException {
		
		LOG.error("Execution failed", e);
		resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		
		if(e instanceof HttpClientErrorException) {
			HttpClientErrorException ex = (HttpClientErrorException) e;
			resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
			resp.getOutputStream().write(ex.getResponseBodyAsByteArray());
		} else {
			resp.getOutputStream().write(e.getLocalizedMessage().getBytes());
		}
		
		
	}

	protected void writeJSONResponse(HttpServletResponse resp, byte[] result) throws IOException {
		resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		resp.getOutputStream().write(result);
	}
	
	public BPMRESTTemplate getTemplate() {
		return template;
	}

}
