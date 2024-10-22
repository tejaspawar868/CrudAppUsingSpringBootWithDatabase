package com.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.Student;
import com.rest.repo.StudentRepositor;

@Service
public class StudentServices {
	@Autowired
	private StudentRepositor stdrepo;

	public List<Student> getAllStudent() {
		return stdrepo.findAll();
	}

	public Optional<Student> getStudentById(int id) {
		return stdrepo.findById(id);
	}

	public Student createStudent(Student std) {
		return stdrepo.save(std);
	}

	public Student updateStudent(int id, Student std) {
		return stdrepo.findById(id).map(student -> {

			student.setName(std.getName());
			student.setEmail(std.getEmail());
			student.setAge(std.getAge());

			return stdrepo.save(student);

		}).orElse(null);
	}

	public boolean deleteStudent(int id) {
		if (stdrepo.existsById(id)) {
			stdrepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
