package com.hniu.ssh.dao;

import java.util.List;

import org.hibernate.Query;

import com.hniu.ssh.entities.Employee;

public class EmployeeDao extends BaseDao {

	/**
	 * 获取employee对象
	 * @return 返回employee对象
	 */
	public List<Employee> getEmployee() {
		String hql = "FROM Employee";
		// 查询数据以list的形式返回
		return getSession().createQuery(hql).list();
	}
	/**
	 * 删除对象
	 * @param id 通过id 删除数据
	 */
	public void deleteEmployee(int id) {
		String hql = "delete from Employee e where e.employee_id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	/**
	 * 保存对象数据
	 * @param employee 保存对象保存起来
	 */
	public void saveEmployee(Employee employee) {
		getSession().saveOrUpdate(employee);
	}
	/**
	 * 判断该用户是否可用
	 * @param name 通过name查询是否存在该用户
	 * @return 返回employee实例
	 */
	public Employee userIsExist(String name) {
		String hql = "from Employee e where e.employee_name=?";
		Query query = getSession().createQuery(hql).setString(0, name);
		Employee employee = (Employee) query.uniqueResult();
		return employee;
	}
	/**
	 * 通过指定id获取数据
	 * @param id 通过id查询数据库数据
	 * @return 返回employee对象
	 */
	public Employee getEmployeeById(Integer id) {
		String hql = "from Employee e where e.employee_id=?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		return (Employee) query.uniqueResult();
	}
}
