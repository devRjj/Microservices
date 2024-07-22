package com.audit.demo.entity.userimpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.audit.demo.entity.auditlogs;

public interface userrepo extends JpaRepository<auditlogs, Integer> {

}
