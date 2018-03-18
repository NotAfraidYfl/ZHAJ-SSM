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
	 * ��ѯԱ������(��ҳ��ѯ)
	 * 
	 * @return
	 */
	@RequestMapping("empList")
	public String getEmps(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
		// ��ǰ��ѯ����һ����ҳ��ѯ �������е�����
		// ����pagehelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ����,����ҳ���Լ�ÿҳ��ʾ������
		PageHelper.startPage(pageNum, 10);
		// startPage��������Ĳ�ѯ����һ����ҳ�Ĳ�ѯ
		List<Employee> emps = employeeService.getAll();
		// ��ѯ���֮��ʹ��pageInfo�����ݽ��а�װ,ֻ��Ҫ��Pageinfo����ҳ��
		// pageInfo�оͰ�����������Ҫ�ķ�ҳ����Ϣ�����ҿ��Դ�����Ҫ������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		model.addAttribute("pageInfo", page);

		return "EmployeeViews/empList";
	}

}
