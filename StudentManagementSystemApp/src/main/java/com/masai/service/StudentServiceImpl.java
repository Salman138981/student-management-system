package com.masai.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.model.StudentDto;
import com.masai.repository.StudentRepository;




@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		if(student == null) throw new StudentException("Customer is null") ; 
		 
	    return studentRepository.save(student);
	      
	    
	}

	@Override
	public Student getStudent(Integer rollNo) {
		 
		if(rollNo ==null) throw new StudentException("please provide roll number");
		
		Optional<Student> st = studentRepository.findById(rollNo);
		
		if(st.isPresent()) {
			 Student student = st.get();
			    return student;
		}else {
			throw new StudentException("No Student Available with this Roll Number");
		}
	   
		
	}

	@Override
	public List<Student> viewAllStudent() {
        Pageable pageable = PageRequest.of(0,50, Sort.by("rollNo").ascending());
		
		List<Student> student = studentRepository.findAll(pageable).getContent();
		if(student.isEmpty()) throw new StudentException("Student list is Empty");
		return student;
	}



	@Override
	public void removeStudent(Integer rollNo) {
		Optional<Student> st = studentRepository.findById(rollNo);
		if(st.isPresent()) {
			 Student stud = st.get();
		     studentRepository.delete(stud);
			  
			    
		}else {
			throw new StudentException("No Student Available with this Roll Number");
		}
		
		
	}

	@Override
	public Student updateStudentDetails(StudentDto studentDto, Integer rollNo) {
		
		if(rollNo ==null) throw new StudentException("please provide roll number");
		Optional<Student> st = studentRepository.findById(rollNo);
		if(st.isPresent()) {
			 Student stud = st.get();
			  stud.setAddress(studentDto.getAddress());
			  stud.setPhoneNumber(studentDto.getPhoneNumber());
			  return stud;
			    
		}else {
			throw new StudentException("No Student Available with this Roll Number");
		}
	   
	}
  
}
