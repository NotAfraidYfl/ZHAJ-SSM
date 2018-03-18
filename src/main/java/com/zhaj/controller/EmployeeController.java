package com.zhaj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaj.bean.Employee;
import com.zhaj.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * 查询员工数据(分页查询)
	 * 
	 * @return
	 */
	@RequestMapping("empList")
	public String getEmps(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
		// 当前查询不是一个分页查询 会查出所有的数据
		// 引入pagehelper分页插件
		// 在查询之前只需要调用,传入页码以及每页显示的条数
		PageHelper.startPage(pageNum, 10);
		// startPage后面紧跟的查询就是一个分页的查询
		List<Employee> emps = employeeService.getAll();
		// 查询完成之后使用pageInfo对数据进行包装,只需要将Pageinfo交给页面
		// pageInfo中就包含我了们需要的分页的信息，并且可以传入需要连续显示的页数
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);

		return "EmployeeViews/empList";
	}

}
