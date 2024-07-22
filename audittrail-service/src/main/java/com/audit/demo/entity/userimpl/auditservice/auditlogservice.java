package com.audit.demo.entity.userimpl.auditservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.demo.entity.auditlogs;
import com.audit.demo.entity.userimpl.userrepo;

@Service
public class auditlogservice {
	
	@Autowired
	private userrepo userrep;
	
	public auditlogs saveauditlogs(auditlogs b) {
		auditlogs t=userrep.save(b);
		return t;
	}

}
