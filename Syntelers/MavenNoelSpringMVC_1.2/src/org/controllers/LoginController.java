package org.controllers;

import javax.annotation.PostConstruct;

import org.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("request")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService lgServ;
	
	private int[][] multiTable;
	
	@PostConstruct
	public void init()
	{
		multiTable = new int[13][13];
	}
	
	@RequestMapping(value="/helloMethod")
	public String hello(ModelMap model) {
		String message= "This is coming from the login conroller with hello()";
		model.addAttribute("message", message);
		return "login";
	}
	
	@RequestMapping(value="/table/{number}" )
	public String table(ModelMap mytable, @PathVariable("number")int no)
	{
		//int[][] n = new int[13][13];
		System.out.println("Number passed through url is: " + no);
		
		try
		{
			if(no <= 0 || no >= 13)
			{
				throw new ArrayIndexOutOfBoundsException();
			}
			else
			{
				lgServ.getMultiplicationTable(no, multiTable);
			}
		}
		catch(ArrayIndexOutOfBoundsException aioe)
		{
			lgServ.getMultiplicationTable(multiTable);
		}
		finally
		{
			mytable.addAttribute("table", multiTable);
		}
		
		return "login";
	}
	/*@RequestMapping(value="/table/{wildCard}" )
	public String table(ModelMap mytable, @PathVariable("wildCard")String wht)
	{
		return "error";
	}*/
	
	@RequestMapping(value="/table" )
	public String table(ModelMap mytable)
	{
		//int[][] n = new int[13][13];
		
		lgServ.getMultiplicationTable(multiTable);
		
		mytable.addAttribute("table", multiTable);
		
		return "login";
	}
}
