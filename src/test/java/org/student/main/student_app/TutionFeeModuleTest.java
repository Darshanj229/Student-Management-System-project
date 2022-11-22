package org.student.main.student_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.student.main.dao.StudentOperations;
import org.student.main.exception.InvalidPaymentException;

public class TutionFeeModuleTest {
    
	@Test
	 public void testCase1() throws ClassNotFoundException, SQLException, InvalidPaymentException {
		assertEquals(2200, StudentOperations.payTutionFee(1002, 100));
	}
	@Test
	 public void testCase2() throws ClassNotFoundException, SQLException, InvalidPaymentException {
		assertNotEquals(3100, StudentOperations.payTutionFee(1002, 800));
	}
	
	
}
