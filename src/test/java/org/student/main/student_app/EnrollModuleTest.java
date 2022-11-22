package org.student.main.student_app;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.student.main.dao.StudentOperations;
import org.student.main.exception.RemainingBalanceException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnrollModuleTest {
	final Logger log=Logger.getLogger(org.student.main.dao.StudentOperations.class.getName());
	
	 @Order(1)
     @Test
     @EnabledOnOs(value = OS.LINUX)
 public void  TotalCourseFeecheck1() throws ClassNotFoundException, SQLException, RemainingBalanceException {
		 
		 log.info("TotalCourseFeecheck1 invoked");
	      assertTrue(StudentOperations.enroll(100, 900, 26600, 23300));    
        	              }
	 @Order(2)
	  @Test
	  @EnabledOnOs(value = OS.WINDOWS)
	  @EnabledOnJre(value =  JRE.JAVA_12)
	  public void TotalCourseFeeCheck2() throws ClassNotFoundException, SQLException, RemainingBalanceException
	  {
	      log.info("TotalCourseFeecheck2 invoked");
	      assertFalse(StudentOperations.enroll(110, 9876, 9800, 21000));     
	    
	  }
	 @Order(3)
	  @Test
	  @EnabledOnOs(value = {OS.LINUX, OS.WINDOWS})
	  public void TotalCourseFeeCheck3() throws ClassNotFoundException, SQLException, RemainingBalanceException
	  {
	      log.info("TotalCourseFeecheck3 invoked");
	      assertFalse(StudentOperations.enroll(103, 1700, 8400, 17600));    
	    
	  }
}       
