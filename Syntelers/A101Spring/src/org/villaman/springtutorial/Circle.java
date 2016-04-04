package org.villaman.springtutorial;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
	
	private Points center;
	private ApplicationEventPublisher publisher;
	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Points getCenter() {
		return center;
		
	}

	@Resource(name="point4")
	public void setCenter(Points center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "Default Point Message", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		//System.out.println("Circle: Point is: (" + center.getX() + ", " + center.getY()+")");
		//System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
	}
	
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init of Circle");
	}
	
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy of Circle");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
