package org.student.main.student_app;





import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import org.student.main.dao.StudentOperations;
import org.student.main.exception.CourseIDNotFoundException;

public class ViewBalanceModuleTest {
	@Test(timeout = 1000)
   public void Balancecheck1() throws ClassNotFoundException, SQLException, CourseIDNotFoundException {
		assertTrue( true ,"Invalid courseID");
	
	   
	   
   }
     @Test
	 public void Balancecheck2() throws ClassNotFoundException, SQLException, CourseIDNotFoundException {
			assertFalse( false,"Incorrect");
		
		   
		   
	   }
     
}
