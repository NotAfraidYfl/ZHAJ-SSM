package com.zhaj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaj.bean.Employee;
import com.zhaj.dao.EmployeeMapper;

@Service
public class EmployeeService {

	// ����serviceҪע��Dao
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * ��ѯ����Ա�� ����������service��
	 * @return
	 */
	public List<Employee> getAll() {
		// ��ѯ�����ŵ���Ϣ ��ѯ����(��������)
		return employeeMapper.selectByExampleWithDept(null);
	}

}
