package com.rest.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.Student;

public interface StudentRepositor extends JpaRepository<Student, Integer>  {

	
}
