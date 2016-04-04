package org.villaman.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.villaman.spring.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService service = context.getBean("shapeService", ShapeService.class);
		//System.out.println(service.getCircle().getName());
		//System.out.println(service.getTriangle().getName());
		System.out.println(service.getCircle());
	}

}
