package demo;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lik.crud.bean.Employee;
import com.lik.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	private ApplicationContext ApplicationContext;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Test
	public void testCRUD() {
		System.out.println(employeeMapper);
		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeMapper bean = applicationContext.getBean(EmployeeMapper.class);*/
/*		Employee selectByPrimaryKey = employeeMapper.selectByPrimaryKey(1);
		System.out.println(selectByPrimaryKey);
		*/
//		for (int i = 0; i < 1000; i++) {
//			Employee employee = new Employee();
//			employee.setEmpName("name"+i);
//			employee.setEmail(i*1000+"@qq.com");
//			employee.setGender("1");
//			employee.setEmpId(null);
//			employee.setdId(1);
//			employeeMapper.insertSelective(employee);
//		}
		List<Employee> selectByExample = employeeMapper.selectByExample(null);
		for (Employee employee : selectByExample) {
			System.out.println(employee);
		}
	}
}
