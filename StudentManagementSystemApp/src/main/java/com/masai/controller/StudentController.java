package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.model.StudentDto;
import com.masai.service.StudentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*")
public class StudentController {
    
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> addNewStudent(@RequestBody @Valid Student student){
		
		Student stud = studentService.addStudent(student);
		
		return new ResponseEntity<>(stud,HttpStatus.CREATED);
	}
	
	@GetMapping("/students/{rollNo}")
	public ResponseEntity<Student> getStudent(@PathVariable("rollNo") Integer rollNo){
		 
		Student stud = studentService.getStudent(rollNo);
		
		return new ResponseEntity<>(stud,HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> viewAllStudent(){
		 
		List<Student> studentList = studentService.viewAllStudent();
		
		return new ResponseEntity<>(studentList,HttpStatus.OK);
	}
	
	@PutMapping("/students/{rollNo}")
	public ResponseEntity<Student> updateStudent(@RequestBody @Valid StudentDto studentdto,@PathVariable("rollNo") Integer rollNo){
		 
	 Student stud = studentService.updateStudentDetails(studentdto, rollNo);
		
		return new ResponseEntity<>(stud,HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{rollNo}")
    public void removeStudent(@PathVariable("rollNo") Integer rollNo){
		
		 studentService.removeStudent(rollNo);
				
	}
	
	
	
	
	
}
