package org.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value="/helloMethod")
	
	public String hello(ModelMap model) {
		String message= "This is coming from the login conroller with hello()";
		model.addAttribute("message", message);
		return "login";
	}
	@RequestMapping(value="/table/{number}" )
	public String table(ModelMap mytable, @PathVariable("number")int no)
	{
		int[][] n = new int[12][12];
		
		for(int i = 1; i < n.length; i++){
			for(int j = 1; j < n.length; j++){
				n[i][j] = i*j;
				System.out.print(n[i][j]);
			}
			System.out.println();
			
		}
		
		mytable.addAttribute("table", n);
		if(no >= n.length || no < 1)
		{
			mytable.addAttribute("table", n);
		}
		else
		{
			for(int i = no; i == no; i++)
				for(int j = 1; j < n.length; j++)
					n[no][j] = no * j;
				
		}
		return "login";
				
	}
}
