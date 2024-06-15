package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class StudentController {
	@Autowired
	
	StudentService ss;
	
	@GetMapping("/studentcollege")
	public String createPage()
	{
		return "create";
	}
	
	@PostMapping("/studentcollege")
	public String save(@ModelAttribute Student student)
	{
		Student st=ss.saveStudent(student);
		return "redirect:/studentcollege";
	}
	
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable int id,Model m)
	{
		Student t=ss.getStudentById(id);
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(@ModelAttribute Student st,@PathVariable int id)
	{
		st.setId(id);
		Student t=ss.updateStudent(st);
		return "redirect:/edit/{id}";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		ss.deleteStudent(id);
		return "redirect:/studentcollege";
	}
//}
	
	
	
	/*
	@PostMapping("/student")
	public ResponseEntity<Student>saveStudent(@RequestBody Student st)
	{
		Student d=ss.saveStudent(st);
		return new ResponseEntity<Student>(d,HttpStatus.CREATED);
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>>getAllStudent()
	{
		List<Student>y=ss.getAllStudent();
		return new ResponseEntity<List<Student>>(y,HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student>getStudentById(@PathVariable int id)
	{
		Student f=ss.getStudentById(id);
		return new ResponseEntity<Student>(f,HttpStatus.OK);
		
	}
	
	@PutMapping("/student/{id}")
	
	public ResponseEntity<Student>updateStudent(@PathVariable int id,@RequestBody Student st)
	{
		st.setId(id);
	
		Student f=ss.updateStudent(st);
		return new ResponseEntity<Student>(f,HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student>deleteStudent(@PathVariable int id)
	{
		ss.deleteStudent(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
		
	}
}
	*/
	@GetMapping("/student")
	public List<Student>getPageOne()
	{
		Pageable p=PageRequest.of(0, 4,Sort.by("id").ascending());
		Page<Student>g=ss.findAll(p);
		return g.getContent();
	}
	}
