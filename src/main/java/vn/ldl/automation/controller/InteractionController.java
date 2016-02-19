package vn.ldl.automation.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.ldl.automation.exchange.IResponse;
import vn.ldl.automation.exchange.Node;
import vn.ldl.automation.exchange.Notification;
import vn.ldl.automation.service.InteractionService;

/**
 * @author xuanlinhha
 * 
 */
@Controller
@RequestMapping(value = "interaction")
public class InteractionController {
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@Autowired
	private InteractionService interactionService;

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String getDisplayData(Principal principal, Map<String, Object> map) {

		// get user name
		String userName = principal.getName();
		map.put("username", userName);
		return "secured/interaction";
	}

	@RequestMapping(value = "get/{id}")
	public @ResponseBody List<Node> display(Principal principal,
			@PathVariable("id") String id) {
		String username = principal.getName();
		List<Node> result = interactionService.display(username, id);
		return result;
	}

	@RequestMapping(value = "set/{id}", method = RequestMethod.POST)
	public void processCommand(HttpServletResponse response,
			Principal principal, @PathVariable("id") String id,
			@RequestBody List<Integer> params) {
		String username = principal.getName();

		String status = interactionService.setStatus(username, id, params);

		// check result to send notification to other users
		if (status == null) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		} else if (status.equals(IResponse.SUCCESS)) {
			Notification notification = new Notification();
			notification.setId(id);
			notification.setStatus(params);
			messagingTemplate.convertAndSendToUser(username,
					"/queue/update_status", notification);
			response.setStatus(HttpServletResponse.SC_OK);
		} else if (status.equals(IResponse.BAD_REQUEST)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
	}
}
