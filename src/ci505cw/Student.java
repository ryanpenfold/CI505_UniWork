package ci505cw;

public record Student(
	    int studentId,
	    String studentFirstName,
	    String studentSurename,
	    Courses studentCourse,
	    Module studentModule,
	    String studentYear
	) {
	    // Getters
	    public int getId() {
	        return studentId;
	    }

	    public String getFirstname() {
	        return studentFirstName;
	    }

	    public String getSurename() {
	        return studentSurename;
	    }

	    public Courses getCourse() {
	        return studentCourse;
	    }
	    
	    public Module getModule() {
	        return studentModule;
	    }

	    public String getYear() {
	        return studentYear;
	    }


	    // Setters

	    public void setFirstName(String firstName) {
	        studentFirstName = firstName;
	    }
	    
	    public void setModule(Module module) {
	        studentModule = module;
	    }

	    public void setSurename(String surename) {
	        studentSurename = surename;
	    }

	    public void setCourse(Courses course) {
	        studentCourse = course;
	    }

	    public void setYear(String year) {
	        studentYear = year;
	    }
	    
	    // Converters
	    
	    
	    
	    // Get Full Information
	    
	    public String getFullInfo() {
	    	return "Student #" + studentId + " is " + studentFirstName +
	    			" " + studentSurename + ", who is enrolled on " + 
	    			SearchSystem.convertFromCourse(studentCourse) + " studying " + studentModule + " as of " + studentYear;
	    }
	}
