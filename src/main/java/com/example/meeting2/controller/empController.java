package com.example.meeting2.controller;


import com.example.meeting2.dao.DepartmentDao;
import com.example.meeting2.dao.EmployeeDao;
import com.example.meeting2.pojo.Department;
import com.example.meeting2.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class empController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping("/dashboard")
    public  String dashboard(){
        return "dashboard";
    }


    @RequestMapping("emp/show")
    public  String showemp(Model model){
        Collection <Employee> all = employeeDao.getAll ( );
        model.addAttribute ( "emp",all );
        return "emp/list";
    }
    @GetMapping("/emp")
    public String addpage(Model model){
        Collection <Department> departments = departmentDao.getDepartments ( );
        model.addAttribute ( "departments",departments );

        return "emp/add";
    }
    @PostMapping("/emp")
    public String add(Employee employee)
    {
        System.out.println (employee );
        employeeDao.save ( employee );
        return "redirect:emp/show";
    }


    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.getEmployById ( id );
        Collection <Department> departments = departmentDao.getDepartments ( );
        model.addAttribute("emp",employee);
        model.addAttribute ( "departments",departments );
        return "emp/update";
    }
    @PostMapping("/toupdate")
    public String update(Employee employee){
        employeeDao.save ( employee );
        return "redirect:/emp/show";
    }

}
