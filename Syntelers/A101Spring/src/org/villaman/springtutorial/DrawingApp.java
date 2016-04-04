package org.villaman.springtutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) throws IOException {
		//the file
		//String file ="C:\\Users\\villaman\\workspace\\New folder\\A101Spring\\src\\pointconfig.properties";
		//DrawingApp app = new DrawingApp();
		//FileOutputStream here = app.openFile(file);
		//app.putPoints(here);
		//app.closeFile(here);
		// BeanFactory factory = new XmlBeanFactory(new
		// FileSystemResource("spring.xml"));
		// ApplicationContext is a sub-interface of BeanFactory
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 context.registerShutdownHook();
		//Triangle triangle = (Triangle) context.getBean("triangle");

		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
		//System.out.println(context.getMessage("greeting", null, "Default Greeting", null));

	}

	

	public FileOutputStream openFile(String pathToFile) throws FileNotFoundException {
		FileOutputStream thefile = null;

		try {
			thefile = new FileOutputStream(pathToFile);

		} catch (IOException ioe) {
			System.out.println("Null");

		}
		return thefile;
	}
	
	public void putPoints(FileOutputStream out) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String context = null;
		byte[] b = null;
		FillPoints points = new FillPoints();
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter point" + i + ".pointX");
			points.setPointX(scanner.nextInt());
			context = "point"+i+".pointX="+points.getPointX()+"\n";
			b = context.getBytes();
			out.write(b);

			System.out.println("Enter point" + i + ".pointY");
			points.setPointY(scanner.nextInt());
			context = "point"+i+".pointY="+points.getPointY()+"\n";
			b = context.getBytes();
			out.write(b);
		}
	}
	
	
	public void closeFile(FileOutputStream out) throws IOException{
		if(out != null){
			out.close();
		}
	}

}
