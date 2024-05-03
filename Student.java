package assignment;

import java.util.*;

public class Student {//Student class definition
	private String first_name;//Student variable and constants(if exist) first name as string data type private because we want to save the content in this class
	private String last_name;//last name as sting data type
	private int id;//id for student as int but we don't use it just we scan and save it 
	private Date date_of_birth = new Date();//date of birth as date data type
	private int grade;//grade for student as int
	private String email;//the last one is email as String date type (not from user)(automatic email)
	public Student() {//default constructor without argument

	}

	public Student(String first_name, String last_name, int id, Date date_of_birth) {//my basic construct that accept first, last name, id, and date of birth for students in class
		super();
		this.first_name = first_name;//accept variables 
		this.last_name = last_name;
		this.id = id;
		this.date_of_birth = date_of_birth;
	}

	public String getFirst_name() {//method to get first name we use this method in driver class so we want it
		return first_name;//return the first name for student
	}

	public String getLast_name() {//getting last name method we use alot in driver for such sort or print
		return last_name;
	}

	public void setLast_name(String last_name) {//scan name from user by this method
		this.last_name = last_name;
	}

	public int getGrade() {//we need this method for calculate average and print
		return grade;
	}

	public void setGrade(int grade) {//we need this method for scanning
		this.grade = grade;
	}

	public String getEmail() {//we need this getter for print
		return email;
	}

	public void setEmail() {//this method is built by me for create email for each student
		first_name = first_name.toLowerCase();//first name in lower case for email
		first_name = first_name.strip();//if first name start with " "(space) ignore the space
		last_name = last_name.toLowerCase();//make last name like first name above
		last_name = last_name.strip();
		String []token = first_name.split("");//cut and take the first name field in String array and have first letter for first name for making email
		email = token[0].concat(last_name).concat("@ritaj.birzeit.edu");//make the email by first letter for first name and with concatenation with last name and(@ritaj.birzeit.edu extension)
	}
	
}
