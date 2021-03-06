package com.zhaj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaj.bean.Employee;
import com.zhaj.dao.EmployeeMapper;

@Service
public class EmployeeService {

	// 调用service要注入Dao
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * 查询所有员工 控制器调用service层
	 * @return
	 */
	public List<Employee> getAll() {
		// 查询带部门的信息 查询所有(不带条件)
		return employeeMapper.selectByExampleWithDept(null);
	}

}
