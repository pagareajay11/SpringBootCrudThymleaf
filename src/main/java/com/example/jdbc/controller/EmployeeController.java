package com.example.jdbc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbc.model.Employee;
import com.example.jdbc.repository.EmployeeRepository;
@RestController
@RequestMapping(path="/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository er;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	@GetMapping(path="check")
	public String check()
	{
		return "Spring Boot using JDBC :its a web application";
	}
	
	@GetMapping(path="insert")
	public String insertEmp() throws IOException
	{
		System.out.println("Enter details :\nName ,design ,sal");
		Employee e = new Employee();
		e.setName(br.readLine());
		e.setDesig(br.readLine());
		e.setSal(Float.parseFloat(br.readLine()));
		int i = er.insertEmp(e);
		if(i==1)
			return "Record Added Succefully";
		else
			return "Try Again";
		
	}
	@GetMapping(path = "update")
	public String updateEmp() throws IOException
	{
		System.out.println("Enter details :\nName ,sal");
		Employee e = new Employee();
		String name=br.readLine();
		e.setName(name);
		float sal=Float.parseFloat(br.readLine());
		e.setSal(sal);
		int i = er.updateEmp(e.getName(),e.getSal());
		if(i==1)
		return "Record Updated";
		else
			return "fail to update";
	}
	@GetMapping(path="delete")
	public String deleteEmp() throws IOException
	{
		System.out.println("Enter the Id to be deleted");
		int e_id=Integer.parseInt(br.readLine());
		Employee e=new Employee();
		e.setEid(e_id);
		int i =er.deleteEmp(e.getEid());
		if(i==1)
		 return "Record Delete Successfully";
		else
			return "failed";
		
	}
	@GetMapping(path="fetch")
	public List<Employee> fetch()
	{
		return er.fetchEmp();
	}
}
