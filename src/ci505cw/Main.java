/*
		Ryan Penfold
		CI505 Coursework Submission
		"Basic Student Database" in Functional Programming - Assignment
		
		MAIN LOOP
*/
package ci505cw;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Purposely chose Command Line, it will take way too long to program a JavaFX UI at this point in time.

// If I choose to introduce a UI, I will continue to allow Command Line to be used too...

public class Main {

	static List<String> fnames = List.of(
			"Adam", "Freddie", "Julie", "Alex", "Rhys", "John",
			"Liam", "Harry", "Riley", "Sara", "Julius", "Fransizka",
			"Norman", "Rupert", "Marie", "Lauren", "Hugh", "Jack", "Samantha", "Michelle",
			"Mitchell", "Ryan", "Lucas");
	static List<String> snames = List.of(
			"Smith", "Green", "Jones", "Gant", "Truman", "DeSouza",
			"Norman", "Laurie", "Brinson", "Johnson", "Gates", "Penfold",
			"Lines", "Brode", "Joake", "Hughes", "Barrowman", "McCreaves", "Holmes", "Watson",
			"Pond", "Williams", "Cooper");
	static List<Courses> courselist = List.of(Courses.CS, Courses.CSG, Courses.ICT, Courses.SE);
	static List<Module> modulelist = List.of(Module.CI404, Module.CI505, Module.CI553, Module.CI556);
	static List<String> yearslist = List.of("2020","2021","2022","2023","2024");
	
	static List<Student> students = new ArrayList<>();
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("CI505 - Student Database App [by Ryan Penfold]");
		// Initiliaze the student data....
		populateDatabase(20);
				
		
		
		/// For loop, lamba function listing the students. COMMENTED OUT FOR EXTENSION
		// students.forEach(student -> {System.out.println(student.getFirstname());});
		
		int i = 1;
		while(i != 0) { // Infinite Loop until Finished...
			Scanner in = new Scanner(System.in); // Setup Scanner for Input
			System.out.println(""
				+ "Main Menu\n"
				+ "=========\n"
				+ "Would you like to:\n"
				+ "	[1] Add a student\n"
				+ "	[2] Remove a student\n"
				+ "	[3] List all students\n"
				+ "	[4] Search for a student\n"
				+ "	[5] Exit\n");
			System.out.print("Please enter a number:");
			try {
				int mmOption = in.nextInt(); // Sets 'Main Menu' Option
				switch(mmOption) {
				case 1:
					students.add(createStudent(students.size() + 1));
					break;
				
				case 2:
					System.out.print("Please enter a Student ID to delete: ");
					int toDelete = in.nextInt();
					
					students.remove(toDelete - 1);
				
				case 3:
					students.forEach(student -> System.out.println(student.getFullInfo()));  // not working...?
					break;
				
				case 4:
					searchRun(students);
					break;
					
				case 5:
					i = 0;
					break;
				}
			} catch(Exception e) {
				System.out.println("\nFatal Error, we cannot continue running here! - " + e);
				break;
				
			}
		}
		System.out.println("Exiting...");
		
	}
	
	public static void searchRun(List<Student> students) {
		Scanner in = new Scanner(System.in); // Setup Scanner for Input
		System.out.print(
				"Search Menu\n"
			  + "===========\n" +
				"How would you like to search by:\n" +
				"	[1] Student ID\n" +
				"	[2] First name\n" +
				"	[3] Last name\n" +
				"	[4] Course\n" +
				"	[5] Module\n" +
				"	[6] Year\n" +
				"	[Any Other Number] Back to Main Menu\n\n" +
				"Please enter a number...");
		int smOption = in.nextInt(); // Get SearchMenu Option
		String SearchKey;
		switch(smOption) {
		case 1:
			System.out.print("\n\nPlease enter a integer: ");
			int searchKeyId = in.nextInt(); // Put query in int.
			
			// Run Lamba to find Students by Id...
			// ...then print them
			students.forEach(student -> {SearchSystem.searchById(student, searchKeyId);});
			break;
		case 2:
			System.out.print("\n\nPlease enter a string: ");
			SearchKey = in.next(); // Put query in string.
			
			// Run Lamba to find Students by Firstname...
			// ...then print them
			students.forEach(student -> {SearchSystem.searchByFirstname(student, SearchKey);});
			break;

		case 3:
			System.out.print("\n\nPlease enter a string: ");
			SearchKey = in.next(); // Put query in string.
			
			// Run Lamba to find Students by Surename...
			// ...then print them
			students.forEach(student -> {SearchSystem.searchBySurename(student, SearchKey);});
			break;
			
		case 4:
			System.out.print("\n\nPlease enter a string [CS/CSG/SE/ICT]:");
			SearchKey = in.next(); // Put query in string.
			Courses course = Courses.valueOf(SearchKey);
			
			// Run Lamba to find Students by Course...
			// ...then print them
			students.forEach(student -> {SearchSystem.searchByCourse(student, course);});
			break;
		
		case 5:
			System.out.print("\n\nPlease enter a valid module code:");
			SearchKey = in.next(); // Put query in string.
			Module module = Module.valueOf(SearchKey);
			
			// Run Lamba to find Students by Course...
			// ...then print them
			students.forEach(student -> {SearchSystem.searchByModule(student, module);});
			break;
			
		case 6:
			System.out.print("\n\nPlease enter a string year:");
			SearchKey = in.next(); // Put query in string.
			
			// Run Lamba to find Students by Year...
			// ...then print them
			students.forEach(student -> {SearchSystem.searchByYear(student, SearchKey);});
			break;
		}
	}
	
	public static Student createStudent(int id) {
		String firstName = "John";
		String surename = "Smith";
		Courses course = Courses.ICT;
		Module module = Module.CI404;
		String year = "2024";
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nPlease enter the student's firstname: ");
		firstName = in.next();
		
		System.out.println("\nPlease enter the student's surname: ");
		surename = in.next();
		
		System.out.println("Key Codes\n=========");
		System.out.println("CS = " + SearchSystem.convertFromCourse(Courses.CS));
		System.out.println("CSG = " + SearchSystem.convertFromCourse(Courses.CSG));
		System.out.println("SE = " + SearchSystem.convertFromCourse(Courses.SE));
		System.out.println("ICT = " + SearchSystem.convertFromCourse(Courses.ICT));
		System.out.println("\nPlease enter the student's course code: ");
		String coursecode = in.next().toUpperCase();
		
		course = Courses.valueOf(coursecode);
		
		System.out.println("\nPlease enter the student's module code "
				+ "(CI followed by 404/505/553/556): ");
		String modulecode = in.next().toUpperCase();
		
		module = Module.valueOf(modulecode);
		
		System.out.println("\nPlease enter the student's starting year: ");
		year = in.next();
		
		return new Student(id, firstName, surename, course, module, year);

	}
	
	public static void populateDatabase(int rounds) {
		Random rand = new Random(); // https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
		for(int i = 1; i<rounds+1;i++) {
			students.add(new Student(i, 
					fnames.get(rand.nextInt(20)), 
					snames.get(rand.nextInt(20)), 
					courselist.get(rand.nextInt(4)), 
					modulelist.get(rand.nextInt(4)), 
					yearslist.get(rand.nextInt(5))					
					));
		}
		System.out.println(rounds + " student records generated.");
	}
	
}
