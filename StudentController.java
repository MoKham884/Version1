package com.studentregistration.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import com.studentregistration.model.Student;
import com.studentregistration.service.StudentService;

@Named
@ViewScoped
public class StudentController {

	private Student student = new Student();
	private Student search = new Student();
	
	
	@Autowired
	StudentService stdService;

	private List<Student> studentList = new ArrayList<Student>() ;

	public void studentSave() {
		stdService.studentSave(student);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Register Successfully!", "WARN Messages"));
	}

	public void fetchAll() {
       System.out.println("arrrive");
	
		this.studentList =stdService.findAll();
		System.out.println("list"+this.studentList.get(0));
		
	}
	
	
	
	  public void edit(Student student) {
	 System.out.println("arriveedit>>>>>>>>>>>>Edit");
	 this.student = student;
	 
	  
	  }
	  
	  
	 
	/*
	 * public void reset(){ System.out.println("arriveedit>>>>>>>>>>>>Edit");
	 * this.studentList=new ArrayList<Student>(); }
	 */
	     public void searchStudent() {
	            
	    	    boolean f1 = student.getStdId()!=null && student.getStdId().trim().length()!=0 ;
	    	    boolean f2 =student.getStdName()!=null  && student.getStdName().trim().length()!=0 ;
	    	    boolean f3 = student.getClasses()!=null  && student.getClasses().length()!=0;
	    	    System.out.println("f1"+f1);
	    	    System.out.println("f2"+f2);
	    	    System.out.println("f3"+f3);
	    	    
	    	    if(f1&&f2&&f3) {
		    	    System.out.println("s1");

	    	    	this.studentList = stdService.findStudentByIdAndName(student);
 	    	    }
	    	    else if(f1 || f2 || f3) {
		    	    System.out.println("s2");
		    	    this.studentList =stdService.findStudentByIdOrName(student);
	    	    }
	    	    
		/*
		 * else if (!f1 && f2) { System.out.println("s3");
		 * 
		 * this.studentList = stdService.findStudentByIdOrName(student); }
		 */
	    	    
	    	    else {System.out.println("no");
	    	    
	    	     this.studentList= stdService.findAll();
	    	    }
	    	    
	}
	
	
	    public void reset() {
		
		  System.out.println("arrive arrive"); student.setStdId(null);
		  student.setStdName(null); student.setClasses(null);
		  studentList= new ArrayList<Student>();
	    	
	    }
	
	public void delete(String id) {
		stdService.delete(id);
		FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_WARN, "Delete Successfully!", "WARN Messages"));
	}
	
	public void findStudentById(Student student) {
		this.student=student;

	}
	
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Student getSearch() {
		return search;
	}

	public void setSearch(Student search) {
		this.search = search;
	}



}
