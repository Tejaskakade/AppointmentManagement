package com.ams.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ams.entity.AppManage;
import com.ams.services.AppManageService;

@Controller
public class AppManagementController {
	
	@Autowired
	private AppManageService appointService ;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
			
	}
	
	@RequestMapping(value= "/list-appointment", method=RequestMethod.GET)
	public String showAppointment(ModelMap model) {
		
		String name=getLoggedInUserName(model);
		model.put("appointments", appointService.getAppointmentByUser(name));
		return "list-appointment";		
	}
	
	private String getLoggedInUserName(ModelMap model) {
		Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			return((UserDetails) principal).getUsername();
		}
		return principal.toString();
		
	}
	
	@GetMapping("/add-appointment")
	public String showAddAppointmentPage(ModelMap model) {
		
		model.addAttribute("appoint",new AppManage());
		return "appoint" ;
	}
	
	@GetMapping("/delete-appointment")
	public String deleteAppointment(@RequestParam long id) {
		appointService.deleteAppointment(id);
		return "redirect:/list-appointment" ;
	}
     
	@GetMapping("/update-appointment-form")
	public String showUpdateAppointment(@RequestParam long id, ModelMap model) {
		
		AppManage appoint= appointService.getAppointmentById(id).get();
		model.put("appoint", appoint);
		return "appoint" ;
		
	}
	
	@PostMapping("/update-appointment")
	public String updateAppointment(ModelMap model,@Valid AppManage appoint, BindingResult result) {
		
		if(result.hasErrors()) {
			return "appoint";
		}
		appoint.setUserName(getLoggedInUserName(model));
		appointService.updateAppointment(appoint);
		return "redirect:/list-appointment";
	}
	
	
	@PostMapping("/save-appointment")
	public String addAppointment(ModelMap model,@Valid AppManage appoint, BindingResult result) {
		
		if(result.hasErrors()) {
			return "appoint";
		}
		appoint.setUserName(getLoggedInUserName(model));
		appointService.updateAppointment(appoint);
		return "redirect:/list-appointment";
	}
	

}


















