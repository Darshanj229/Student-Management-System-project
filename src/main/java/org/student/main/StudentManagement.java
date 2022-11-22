package org.student.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.student.main.dao.StudentOperations;
import org.student.main.exception.CourseIDNotFoundException;
import org.student.main.exception.InvalidPaymentException;
import org.student.main.exception.RemainingBalanceException;





public class StudentManagement 
{
    
	private static String courses = null;
    
	
	
	static BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in)); 
	   public static void main(String[] args) throws  IOException, ClassNotFoundException, SQLException, CourseIDNotFoundException, RemainingBalanceException, InterruptedException   {
		   System.out.println("=========================== WELCOME TO STUDENT MANAGEMENT SYSTEM =========================");
		   boolean status = false;
		   do
			{
			
				System.out.println("====================================================================================");
				System.out.print("\t\t  Username : ");
				String userName=bufferedReader.readLine();
				System.out.println();
				System.out.print("\t\t  Password : ");
				String password=bufferedReader.readLine();
				System.out.println("====================================================================================");
				status=StudentOperations.login(userName, password);
				
				if(status)
				{
				do
				{
					System.out.println("====================================================================================");
					System.out.println("=========================== STUDENT OPERATIONS =========================");
					System.out.println("====================================================================================");
					System.out.println("\t\t  Enter 1-> Generate ID of the student");
					System.out.println("\t\t  Enter 2-> Enroll");
					System.out.println("\t\t  Enter 3-> TutionBalance ");
					System.out.println("\t\t  Enter 4-> payTutionfee.");
					System.out.println("\t\t  Enter 5-> status ");
					System.out.println("\t\t  Enter 6-> logout ");
					
					System.out.println("====================================================================================");
					System.out.println("\t\t  Enter a valid input between 1 to 6:");
					int choice=Integer.parseInt(bufferedReader.readLine());
					
					switch(choice) {
					case 1:
						  System.out.println("Enter the student_id:");
						  int studentID = Integer.parseInt(bufferedReader.readLine());
						  
						  System.out.println("Enter the gradeYear of student:");
						  int gradeYear = Integer.parseInt(bufferedReader.readLine());
						  if(StudentOperations.generateStudentID(studentID, gradeYear)!=null)
						   System.out.println("Generated id is: "+StudentOperations.generateStudentID(studentID, gradeYear));
						  break;
						  
					case 2:
						   try {
							   System.out.println("Enter the courseID :");
							   int courseID = Integer.parseInt(bufferedReader.readLine());
							  
							 
			                   System.out.println("Enter the courseFees : ");
			                   long courseFees = Long.parseLong(bufferedReader.readLine());
			                   
			                   System.out.println("Enter the TotalCourseFees :");
			                   double TotalCourseFees = Double.parseDouble(bufferedReader.readLine());
			                   
			                   System.out.println("Enter the Remaining Balance :");
			                   long RemainingBalance = Long.parseLong(bufferedReader.readLine());
	                           
	                           System.out.println(StudentOperations.enroll(courseID,courseFees,TotalCourseFees,RemainingBalance));
			                   break; 
						   }
						     catch(SQLException e ) {
						    	 System.out.println("Operation not performed");
						     }
						catch(RemainingBalanceException  e) {
							System.out.println("Remaining Balance not performed");
						}
							 
						   break;
						   
		                    			                    
		                   
		                    
						 
		                   
		                    
		                    
						 
						
					    
					case 3:
						    try {
						    	System.out.println("Enter the courseID  :");
								  int courseID= Integer.parseInt(bufferedReader.readLine());
								
								    
								System.out.println("View Balance : "+StudentOperations.ViewBalance(courseID));	
								
							
						    } 
							catch(NumberFormatException e) {
						    	System.out.println("Input not correct");
						    }
						   catch(CourseIDNotFoundException e ) {
							   System.out.println("CourseID not found");
						   }
						break;
						
					
					case 4:
						System.out.println("Enter the studentID of the student  :");
				      studentID = Integer.parseInt(bufferedReader.readLine());
						
						 System.out.println("Enter the payment:");
					     int payment = Integer.parseInt(bufferedReader.readLine());
						
						
						try {
						
							int result = StudentOperations.payTutionFee(studentID, payment);
							System.out.println("Tution balance fee is :" +result);
						}
						catch (SQLException e) {
							System.out.println("Invalid studentID");
						}
						catch(InvalidPaymentException e) {
							System.out.println("Invalid Tution Amount !!!");
						}
						break;
						
					case 5:
						try{
							
						  
						   System.out.println("Enter studentID:");
						   studentID = Integer.parseInt(bufferedReader.readLine());
						   
						   System.out.println("Enter courseID:");
						 int  courseID = Integer.parseInt(bufferedReader.readLine());
						   
						   
							System.out.println("*******************STUDENT DETAIL**************************************");
						    System.out.println("***********************************************************************");
						    
						   StudentOperations.checkStudentStatus(studentID,courseID);
						    
						} catch (SQLException e){
							System.out.println("Invalid StudentID /CourseID");
						}	
						 break;
			        		
					case 6:
						status = false;
						System.out.println("Successfully logged out Bye!!");
						System.out.println("*******************************");
			            break;
						
					default :
						 System.out.println("************************************");
						 System.out.println("Choice Incorrect!!");
					
					
				     }
				}while(status);
				
				}
				
					else 
				{
					System.out.println("====================================================================================");
					System.out.println("Incorrect username or password!!");
					System.out.println("====================================================================================");
				}
				
			}	
		   while(status);
				
}
	   
}   
		 
  
				
			
				
