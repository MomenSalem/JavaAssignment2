package assignment;

import java.util.*;//import for scan and date

public class Driver {// driver class (main class)

	public static void main(String[] args) {
		System.out.println("Please Enter number of calsses");
		Scanner in = new Scanner(System.in);// define scanner
		int number_classes = in.nextInt();// scan number of classes
		Student[][] classes = new Student[number_classes][];// Create two dimensional array of type student(class Student)
		for (int i = 0; i < classes.length; i++) {// for loop to scan number of student in these classes
			System.out.println("Please Enter number of student in class #" + (i + 1));
			int number_students = in.nextInt();// scan number of student in the class
			if (number_students < 1 || number_students > 100)// number of student must be between 1 and 100
				System.out.println("There is an Error in number of student(most be between 1 and 100)!!");// the number of student is in valid
			else {
				classes[i] = new Student[number_students];// create columns in row of type class(ragged array)the columns if differ (each column represent number of student in class)
				for (int j = 0; j < classes[i].length; j++) {// for loop to scan the needed values and informations for student
					System.out.println(
							"Please Enter first name,second name,ID,and date of birth(first start with year then month and last day) for student #"
									+ (j + 1));
					classes[i][j] = new Student(in.next(), in.next(), in.nextInt(),
							new Date(in.nextInt() - 1900, in.nextInt() - 1, in.nextInt()));// constructor in Student  class to have name, id, and other things
				}
			}
		}
		for (int i = 0; i < classes.length; i++) {// loop to sort student as wanted
			sortStudents(classes);// call method for sorting
			System.out.println("Student after sorting in class #" + (i + 1) + " is");
			for (int k = 0; k < classes[i].length; k++) {// for loop to print students after sorting operation
				System.out.println("" + classes[i][k].getFirst_name().toUpperCase().concat(" ")
						.concat(classes[i][k].getLast_name().toUpperCase()));
			}
			for (int j = 0; j < classes[i].length; j++) {// for loop to have the grade for students after class sorted
				System.out.println("Please Enter the grade for student #" + (j + 1) + " in class #" + (i + 1));
				classes[i][j].setGrade(in.nextInt());// save grades
			}
		}
		printStudent(classes);// call method for printing the classes and students
		in.close();// close the scanner
	}

	public static void sortStudents(Student[][] cla) {//method for sorting students
		for (int i = 0; i < cla.length; i++) {//for loop for all classes
			for (int k = 1; k < cla[i].length; k++) {//for loop for all students from 1 to rows class -1
				for (int m = 0; m < cla[i].length - k; m++) {//loop to compare students rom zero to rows - k
					boolean swap = false;//Boolean to swap or not start condition is false
					cla[i][m].setLast_name(cla[i][m].getLast_name().toUpperCase());//set the last student to upper case letter for comparing
					String check1 = cla[i][m].getLast_name();//let check1 first student 
					String check2 = cla[i][m + 1].getLast_name().toUpperCase();//let check2 second student 
					for (char j = 'A'; j <= 'Z'; j++) {//loop to compare the letters from A to Z
						int num1 = 0, num2 = 0;//start with two numbers equal zero
						for (int z = 0; z < check1.length(); z++) {//loop to check if the j (character) is in the check1
							if (check1.charAt(z) == j)//this means character j is exist in check1
								num1++;//increment the first number 
						}
						for (int q = 0; q < check2.length(); q++) {//like above loop but check the second student
							if (check2.charAt(q) == j)
								num2++;
						}
						if (num1 == num2) {//if the number of characters is equal let j = B then C,.... etc
							continue;//Continue the loop
						} else if (num1 < num2) {//if the number2 if greater change swap to true (to swap students)
							swap = true;
						}
					}
					if (swap) {//if swap is true we must swap
						Student temp = cla[i][m];//temp is Student data type for swapping
						cla[i][m] = cla[i][m + 1];
						cla[i][m + 1] = temp;
					}
				}
			}
		}
	}

	public static double[] averageStudent(Student[][] st) {//method to calculate the average of class
		double[] average = new double[st.length];//return average for all classes as one dimensional array
		for (int row = 0; row < st.length; row++) {//loop for classes
			int sum = 0;//initial condition for sum is 0
			for (int column = 0; column < st[row].length; column++) {//loop for students
				sum += st[row][column].getGrade();//get grade for student in class number(row + 1)
			}
			average[row] = Math.rint(((double) sum / st[row].length)*100)/100;//calculate average

		}
		return average;//return average array

	}

	public static void printStudent(Student[][] student) {//print method
		for (int i = 0; i < student.length; i++) {//loop for classes
			for (int j = 0; j < student[i].length; j++) {//loop to print specific information about students in class #(i+1)
				student[i][j].setEmail();//set email for students
				System.out.println(
						student[i][j].getFirst_name().toUpperCase() + " " + student[i][j].getLast_name().toUpperCase()
								+ ", email : " + student[i][j].getEmail() + " , " + student[i][j].getGrade());
			}
			double[] avg = new double[student.length];//create variable avg for calling average for class
			avg = averageStudent(student);
			System.out.println("AVG of class #" + (i + 1) + " : " + avg[i] + "%");//print average for class
		}
	}
}
