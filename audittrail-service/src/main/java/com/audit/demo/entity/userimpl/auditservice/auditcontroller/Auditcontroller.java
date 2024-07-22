package com.audit.demo.entity.userimpl.auditservice.auditcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.audit.demo.entity.auditlogs;
import com.audit.demo.entity.userimpl.auditservice.auditlogservice;


@RestController
public class Auditcontroller {

	
	@Autowired
	private auditlogservice service;
	
	@PostMapping("/log")
	public auditlogs logaudit(@RequestBody auditlogs audit) { 
		 auditlogs b=service.saveauditlogs(audit);
		 return b;
	}
}
