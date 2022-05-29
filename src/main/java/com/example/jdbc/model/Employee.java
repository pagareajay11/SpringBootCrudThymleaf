package com.example.jdbc.model;

public class Employee {
	private int eid;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", desig=" + desig + ", sal=" + sal + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	private String name,desig;
	private float sal;
	

}
