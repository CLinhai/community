package com.nowcoder.community;

import com.nowcoder.community.config.TestConfig;
import com.nowcoder.community.dao.TestDao;
import com.nowcoder.community.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	 this.applicationContext = applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
		TestDao testDao = applicationContext.getBean(TestDao.class);
		System.out.println(testDao.select());

		testDao = applicationContext.getBean("mysqlImpl",TestDao.class);
		System.out.println(testDao.select());
	}

	@Test
	public void testBeanManagement(){
		TestService testService = applicationContext.getBean(TestService.class);
		System.out.println(testService);

		testService = applicationContext.getBean(TestService.class);
		System.out.println(testService);
	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	@Qualifier("mysqlImpl")
	private TestDao testDao;

	@Autowired
	private TestService testService;

	@Autowired
	private TestConfig testConfig;

	@Test
	public void testDI(){
		System.out.println(testDao);
		System.out.println(testService);
		System.out.println(testConfig);
	}

	@Test
	public void substringTest(){
		String url = "1232134fjsjfl.png";
		String s = url.substring(url.lastIndexOf("."));
		System.out.println(s);
	}
}
