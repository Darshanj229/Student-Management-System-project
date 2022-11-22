package org.student.main.student_app;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.ResultSet;

import org.junit.jupiter.api.Test;
import org.student.main.dao.StudentOperations;

public class CheckStudentStatusModuleTest {
String string = null;


	@Test
	public void failTest() {
	int studentID = 1005;
	int courseID = 110;
	 if((studentID == 1005)&&(courseID == 110)) {
		 fail("StudentID and CourseID not found");
	 }
	
	}
}
