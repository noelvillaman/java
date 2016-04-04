package org.controllers;
import javax.inject.Inject;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.controllers.*;

@Controller
public class MainController {
	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
	private SpitterService spitterService;
	
	@Inject
	public MainController(SpitterService spitterService){
		this.spitterService = spitterService;
	}
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String, Object> model){
		model.put("spitter", spitterService.getRecentSpitter(DEFAULT_SPITTLES_PER_PAGE));
		return "home";
	}
}
