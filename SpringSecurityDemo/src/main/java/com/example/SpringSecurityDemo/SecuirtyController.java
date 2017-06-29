package com.example.SpringSecurityDemo;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class SecuirtyController {
	
	@RequestMapping("/list")
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public String list()
	{
		return "list of posts";
	}
	
	@RequestMapping("/edit")
	@Secured({"ROLE_ADMIN"})
	public String edit()
	{
		return "edit posts";
	}
	
}
