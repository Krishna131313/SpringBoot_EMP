package com.user_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user_management.Entity.Employee;
import com.user_management.Service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String home(Model m) {
	List<Employee> emp = empService.getAll();
	m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addemp() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		empService.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfully");
		System.out.println(e);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = empService.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
		
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		empService.addEmp(e);
		session.setAttribute("msg", "Employee Updated Successfully");
		return "redirect:/";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		session.setAttribute("msg","Employee Deleted Successfully");
		empService.deleteById(id);
		return "redirect:/";
		
	}

}
