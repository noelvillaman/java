package students;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class MainSchool {

	public static void main(String[] args) {
		Random randomid = new Random();
		//puttingNames();
		//puttingLastNames();
		
		String[] names = {"Noel", "Pedro", "Morrel", "Julian", "Teza", "Jake", "Elijah", "Luis"};
		//names = puttingNames();
		String[] lastnames = {"Villaman", "Santana","Jonhson", "Rodriguez", "Zinboa", "Panal", "Major", "Perez" };
		String[] courses = {"Intro to Computer Science I", "Intro to Computer Science II", "Operating System I", 
				"Operating System II"};
		//double[] grades = {89.5, 98.0, 88.4, 90.3};
		double[] grades = new double[courses.length];

		Student[] studentlist = new Student[names.length];

		for(int i = 0; i < names.length; i++){
			studentlist[i] = new Student();
			studentlist[i].setName(names[i]);
			studentlist[i].setLastname(lastnames[i]);	
		    int randomInt = randomid.nextInt(1000000000);
		    studentlist[i].setId(randomInt);
		    studentlist[i].setCourses(courses);
		    for(int j = 0; j < courses.length; j++){
		    	//double randomGrade = 60.0 + randomid.nextDouble() * 100.0;
		    	double randomGrade = randomid.nextInt((100 - 50) + 1) + 50;
		    	grades[j] = randomGrade;

		    }
		    studentlist[i].setGrades(grades);
		    studentlist[i].setGpa(studentlist[i].calculateGPA(grades));
		    grades = new double[courses.length];
		}
		ArrayList<Student> students = new ArrayList<Student>();
		for(int i = 0; i < names.length; i++){
			students.add(studentlist[i]);
		}
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}
	
	public static String[] puttingNames()
	{
		
		Scanner in = new Scanner(System.in);
		int n;		
		n = in.nextInt();
		String[] names = new String[n];
		for(int i = 0; i < n; i++)
		{
			System.out.println("You have to enter " + n + " names");
			System.out.println("Enter " + i + " names:");
			names[i] = in.next();
		}
		return names;
	}
	
	public static String[] puttingLastNames()
	{
		
		Scanner in = new Scanner(System.in);
		int n;		
		n = in.nextInt();
		String[] lastnames = new String[n];
		for(int i = 0; i < n; i++)
		{
			System.out.println("You have to enter " + n + " last names");
			System.out.println("Enter " + i + " last names:");
			lastnames[i] = in.next();
		}
		return lastnames;
	}
}
