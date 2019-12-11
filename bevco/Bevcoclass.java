package bevco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bevcoclass {
//private static Connection NULL;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection1 cm=new Connection1();
		Admin a=new Admin();
		Employee e=new Employee();
		Registration r=new Registration();
		
		//cm.getconnection();
		Scanner s=new Scanner(System.in);
		int op1,op2,op3,choice,status = 0;
		String role=null;
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<BEVERAGE CORPORATION>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		do {
		System.out.println("^^^^^^^^^^\n1)ADMIN LOGIN\n2)EMPLOYEE LOGIN\n3)REGISTRATION\n4)LOG OUT(EXIT)\n^^^^^^^^^^^\n PLEASE CHOOSE THE OPTION ABOUVE YOU WANT^^^^^^");
		op1=s.nextInt();
		switch(op1)
		{
		case 1:
		{
			
			
			
			    System.out.print("USERNAME :");
				String user=s.next();
				System.out.println("???????????????????");
			    System.out.print("PASSWORD :");
				String pass=s.next();
			       
			        boolean cu = false;
			        boolean cu1 = false;
			        String query = "SELECT * FROM login WHERE username =?";
			        String query1="SELECT * FROM login WHERE password =?";
			        
			        
			            PreparedStatement    ps =cm.getconnection().prepareStatement(query);
			            ps.setString(1,user);
			            PreparedStatement    ps1 = cm.getconnection().prepareStatement(query1);
			        
			            ps1.setString(1,pass);
			            
			            ResultSet   rs = ps.executeQuery();
			            ResultSet   rs1 = ps1.executeQuery();
			            
			            if(rs.next())
			            {
			                cu = true;
			            }
			            if(rs1.next())
			            {
			            	cu1=true;
			            }
			            Statement st1=cm.getconnection().createStatement();
			            ResultSet r3=st1.executeQuery("select role from login where username='"+user+"'");
			    		if(r3.next())
			    		{
			    			role=r3.getString(1);
			    			
			    		}
			            
			         if(cu==true&&cu1==true&&role.equals("admin"))
			         {
			        	 
			        	 
			        	 System.out.println("Successfully logged in"); 
			        	 System.out.println("<<<<<<<<<<<<<>>>>>>>>>>>>>");
			        	 
			        		do {
			        			System.out.println("1)ADD PRODUCT\n2)VIEW STOCK\n3)REMOVE PRODUCTS\n4)UPDATE PRODUCT\n5)VIEW EMPLOYEE\n6)APPROVE EMPLOYEE\n7)SIGN OUT\nCHOOSE THE OPTION");
			        			op2=s.nextInt();
			        			switch(op2)
			        			{
			        			case 1:
			        			{
			        				
			        				a.addproduct();
			        				
			        				break;
			        			}
			        			case 2:
			        			{
			        			   a.viewstock();
			        				
			        				break;
			        			}
			        			case 3:
			        			{
			        				a.removestock();
			        				break;
			        			}
			        			case 4:
			        			{
			        				a.updatestock();
			        				
			        				
			        				break;
			        			}
			        			case 5:
			        			{
			        				
			        				
			        				a.vieweployee();
			        				break;
			        			}
			        			case 6:
			        			{
			        				
			        				
			        				a.approveemp();
			        				break;
			        			}
			        			
			        			
			        			case 7:
			        			{
			        				
			        				System.out.println("Log out Successfully");
			        				
			        				break;
			        			}
			        			
			        			default:
			        				System.out.println("CHOOSE CORRECT OPTION");
			        				
			        			op1=s.nextInt();
			        			
			        			}}while(op2!=7);
			        	 
			        	 
			         }
			        	 
			         else if(cu==false)
			        	 System.out.println("INCORRECT USERNAME OR USERNAME DOES'T EXIXST");
			         else if(cu1==false)
			        	 System.out.println("INCORRECT PASSWORD OR PASSWORD DOES'T EXIXST");
			
			         else
			        	 System.out.println("INCORRECT USERNAME OR PASSWORD\n PLEASE ENTER THE CORRECT CREDENTIALS");
			        	
				
				
				break;
				

		}
		case 2:
		{
			 System.out.println("USERNAME: ");
				String user=s.next();
			    System.out.println("PASSWORD :");
				String pass=s.next();
			       
				    boolean cu = false;
			        boolean cu1 = false;
			        String query = "SELECT * FROM login WHERE username =?";
			        String query1="SELECT * FROM login WHERE password =?";
			            PreparedStatement    ps = ((Connection) cm.getconnection()).prepareStatement(query);
			            ps.setString(1,user);
			            PreparedStatement    ps1 = ((Connection) cm.getconnection()).prepareStatement(query1);
			        
			            ps1.setString(1,pass);
			            Statement st=cm.getconnection().createStatement();
			    		ResultSet r2=st.executeQuery("select status from empreg where emailid='"+user+"'");
			    		
			    		
			    		if(r2.next())
			    		{
			    			status=r2.getInt(1);
			    			
			    		}
			    	
			    		else
			    		{
			    			System.out.println("Record not fount");
			    		}
			    		ResultSet r3=st.executeQuery("select role from login where username='"+user+"'");
			    		if(r3.next())
			    		{
			    			role=r3.getString(1);
			    			
			    		}
			    	
			    		else
			    		{
			    			System.out.println("Record not fount");
			    		}
			            
			            ResultSet   rs = ps.executeQuery();
			            ResultSet   rs1 = ps1.executeQuery();
			            
			            if(rs.next())
			            {
			                cu = true;
			            }
			          if(rs1.next())
			            {
			            	cu1=true;
			            }
			        if(status==1&&role.equals("employee"))
			        {
			         if(cu==true&&cu1==true)
			         {
			        	 System.out.println("Successfully logged in");
			        	 
			        	 do {
			     			System.out.println("<<<<<<<<<>>>>>>\n1)SELL PRODUCT\n2)VIEW STOCK\n3)Homepage\nCHOOSE THE OPTION");
			     			
			     			op3=s.nextInt();
			     			switch(op3)
			     			{
			     			case 1:
			     			{
			     				
			     				e.sell();
			     				
			     				
			     				break;
			     			}
			     			case 2:
			     			{
			     				
			     			e.viewproduct();
			     				
			     				break;
			     			}
			     			case 3:
			     			{
			     				
			     				System.out.println("Successfully loggedout");
			     				
			     				
			     				break;
			     			}
			     			default:
			     				System.out.println("CHOOSE CORRECT OPTION");
			     				System.out.println("<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>");
			     				op1=s.nextInt();
			     				

			     				
			     			}}while(op3!=3);
			         }
			         else if(cu1==false)
			        	 System.out.println("INCORRECT USERNAME OR USERNAME DOES'T EXIXST");
			         else if(cu1==false)
			        	 System.out.println("INCORRECT PASSWORD OR PASSWORD DOES'T EXIXST");
			
			         else
			        	 System.out.println("INCORRECT USERNAME OR PASSWORD\n PLEASE ENTER THE CORRECT CREDENTIALS");
			
			        }
			        else
			        {
			        	System.out.println("<<<<<<<<YOU ARE NOT A REGISTERED EMPLOYEE KINDLY CONTACT THE MANAGER");
			        }
			
			
			
			break;
		}
		
		case 3:
		{
			do {
			System.out.println("CHOOSE OPTION\n1)EMPLOYEE\n2)MANAGER\n3)Exit");
			choice=s.nextInt();
			switch(choice)
			{
			case 1:
			{
				r.empreg();
				break;
			}
			case 2:
				{
					r.adminreg();
					break;
				}
			case 3:
			{
				System.out.println("EXIT SUCCESSFULLY");
				break;
			}
			default:
			{
				System.out.println("Choose correct option");
				choice=s.nextInt();
			}
			
			}
			}while(choice!=3);
		
			break;
		}
		case 4:
		{
			
			   
			System.out.println("EXIT SUCCESSFULLY");
			
			break;
		}
		default:
		{
			System.out.println("########CHOOSE THE CORRECT OPTION########");
			op1=s.nextInt();
			
		}
			
			
			
		}
	}while(op1!=4);
		
		
		

	}

}
