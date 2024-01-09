/*
		Ryan Penfold
		CI505 Coursework Submission
		"Basic Student Database" in Functional Programming - Assignment
		
		MAIN LOOP
*/
package ci505cw;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Purposely chose Command Line, it will take way too long to program a JavaFX UI at this point in time.

// If I choose to introduce a UI, I will continue to allow Command Line to be used too...

public class Main {

	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("CI505 - Student Database App [by Ryan Penfold]");
		// Initiliaze the student data....
		List<Student> students = Arrays.asList(
				new Student(1, "Adam", "Kelly", Courses.SE, Module.CI404, "2024"),
				new Student(2, "Frederick", "Hamilton", Courses.CS, Module.CI505, "2024"),
				new Student(3, "Henry", "Smith", Courses.CSG, Module.CI404, "2024"),
				new Student(4, "Sara", "Smith", Courses.ICT, Module.CI553, "2024"),
				new Student(5, "Lexi", "Con", Courses.ICT, Module.CI556, "2024"),
				new Student(6, "Rupert", "Jones", Courses.CSG, Module.CI404, "2023"),
				new Student(7, "Rhys", "Williams", Courses.SE, Module.CI505, "2023"),
				new Student(8, "Amanda", "Huggins", Courses.CS, Module.CI505, "2023"),
				new Student(9, "Beatrice", "Tills", Courses.CS, Module.CI505, "2023"),
				new Student(10, "Riley", "Jones", Courses.ICT, Module.CI404, "2023"),
				new Student(11, "Oliver", "Twist", Courses.CSG, Module.CI553, "2022"),
				new Student(12, "Samantha", "Gant", Courses.CSG, Module.CI556, "2022"),
				new Student(13, "Phoenix", "Wright", Courses.ICT, Module.CI404, "2022"),
				new Student(14, "Ianto", "Jones", Courses.SE, Module.CI505, "2022"),
				new Student(15, "Lauren", "DeSouza", Courses.CSG, Module.CI505, "2022"),
				new Student(16, "Gerald", "Mark", Courses.CS, Module.CI556, "2021"),
				new Student(17, "Rudolph", "Joake", Courses.CS, Module.CI505, "2021"),
				new Student(18, "Tom", "Green", Courses.ICT,Module.CI505, "2021"),
				new Student(19, "Daisy", "Laurie", Courses.SE,Module.CI505, "2021"),
				new Student(20, "Naomi", "Nomor", Courses.CSG,Module.CI404, "2021")
		);
		
		
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
					createStudent(students.size() + 1);
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
		
		module = Courses.valueOf(modulecode);
		
		System.out.println("\nPlease enter the student's starting year: ");
		year = in.next();
		
		return new Student(id, firstName, surename, course, module, year);

	}
	
}
