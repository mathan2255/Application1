package bevco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
	Connection1 c1=new Connection1();
	Scanner s=new Scanner(System.in);
	public void adminreg() throws ClassNotFoundException, SQLException
	{
		
		String pid="^[0-9]*$";
		String pass="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		String user="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		Pattern paid=Pattern.compile(pid);
		Pattern puser=Pattern.compile(user);
		Pattern ppass=Pattern.compile(pass);
	
	 System.out.println("/////////////////////////MANAGER REGISTRARTION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
	 System.out.println("ENTER THE ID OF THE MANAGER");
     String eid=s.next();

		Matcher mid=paid.matcher(eid);
		
		if(mid.matches())
			System.out.println("valid");
		else
			{System.out.println("not valid");}
		
	 System.out.println("ENTER THE NAME OF THE MANAGER");
     String ename=s.next();
     System.out.println("ENTER THE EMAIL ID OF THE MANAGER");
     String email=s.next();
     Matcher muser=puser.matcher(email);
		if(muser.matches())
			System.out.println("valid");
		else {
			System.out.println("not valid");
			}
	
     System.out.println("ENTER THE NEW PASSWORD");
     String password=s.next();
     Matcher mpass=ppass.matcher(password);
		if(mpass.matches()) {
			System.out.println("valid");}

		else 
		{
		System.out.println("not valid");
	   
	}
     
   
	
		if(mpass.matches()&&muser.matches()&&mid.matches())
		{
			String role1="admin";
		PreparedStatement st=(c1.getconnection()).prepareStatement("insert into login(username,password,role)values(?,?,?)");
		st.setString(1,email);
		st.setString(2,password);
		st.setString(3,role1);
		
		st.executeUpdate();
		PreparedStatement st1=(c1.getconnection()).prepareStatement("insert into adminreg(id,name,emailid)values(?,?,?)");
		st1.setString(1,eid);
		st1.setString(2,ename);
		st1.setString(3,email);
		
		
		st1.executeUpdate();
		
		System.out.println("Successfully inserted");
		c1.getconnection().close();
		}
     
		else
			
			System.out.println("check the values");
		
	
     
    
		
		
		
	}
	
	
	
public void empreg() throws ClassNotFoundException, SQLException
{
	String password1=null;   
	String pid="^[0-9]*$";
		String pass="^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		String user="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		Pattern paid=Pattern.compile(pid);
		Pattern puser=Pattern.compile(user);
		Pattern ppass=Pattern.compile(pass);
	
	 System.out.println("/////////////////////////EMPLOYEE REGISTRATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
	 System.out.println("ENTER THE ID OF THE EMPLOYEEE");
     String eid=s.next();

		Matcher mid=paid.matcher(eid);
		
		if(mid.matches())
			System.out.println("valid");
		else
			{System.out.println("not valid");}
		
	 System.out.println("ENTER THE NAME OF THE EMPLOYEE");
     String ename=s.next();
     System.out.println("ENTER THE EMAIL ID OF THE EMPLOYEE");
     String email=s.next();
     Matcher muser=puser.matcher(email);
		if(muser.matches())
			System.out.println("valid");
		else {
			System.out.println("not valid");
			}
	 System.out.println("ENTER THE DESIGNATION OF THE EMPLOYEE");
     String edes=s.next();
     System.out.println("ENTER THE NEW PASSWORD");
     String password=s.next();
     Matcher mpass=ppass.matcher(password);
		if(mpass.matches()) {
			System.out.println("valid");}

		else 
		{
		System.out.println("not valid");
	   
	}
     
   
	
		if(mpass.matches()&&muser.matches()&&mid.matches())
		{
			String role="employee";
		PreparedStatement st=(c1.getconnection()).prepareStatement("insert into login(username,password,role)values(?,?,?)");
		st.setString(1,email);
		st.setString(2,password);
		st.setString(3,role);
		
		st.executeUpdate();
		PreparedStatement st1=(c1.getconnection()).prepareStatement("insert into empreg(empid,name,emailid,designation,status)values(?,?,?,?,?)");
		st1.setString(1,eid);
		st1.setString(2,ename);
		st1.setString(3,email);
		st1.setString(4,edes);
		st1.setString(5,"0");
		
		
		st1.executeUpdate();
		
		System.out.println("Successfully inserted");
		c1.getconnection().close();
		}
     
		else
			
			System.out.println("check the values");
		
	
     
    
	       
}
}