package com.example.springMongoDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@RequestMapping("/all")
	public Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@RequestMapping("/findById/{id}")
	public Student getStudentByName(@PathVariable("id") Long id) {
		return studentRepository.findOne(id);
	}

	@RequestMapping("/findByName/{name}")
	public Student getStudentByName(@PathVariable("name") String name) {
		return studentRepository.findFirstByName(name);
	}

	@RequestMapping("/findByAge/{age}")
	public Student getStudentByName(@PathVariable("age") int age) {
		return studentRepository.findByAge(age);
	}

	@RequestMapping("/updateAgeByName/{name}/{age}")
	public int updateAge(@PathVariable("name") String name,
			@PathVariable("age") int age) {
		return studentRepository.updateStudentAge(name, age);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/insert", consumes = "application/json")
	public ResponseEntity<?> insertDomain(@RequestBody Student student) {
		String response = null;

		if (studentRepository.addStudent(student) == 1)
			response = "successfully inserted for student :" + student.getName();
		else
			response = "Already id or name eixts so it wont be inserted for student :"
					+ student.getName();
		return new ResponseEntity(response, new HttpHeaders(), HttpStatus.OK);
	}

}
