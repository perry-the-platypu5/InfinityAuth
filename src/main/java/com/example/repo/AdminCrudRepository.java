package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.models.Employee;

@Repository
public interface AdminCrudRepository extends JpaRepository<Employee, Long >{
	@Query(value="select employeeId from Employee e where e.employeename=?1")
	public Integer getIdByemployeename(String employeename);
}
