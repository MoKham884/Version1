package com.studentregistration.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.studentregistration.model.StudentModel;
import com.studentregistration.service.StudentService;

@Named
@ViewScoped
public class StudentController {
	
	private StudentModel student=new StudentModel();
	
	@Autowired
	StudentService stdService;
	
	public void studentSave() {
		stdService.studentSave(student);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Register Successfully!","WARN Messages"));
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}
}
