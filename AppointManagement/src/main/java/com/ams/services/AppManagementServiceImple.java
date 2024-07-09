package com.ams.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.AppManage;
import com.ams.repository.AppointRepository;

@Service
public class AppManagementServiceImple implements AppManageService {
	
	@Autowired
	private AppointRepository appointRepository;

	@Override
	public List<AppManage> getAppointmentByUser(String user) {
	
		return appointRepository.findByUserName(user) ;
	}

	@Override
	public Optional<AppManage> getAppointmentById(long id) {
		
		return appointRepository.findById(id);
	}

	@Override
	public void addAppointment(String name, String desc, Date targetDate, boolean isDone) {
		appointRepository.save(new AppManage(name, desc,targetDate,isDone));
		
	}

	@Override
	public void deleteAppointment(long id) {
		Optional<AppManage> appoint=appointRepository.findById(id);
		if(appoint.isPresent()) {
			appointRepository.delete(appoint.get());
		}
          

		
	}

	@Override
	public void saveAppointment(AppManage appoint) {
		appointRepository.save(appoint);
		
	}

	@Override
	public void updateAppointment(AppManage appoint) {
		appointRepository.save(appoint);
		
	}

}
