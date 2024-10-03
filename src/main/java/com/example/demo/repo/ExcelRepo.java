package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@EnableJpaRepositories
@Repository
public interface ExcelRepo  extends JpaRepository<Employee, Integer> {

	
	String rawQuery = "select employee_id from employee";
    @Query(nativeQuery = true, value = rawQuery)
	List<String> findAllByEmployeeId();

	
	

}


