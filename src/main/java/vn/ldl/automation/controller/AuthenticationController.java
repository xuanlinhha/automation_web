package vn.ldl.automation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuanlinhha
 * 
 * 
 */
@Controller
public class AuthenticationController {
	@RequestMapping(value = "signIn")
	public String signIn() {
		return "signIn";
	}

	@RequestMapping(value = "signOut")
	public String signOut() {
		return "signOut";
	}
}
