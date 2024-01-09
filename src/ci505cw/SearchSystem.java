package ci505cw;

public class SearchSystem {
	/*
	 * 
	 * Pretty much this entire file is as follows:
	 * 	1. Gets the query
	 *  2. Checks if student either matches, or the first selection of letters 
	 *     match the query.
	 *  3. Returns the result as a full Student Info (for printing). 
	 * 
	 * TODO: Actually, let's return the value and NOT print it (if I have time).
	 * 
	 */
	
	public static String convertFromCourse(Courses course) {
    	switch(course) {
    	case CS:
    		return "Computer Science";
    	case CSG:
    		return "Computer Science for Games";
    	case SE:
    		return "Systems Engineering";
    	case ICT:
    		return "Information Computing Technology";
    	default:
    		return "unknown"; // error handling, at its basic level
    	}
    }
	
	public static void searchByFirstname(Student student, String query) {
		if (student.getFirstname().startsWith(query)) {
			System.out.println(student.getFullInfo());
		}; 
	}
	
	public static void searchBySurename(Student student, String query) {
		if (student.getSurename().startsWith(query)) {
			System.out.println(student.getFullInfo());
		}; 
	}
	
	public static void searchByCourse(Student student, Courses query) {
		if (student.getCourse() == query) {
			System.out.println(student.getFullInfo());
		}; 
	}
	
	public static void searchByModule(Student student, Module query) {
		if (student.getModule() == query) {
			System.out.println(student.getFullInfo());
		}; 
	}
	
	
	
	public static void searchByYear(Student student, String query) {
		if (student.getYear() == query) {
			System.out.println(student.getFullInfo());
		}; 
	}
	
	public static void searchById(Student student, int id) {
		if (student.getId() == id) {
			System.out.println(student.getFullInfo());
		}; 
	}
}
