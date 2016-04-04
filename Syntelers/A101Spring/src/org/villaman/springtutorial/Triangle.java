package org.villaman.springtutorial;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape {

	private Points pointA;
	private Points pointB;
	private Points pointC;
	private ApplicationContext context;


	
	
	public Points getPointA() {
		return pointA;
	}




	public void setPointA(Points pointA) {
		this.pointA = pointA;
	}




	public Points getPointB() {
		return pointB;
	}




	public void setPointB(Points pointB) {
		this.pointB = pointB;
	}




	public Points getPointC() {
		return pointC;
	}




	public void setPointC(Points pointC) {
		this.pointC = pointC;
	}




	public void draw(){
		System.out.println("Drawing Triangle");
		System.out.println("Point1: " + "("+getPointA().getX() + ", " + getPointA().getY()+")");
		System.out.println("Point2: " + "("+getPointB().getX() + ", " + getPointB().getY()+")");
		System.out.println("Point3: " + "("+getPointC().getX() + ", " + getPointC().getY()+")");
	}




//	@Override
//	public void setApplicationContext(ApplicationContext context) throws BeansException {
//		this.context = context;
//		
//	}




//	@Override
//	public void setBeanName(String beanName) {
//		System.out.println("The name of the bean is: " + beanName);
//	}
	
	public void myInit(){
		System.out.println("Initializing the bean");
	}
	

	public void afterPropertiesSet1() throws Exception {
		
		System.out.println("The bean is distroyed here");
	}
//
//
//
//
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("Here the bean has been distroyed ");
//		
//	}
	
}
