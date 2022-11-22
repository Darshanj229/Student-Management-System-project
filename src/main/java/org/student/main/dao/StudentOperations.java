package org.student.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.student.main.exception.CourseIDNotFoundException;
import org.student.main.exception.InvalidPaymentException;
import org.student.main.exception.RemainingBalanceException;






public class StudentOperations {
 
	 public static String generateStudentID(int studentID,int gradeYear) throws ClassNotFoundException, SQLException, InterruptedException {
		 TimeUnit.SECONDS.sleep(6);
		  try
		   {
			  Connection connection = MysqlDBMSConnection.dbconnect();
		      PreparedStatement statement=connection.prepareStatement("Select generatedID from student where studentID = ? and gradeYear = ?");
		      statement.setInt(1, studentID);
		      statement.setInt(2, gradeYear);
		      ResultSet result = statement.executeQuery();
		      result.next();
		     String generatedID = gradeYear +""+ studentID;
		      generatedID = result.getString("generatedID");
		      return generatedID;
		      
		  }
		  catch(SQLException e) {
			  System.out.println("Invalid student id or gradeYear");
		  }
		  catch(Exception e) {
			  System.out.println("Something went Wrong");
		  }
	         return null;
	 }
 public static boolean enroll(int courseID,long courseFees,double TotalCourseFees,long RemainingBalance) throws ClassNotFoundException, SQLException, RemainingBalanceException {
	   
		   Connection connection =  MysqlDBMSConnection.dbconnect();
			 PreparedStatement statement=connection.prepareStatement("select  courseName  from course  where courseID = ? and courseFees = ?" );
			 statement.setInt(1, courseID);
			 statement.setLong(2, courseFees);
			 
			  
			 ResultSet result = statement.executeQuery();
			  result.next();
				  
				  String courseName = result.getString("courseName");
				  
				  
				  
				  System.out.println("CourseEnrolled : " +courseName);
					 
			  
			 statement = connection.prepareStatement("select TotalCourseFees from registration where courseID = ?");
			 statement.setInt(1, courseID);
			  
			  
			  TotalCourseFees = TotalCourseFees + courseFees;
				
			     
			
			     statement = connection.prepareStatement("update registration set TotalCourseFees = ? where courseID = ?");
				 statement.setDouble(1,new Double(TotalCourseFees));
				 statement.setInt(2, courseID);
				  
				 
				 
				 
				 int affectedRows = statement.executeUpdate();
				 if(affectedRows>0) {
					 System.out.println("Total course fees is :"+TotalCourseFees);
				 }
				 else {
					 System.out.println("No record found");
				 }
				 
				 statement = connection.prepareStatement("select RemainingBalance from registration where TotalCourseFees = ? ");
				 statement.setDouble(1,TotalCourseFees);
			
				
			   
				
				  if(RemainingBalance>TotalCourseFees) {
					  RemainingBalance -= TotalCourseFees;
					  statement = connection.prepareStatement("update registration set RemainingBalance = ? where TotalCourseFees = ?");
					  statement.setDouble(1, new Long(RemainingBalance));
					  statement.setDouble(2, new Double(TotalCourseFees));
					  
					  
					  if(statement.executeUpdate()>0) {
						  System.out.println("Remaining Balance :" +RemainingBalance);
					  }else {
						 
					System.out.println("Rows not updated");
					  }
					  
					  
					 
					  
					  
				  }else {
					  throw new RemainingBalanceException("Remaining balance not found");
				  }
				  return true;
	   }	
 
	
 
 
	
	
 
	 
		 
		 
	
		public static boolean login(String userName, String password) {
		try
		{
		Connection connection= MysqlDBMSConnection.dbconnect();
		PreparedStatement statement=connection.prepareStatement("select * from student where username=?");
		statement.setString(1, userName);
		ResultSet result=statement.executeQuery();
		if(result.next())
		{
		
			if(result.getString("pass_word").equals(password))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Something went wrong!! "); 
		}
		catch(SQLException e)
		{
			System.out.println("Username is incorrect!! "); 
		}
		return false;
		
 
		 
	}
		
		
	
	public static int ViewBalance(int courseID) throws ClassNotFoundException, SQLException, CourseIDNotFoundException {
		int viewBalance = 0;
		if(courseID !=0)
		try {
			Connection connection = MysqlDBMSConnection.dbconnect();
			PreparedStatement statement = connection.prepareStatement("Select RemainingBalance  from registration where courseID = ?");
			statement.setInt(1,courseID);
			
			ResultSet result = statement.executeQuery();
			result.next();
			
			 viewBalance = result.getInt("RemainingBalance");
			
			
		}
	 
	   catch(Exception e) {
		   throw new CourseIDNotFoundException("Invalid courseID");
		  
	   }
		return viewBalance;
		
		
	
		
		
		
	  
		
	}

	
	public static int payTutionFee(int studentID,int payment) throws SQLException, InvalidPaymentException, ClassNotFoundException {
	
	
		Connection connection = MysqlDBMSConnection.dbconnect();
		 
		
		PreparedStatement	statement = connection.prepareStatement("Select RemainingBalance from registration where studentID =?");
	    statement.setInt(1,studentID);
	    
	
	ResultSet result = statement.executeQuery();
	result.next();
	
	int RemainingBalance = result.getInt("RemainingBalance");
	
	int tutionBalance = 0;
	if(payment<RemainingBalance) {
		 
		tutionBalance  =  RemainingBalance- payment;
		 statement=connection.prepareStatement("update registration   set RemainingBalance=? where studentID=?");
		 statement.setInt(1, new Integer(tutionBalance));
		 statement.setInt(2, studentID);
		 
	
	if(statement.executeUpdate()>0)
	   {
		  
		return tutionBalance;
 
	   }
	   else
	   {
		   return 0;
	   }
	}
	else
	{
		throw new InvalidPaymentException("Invalid Tution Amount !!!");
	}
	
	


	}



	
	
			
	

		

	public static void checkStudentStatus(int studentID, int courseID) throws ClassNotFoundException, SQLException {

		Connection connection= MysqlDBMSConnection.dbconnect();
		PreparedStatement statement=connection.prepareStatement(" select studentName,studentID from student where studentID = ?");
		statement.setInt(1, studentID);
	
		ResultSet result=statement.executeQuery();
		
		     result.next();
			String studentName = result.getString("studentName");
			System.out.println("Student name : " +studentName);
			System.out.println("Student ID : " +studentID);
		
		 statement=connection.prepareStatement(" select courseName from course where courseID = ?");
          statement.setInt(1, courseID);
          result=statement.executeQuery();
          result.next();
          System.out.println("Course name : " +result.getString("courseName"));
			
  		
		 statement=connection.prepareStatement(" select RemainingBalance from registration where studentID = ?");
		 statement.setInt(1, studentID);
         result=statement.executeQuery();
         result.next();
         System.out.println("RemainingBalance : " +result.getLong("RemainingBalance"));
			
	}
	
	
	}
	
