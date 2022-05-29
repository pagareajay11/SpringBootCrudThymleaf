package com.example.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.jdbc.model.Employee;
@Repository
public class EmployeeRepository {
	@Autowired
	JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public int insertEmp(Employee e)
	{
		return jt.update("insert into Emp values(?,?,?,?)",null,e.getName(),e.getDesig(),e.getSal());
	}
	public List<Employee> fetchEmp(){
	return jt.query("select * from Emp",new RowMapper<Employee>()
			{
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			Employee e = new Employee();
			e.setEid(rs.getInt("eid"));
			e.setName(rs.getString("name"));
			e.setDesig(rs.getString("desig"));
			e.setSal(rs.getFloat("sal"));
			return e;
			
		}
		
			});
	}
	
	public int updateEmp(String n,float s)
	{
		return jt.update("update Emp set sal=? where name=?",s,n);
	}
	
	public int deleteEmp(int id)
	{
		return jt.update("delete from Emp where eid=?",id);
	}
	
	

}
