package org.student.main.student_app;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.student.main.dao.StudentOperations;

public class LoginModuleTest {
	@RepeatedTest(3)
	
     public void logintest1() {
    	   assertSame(true,StudentOperations.login("Shantanu108", "12345"));
		
     }
	
	@Test
	public void logintest2() {
		assertNotSame(true,StudentOperations.login("Sushma", "567890"));
	}
	
	@Test
	@Disabled
	public void logintest3() {
		assertNotSame(false,StudentOperations.login("Soundarya", "99099"));
	}
}
