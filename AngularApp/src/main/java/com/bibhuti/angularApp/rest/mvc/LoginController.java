package com.bibhuti.angularApp.rest.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String displayMainPage(){
		return "index";
	}
}
