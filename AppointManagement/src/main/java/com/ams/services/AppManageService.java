package com.ams.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.ams.entity.AppManage;

public interface AppManageService {
	
	List<AppManage> getAppointmentByUser(String user);
	
	Optional<AppManage> getAppointmentById(long id);
	
	void updateAppointment(AppManage appoint);
	
	void addAppointment(String name, String desc, Date targetDate, boolean isDone);
	
	void deleteAppointment(long id);
	
	void saveAppointment(AppManage appoint);

}
