package com.cih.feignclientservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cih.feignclientservice.dto.Employee;
import com.cih.feignclientservice.entity.Adress;
import com.cih.feignclientservice.repo.FeignClientRepository;
import com.cih.feignclientservice.service.TestService;


@RestController
public class TestController {

	@Autowired
	TestService testService;
	
	@Autowired
	FeignClientRepository fRepo;

	@PostMapping("save")
	public Employee saveEmployee(@RequestBody Employee employee) {

		return testService.saveEmployee(employee);
	}

	@DeleteMapping("delBy/{id}")
	public void deleteById(@PathVariable Integer id) {

		testService.deleteById(id);
	}

	@GetMapping("getBy/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {

		Employee emp = testService.getEmployeeById(id);
		Optional<Adress> ad = fRepo.findById(Integer.valueOf(emp.getCity()));
		
		emp.setCity(ad.get().getLabel());
		return emp;

	}

	@PutMapping("update")
	public Employee updateEmployee(@RequestBody Employee emp) {

		return testService.updateEmployee(emp);
	}

}
