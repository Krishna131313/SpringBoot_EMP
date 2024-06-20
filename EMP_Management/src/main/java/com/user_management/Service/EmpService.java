package com.user_management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user_management.Entity.Employee;
import com.user_management.Repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository empRepository;
	
	public void addEmp(Employee e) {
		empRepository.save(e);
	}
	
	public List<Employee> getAll(){
		return empRepository.findAll();
	}
	
	public Employee getEmpById(int id) {
		Optional<Employee> oe = empRepository.findById(id);
		if(oe.isPresent()) {
			return oe.get();
		}
		return null;
	}
	
	public void deleteById(int id) {
		empRepository.deleteById(id);
		
	}

}
