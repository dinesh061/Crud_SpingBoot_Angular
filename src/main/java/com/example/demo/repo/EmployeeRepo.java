package com.example.demo.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;


@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

	
	
	List<Employee>findAllBypercentage(String percentage);
	
	List<Employee> findAllBypercentageIn(Set<String> percentage);

	String rawQuery = "select * from employee where user_id =  ?1";
    @Query(nativeQuery = true, value = rawQuery)
	List<Employee> findAllById(int userId);

    String rawQuery1="select * from employee  WHERE user_name=?1 AND email=?2 ";
    @Query(nativeQuery = true, value = rawQuery1)
	List<Employee> findByuserNameAndemail(String username,String email);

    
    String rawQuery2="select * from employee  WHERE  user_name  LIKE %?1% ";
    @Query(nativeQuery = true, value = rawQuery2)
	List<Employee> findByuserNameLike(String username);

    
    String rawQuery3="select * from employee  WHERE  user_name IN ?1 ";
    @Query(nativeQuery = true, value = rawQuery3)
	List<Employee> findByUsernameIn(List<String> username);

    
    String rawQuery4="select * from employee  WHERE  percentage  BETWEEN ?1 AND ?2; ";
    @Query(nativeQuery = true, value = rawQuery4)
	List<Employee> findByAgeBetween(int val1,int val2);

    
    String rawQuery5 = "Delete from employee where user_id=?1";
    @Modifying
    @Query(nativeQuery = true, value = rawQuery5)
	void deleteByEmployee(int id);
    
    
    String rawQuery6="truncate employee";
    @Modifying
    @Query(nativeQuery = true, value = rawQuery6)
	void deleteAllEmployee();
    
    
    
    String rawQuery7="Delete from employee where user_id IN ?1 ";
    @Modifying
    @Query(nativeQuery = true, value = rawQuery7)
	void deleteMultipleEmployee(List<Integer> user_id);
	
}
