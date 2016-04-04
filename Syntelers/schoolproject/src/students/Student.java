package students;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Arrays;

public class Student {
	private String name;
	private int id;
	private double gpa;
	private String lastname;
	private double[] grades;
	private String[] courses;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public double[] getGrades() {
		return grades;
	}
	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	public double calculateGPA(double[] grades)
	{
		DecimalFormat df = new DecimalFormat("#.00"); 
		double gpa = 0;
		double gpapoints = 0;
		for(int i = 0; i < grades.length; i++){
			if(grades[i] >= 95 && grades[i] <= 100){
				gpapoints += 4.00;
			}
			else if(grades[i] >= 90 && grades[i] <= 94.9){
				gpapoints += 3.67;
			}
			else if(grades[i] >= 85 && grades[i] <= 89.9){
				gpapoints += 3.33;
			}
			else if(grades[i] >= 82.9 && grades[i] <= 84.9){
				gpapoints += 3.00;
			}
			else if(grades[i] >= 80.5 && grades[i] <= 82.8){
				gpapoints += 2.67;
			}
			else if(grades[i] >= 75.5 && grades[i] <= 79.9){
				gpapoints += 2.33;
			}
			else if(grades[i] >= 73.5 && grades[i] <= 75.4){
				gpapoints += 2.00;
			}
			else if(grades[i] >= 70 && grades[i] <= 72){
				gpapoints += 1.67;
			}
			else if(grades[i] >= 68 && grades[i] <= 69.9){
				gpapoints += 1.33;
			}
			else if(grades[i] >= 65.5 && grades[i] <= 67.9){
				gpapoints += 1.00;
			}
			else if(grades[i] <= 50 ){
				gpapoints += 0;
			}
			//qltPoints += grades[i] * credits[i];
			//points += grades[i];
			
		}
		gpa = gpapoints / grades.length;
		return Double.parseDouble(df.format(gpa));
	}
	
	@Override
	public String toString() {
		return "Student: Name= " + name +" " + lastname +", id= " + id + ", gpa= " + gpa + " grades= "
				+ Arrays.toString(grades) + ", courses= " + Arrays.toString(courses) + "]";
	}
	

}
