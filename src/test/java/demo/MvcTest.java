package demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.lik.crud.bean.Employee;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() {
		mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		
	}
	
	@Test
	public void testPage() throws Exception {
//		模拟请求
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("page", "1")).andReturn();
		MockHttpServletRequest mockHttpServletRequest = andReturn.getRequest();
		PageInfo<Employee> pageInfo = (PageInfo<Employee>)mockHttpServletRequest.getAttribute("pageInfo");
		System.out.println(pageInfo.getPageNum());
		
	}
}
