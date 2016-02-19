package vn.ldl.automation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.ldl.automation.service.PiService;

/**
 * @author xuanlinhha
 * 
 * 
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

	@Autowired
	PiService buildingInfoService;

	@RequestMapping(value = "home.html")
	public String getAdminPage() {

		return "admin";
	}

	@RequestMapping(value = "buildings.html", method = RequestMethod.GET)
	public String getBuildings(Map<String, Object> map) {
//		List<Pi> buildings = buildingInfoService.getAllInfos();
//		map.put("buildings", buildings);
		return "buildings";
	}
}
