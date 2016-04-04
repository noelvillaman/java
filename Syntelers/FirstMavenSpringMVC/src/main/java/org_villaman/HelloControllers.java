package org_villaman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloControllers {
	@RequestMapping("/hello2")
	public String hello(ModelMap model)
	{
		model.addAttribute("message", "Noel is here working from the hello contoller in peace");
		return "hello";
	}
}
