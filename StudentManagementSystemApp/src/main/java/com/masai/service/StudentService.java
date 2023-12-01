package com.masai.service;

import java.util.List;

import com.masai.model.Student;
import com.masai.model.StudentDto;

public interface StudentService {
   
	public Student addStudent(Student student);
	
	public Student getStudent(Integer rollNo);
	
	public List<Student> viewAllStudent();
	
	public Student updateStudentDetails(StudentDto student, Integer rollNo);
	
	public void removeStudent(Integer rollNo);
	
	
	
}
