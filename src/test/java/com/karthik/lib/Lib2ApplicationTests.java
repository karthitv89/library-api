package com.karthik.lib;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.karthik.lib.app.Lib2Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Lib2Application.class)
@WebAppConfiguration
public class Lib2ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
