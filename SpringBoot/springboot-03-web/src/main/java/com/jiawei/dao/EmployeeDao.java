package com.jiawei.dao;

import com.jiawei.pojo.Department;
import com.jiawei.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {

    /*模拟数据*/
    private static Map<Integer, Employee> employees = new HashMap<>();
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees.put(1001,new Employee(1001,"AA","A49267842@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","B49267842@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","C49267842@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","D49267842@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","E49267842@qq.com",0,new Department(105,"后勤部")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);

    }
    /*查询全部员工*/
    public Collection<Employee> getAll(){
        return employees.values();
    }
    /*查询员工by id*/
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    /*删除员工by ID*/
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }


}
