package org.student.main.student_app;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.student.main.dao.StudentOperations;

public class GeneratedStudentIDModuleest {
     @RepeatedTest(3)
      public void generatedIDcheck1() throws ClassNotFoundException, SQLException, InterruptedException{
    	  assertEquals("91000",StudentOperations.generateStudentID(1000, 9));
		
      }
     @Test
     @Timeout(value=6000,unit = TimeUnit.MILLISECONDS)
     public void generatedIDcheck2() throws ClassNotFoundException, SQLException{
   	  assertTimeout(Duration.ofSeconds(6),()->StudentOperations.generateStudentID(1000, 9));
		
     }
     @Test
     @Disabled
     public void generatedIDcheck3() throws ClassNotFoundException, SQLException, InterruptedException{
      	  assertEquals("91005",StudentOperations.generateStudentID(1000, 9));
   		
        }
}
