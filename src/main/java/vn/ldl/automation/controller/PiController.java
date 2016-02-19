package vn.ldl.automation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.ldl.automation.service.PiService;

/**
 * @author xuanlinhha
 * 
 */
@Controller
@RequestMapping(value = "pi")
public class PiController {
	@Autowired
	PiService piService;

	@RequestMapping(value = "info", method = RequestMethod.POST)
	public void saveOrUpdateInfo(HttpServletRequest request,
			HttpServletResponse response, @RequestBody String piData) {
		String address = request.getRemoteAddr();
		boolean isSuccessful = piService.saveInfo(address, piData);
		if (isSuccessful) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}

}
