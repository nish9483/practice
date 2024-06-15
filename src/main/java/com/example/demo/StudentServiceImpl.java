package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepo sr;
	
	public Student saveStudent(Student st)
	{
		return sr.save(st);
	}
	public List<Student> getAllStudent()
	{
		return sr.findAll();
	}
	public Student getStudentById(int id)
	{
		Optional<Student>s=sr.findById(id);
		return s.get();
		
	}
	
	public Student updateStudent(Student st)
	{
		Student d=sr.findById(st.getId()).get();
		d.setName(st.getName());
		d.setCity(st.getCity());
		Student r=sr.save(d);
		return r;
		
	}
	public void deleteStudent(int id)
	{
		sr.deleteById(id);
		
	}
	
	public Page<Student>findAll(Pageable p)
	{
		Page<Student>s=sr.findAll(p);
		return s;
	}
	

}
