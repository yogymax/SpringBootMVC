package com.scp.spring.boot.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.scp.spring.boot.bean.EmployeeBean;
import com.scp.spring.boot.entity.Employee;
import com.scp.spring.boot.service.EmployeeService;



/**
 * http://localhost:8080/spring-boot-demo/index  -- firstrequest
 * 
 * 
 * @author Yogymax
 *
 */

@Controller
public class EmployeeController {
 
static {
	System.out.println("loaded controller class...");
}
	
 @Autowired
 private EmployeeService employeeService;
 
@RequestMapping(value = "/save", method = RequestMethod.POST)
public ModelAndView saveEmployee(@ModelAttribute("command")EmployeeBean employeeBean, 
   BindingResult result) {
  Employee employee = prepareModel(employeeBean);
  employeeService.save(employee);
  return new ModelAndView("redirect:/add.html");
 }

 @RequestMapping(value="/employees", method = RequestMethod.GET)
 public ModelAndView listEmployees() {
  Map<String,Object> model = new HashMap<>();
  model.put("employees",  prepareListofBean(employeeService.findAll()));
  return new ModelAndView("employeesList", model);
 }

 @RequestMapping(value = "/add", method = RequestMethod.GET)
 public ModelAndView addEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employees",  prepareListofBean(employeeService.findAll()));
  return new ModelAndView("addEmployee", model);
 }
 
@RequestMapping(value = "/index", method = RequestMethod.GET)
public ModelAndView welcome() {
  return new ModelAndView("index");
 }

@RequestMapping(value = "/delete", method = RequestMethod.GET)
public ModelAndView editEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
  employeeService.delete(prepareModel(employeeBean));
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employee", null);
  model.put("employees",  prepareListofBean(employeeService.findAll()));
  return new ModelAndView("addEmployee", model);
 }
 
@RequestMapping(value = "/edit", method = RequestMethod.GET)
public ModelAndView deleteEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employee", prepareEmployeeBean(employeeService.findById(employeeBean.getId()).get()));
  model.put("employees",  prepareListofBean(employeeService.findAll()));
  return new ModelAndView("addEmployee", model);
 }
 
 private Employee prepareModel(EmployeeBean employeeBean){
  Employee employee = new Employee();
  employee.setAddress(employeeBean.getAddress());
  employee.setAge(employeeBean.getAge());
  employee.setName(employeeBean.getName());
  employee.setSalary(employeeBean.getSalary());
  employee.setId(employeeBean.getId());
  employeeBean.setId(null);
  return employee;
 }
 
 private List<EmployeeBean> prepareListofBean(List<Employee> employees){
  List<EmployeeBean> beans = null;
  if(employees != null && !employees.isEmpty()){
   beans = new ArrayList<EmployeeBean>();
   EmployeeBean bean = null;
   for(Employee employee : employees){
    bean = new EmployeeBean();
    bean.setName(employee.getName());
    bean.setId(employee.getId());
    bean.setAddress(employee.getAddress());
    bean.setSalary(employee.getSalary());
    bean.setAge(employee.getAge());
    beans.add(bean);
   }
  }
  return beans;
 }
 
 private EmployeeBean prepareEmployeeBean(Employee employee){
  EmployeeBean bean = new EmployeeBean();
  bean.setAddress(employee.getAddress());
  bean.setAge(employee.getAge());
  bean.setName(employee.getName());
  bean.setSalary(employee.getSalary());
  bean.setId(employee.getId());
  return bean;
 }
}
/**
 * Remarks
 * 
 * @GetMapping("/emp") annotation is a short form of
 * @RequestMapping(value="/emp", method=RequestMethod.GET)
 * 
 * @PostMapping("/emp") annotation is a short form of
 * @RequestMapping(value="/emp", method=RequestMethod.POST)
 * 
 * 
 * Optional class is added in java8 -- purpose is to provide a type-level solution for
 * representing optional values instead of using null references meaning -- if no employee found
 * with given id, it will return empty employee but not null
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
*/
