package com.audit.demo.entity.userimpl.auditservice.auditcontroller.auditmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.audit.demo.entity.auditlogs;

@Component
public class Auditclient {
	
	@Autowired
	private RestTemplate resttemplate;

	public String auditServiceUrl="http://localhost:8080/log";
	
	public void auditt(auditlogs auditlog) {
		resttemplate.postForObject(auditServiceUrl, auditlog, Void.class);
	}
}
