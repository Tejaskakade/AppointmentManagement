package com.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.AppManage;

public interface AppointRepository extends JpaRepository<AppManage ,Long > {
	
List<AppManage> findByUserName(String user);
}
