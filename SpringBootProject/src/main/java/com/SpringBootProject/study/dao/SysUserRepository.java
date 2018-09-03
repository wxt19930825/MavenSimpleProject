package com.SpringBootProject.study.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootProject.study.model.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{

	SysUser findByUsername(String username);
}
