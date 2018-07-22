package com.scp.spring.boot.bean;


public class EmployeeBean {
	 private Integer id;
	 private String name;
	 private Integer age;
	 private Long salary;
	 private String address;
	 private String empilocalAdd;

	 @Override
	public String toString() {
		return "\n Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", address=" + address
				+ "]";
	}
	public EmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeBean(Integer id, String name, Integer age, Long salary, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	 
	 
	


}
