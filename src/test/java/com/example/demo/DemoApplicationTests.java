package com.example.demo;

import com.example.demo.logic.Point;
import com.example.demo.logic.TaskResolver;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void taskTest() {
		TaskResolver resolver=new TaskResolver();
		int actual=resolver.task(8,8,new Point(1,1),new Point(8,3));
		int expected=5;
		Assert.assertEquals(expected,actual);
		actual=resolver.task(8,8,new Point(2,1),new Point(1,3));
		expected=1;
		Assert.assertEquals(expected,actual);
		actual=resolver.task(8,8,new Point(4,5),new Point(6,8));
		expected=3;
		Assert.assertEquals(expected,actual);
	}

}
