package com.example.cache;

import com.example.cache.dao.IDepartmentDao;
import com.example.cache.dao.IEmployeeDao;
import com.example.cache.model.Department;
import com.example.cache.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	IEmployeeDao employeeDao;

	@Autowired
	IDepartmentDao departmentDao;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate<Object,Department> deptRedisTemplate;

	@Autowired
	RedisTemplate<Object,Employee> employeeRedisTemplate;

	@Test
	public void testRedis() throws Exception{
//		stringRedisTemplate.opsForList().leftPush("testString","hello");
//		stringRedisTemplate.opsForList().leftPush("testString","world");
//
//		System.out.println(stringRedisTemplate.opsForList().leftPop("testString"));
//		System.out.println(stringRedisTemplate.opsForList().leftPop("testString"));

//		Department department = departmentDao.getOne(19);
//		redisTemplate.opsForList().leftPush("departments",department);
//		deptRedisTemplate.opsForList().leftPush("departments",department);

		Employee emp = employeeDao.getEmployee(2);
		employeeRedisTemplate.opsForList().leftPush("employees",emp);


	}

	@Test
	public void contextLoads() throws SQLException {
		System.out.println(dataSource);
		System.out.println(dataSource.getConnection());
	}

	@Test
	public void testEmployee() throws Exception{

		Employee employee = new Employee();
		employee.setEmployeeName("cs1");
		employee.setDeptId(2);
		employee.setId(1);
//		employeeDao.insertEmployee(employee);
//		employeeDao.updateEmployee(employee);
//		System.out.println(employeeDao.getEmployee(1));
		employeeDao.delete(1);
		System.out.println(employeeDao.getEmployeesList());
	}

	@Test
	public void testDepartment() throws Exception{
		Department department = new Department();
		department.setDeptName("2019年1月7日11:25:11");
//		department.setId(3);
		int res = departmentDao.insert(department);
//		departmentDao.update(department);

//		System.out.println(departmentDao.getOne(1));
//		departmentDao.delete(1);
		System.out.println(res);
		System.out.println(department);
	}

}

