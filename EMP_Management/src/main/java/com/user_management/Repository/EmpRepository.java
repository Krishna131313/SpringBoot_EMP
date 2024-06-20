package com.user_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user_management.Entity.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> {

}
