package bevco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import shopping.Connectionmanager;

public class Admin {
	
	
	Scanner s=new Scanner(System.in);
	Connection1  c=new Connection1();
	String pid,pname;
	int priceltr,priceqtr,pricefull,pricehalf;
	int qtyltr,qtyhalf,qtyfull,qtyqtr;
	public void vieweployee() throws ClassNotFoundException, SQLException
	{
		c.getconnection();
		Statement st=c.getconnection().createStatement();
		ResultSet r=st.executeQuery("select * from empreg");
		System.out.println("********************");
		while(r.next())
		{
			System.out.println(r.getString(1)+"  "+r.getString(2)+"  "+r.getString(3)+"  "+r.getString(4)+"  "+r.getString(5));
		}
		c.getconnection().close();
		
	}
	public void approveemp() throws ClassNotFoundException, SQLException
	{
		System.out.println("ENTER THE ID OF THE EMPLOYEE");
		String id=s.next();
		Connection1 c=new Connection1();
		int a=1;
	    PreparedStatement pt =c.getconnection().prepareStatement("update empreg set status=? where empid = ?");
		pt.setInt(1,a);
        pt.setString(2,id);
		pt.executeUpdate();
	}
	public void addproduct() throws ClassNotFoundException, SQLException
	{
		System.out.println("Enter the product ID");
		pid=s.next();
		System.out.println("Enter the product NAME");
		pname=s.next();
		System.out.println("DO YOU WANT INSERT LTR( ENTER 1)");
		int ch=s.nextInt();
		
		if(ch==1) 
		{
		System.out.println("Enter the  QUANTITYLTR");
		qtyltr=s.nextInt();
		System.out.println("Enter the product PRICE LTR");
		priceltr=s.nextInt();
		}
		else
		{
			qtyltr=0;
			priceltr=0;
			
		}
		
		System.out.println("DO YOU WANT INSERT FULL( ENTER 1)");
		int ch1=s.nextInt();
		
		if(ch1==1)
		{
		System.out.println("Enter the  QUANTITYFULL");
		qtyfull=s.nextInt();
		System.out.println("Enter the product PRICE FULL");
		pricefull=s.nextInt();
		}
		else
		{
			qtyfull=0;
			pricefull=0;
			
		}
		System.out.println("DO YOU WANT INSERT QTR( ENTER 1)");
		int ch2=s.nextInt();
		
		if(ch2==1)
		{
		System.out.println("Enter the  QUANTITYQTR");
		qtyqtr=s.nextInt();
		System.out.println("Enter the product PRICE QTR");
		priceqtr=s.nextInt();
		}
		else
		{
			qtyqtr=0;
			priceqtr=0;
			
		}
		System.out.println("DO YOU WANT INSERT HALF( ENTER 1)");
		int ch3=s.nextInt();
		if(ch3==1)
		{
		System.out.println("Enter the QUANTITYHALF");
		qtyhalf=s.nextInt();
		System.out.println("Enter the product PRICE HALF");
		pricehalf=s.nextInt();
		}
		else
		{
			qtyhalf=0;
			pricehalf=0;
			
		}
		PreparedStatement st=c.getconnection().prepareStatement("insert into addproduct(productid,"
				+ "productname,quantityltr,quantityfull,quantityqtr,quantityhalf,priceltr,priceqtr,pricefull,pricehalf)values(?,?,?,?,?,?,?,?,?,?)");
		st.setString(1,pid);
		st.setString(2, pname);
		st.setInt(3,qtyltr);
		st.setInt(4,qtyfull);
		st.setInt(5,qtyqtr);
		st.setInt(6,qtyhalf);
		st.setInt(7,priceltr);
		st.setInt(8,priceqtr);
		st.setInt(9,pricefull);
		st.setInt(10,pricehalf);
		
		st.executeUpdate();
		System.out.println("Successfully Inserted");
	    c.getconnection().close();
	

       }
	public void viewstock() throws ClassNotFoundException, SQLException
	{
		//Connection1 c=c1.getconnection();
		Statement st=c.getconnection().createStatement();
		String qry="select * from addproduct";
		ResultSet r=st.executeQuery(qry);
		System.out.println("PRODUCT ID"+"      "+"PRODUCT NAME"+"                        "+"QUANTYITY OF LTR"+"        "+"QUANTITY OF  FULL"+"        "+"QUANTYITY OF QTR"+"        "+"QUANTITY OF  HALF"+"        "+" PRICE OF LTR"+"        "+
		" PRICE OF HALF"+"         "+"PRICE OF QTR"+"         "+"PRICE OF FULL");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	/*	while(r.next())
		{
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("PRODUCT ID-> "+r.getString(1)+" PRODUCT NAME-> "+r.getString(2)+" QUANTITY OF LITR->"+r.getInt(3)+" QUANTITY OF  FULL->"+ r.getInt(4)+
					" QUANTITY OF QTR->"+r.getInt(5)+" QUANTITY OF HALF->"+r.getInt(6)+" PRICE OF LTR->"+r.getInt(7)+" PRICE OF HALF->"+r.getInt(8)+" PRICE OF QTR->"+r.getInt(9)+
					" PRICE OF FULL->"+r.getInt(10));
					

		}*/
		while(r.next())
		{
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println(r.getString(1)+"                    "+r.getString(2)+"                              "+r.getInt(3)+"                   "+ r.getInt(4)+
					"                    "+r.getInt(5)+"                  "+r.getInt(6)+"                         "+r.getInt(7)+"                      "+r.getInt(8)+"                 "+r.getInt(9)+
					"                       "+r.getInt(10));
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	 c.getconnection().close();
		
	     }
	public void updatestock() throws ClassNotFoundException, SQLException
	{

		int newpriceltr=0 ,newpricehalf = 0,newpricefull=0,newpriceqtr=0;
		int oldquantityltr=0,oldquantityhalf=0,oldquantityfull=0,oldquantityqtr=0;
		
		System.out.println("ENTER THE ID OF THE PRODUCT YOU HAVE TO UPDATE");
		String p1id=s.next();
		
		Statement st=c.getconnection().createStatement();
		ResultSet r=st.executeQuery("select quantityltr, quantityfull,quantityhalf,quantityqtr,priceltr,pricehalf,priceqtr, pricefull from addproduct where productid='"+p1id+"'");
		if(r.next())
		{
			oldquantityltr=r.getInt(1);
			oldquantityhalf=r.getInt(3);
			oldquantityfull=r.getInt(2);
			oldquantityqtr=r.getInt(4);
			
			newpriceltr=r.getInt(5);
			newpricehalf=r.getInt(6);
			newpricefull=r.getInt(8);
			newpriceqtr=r.getInt(7);;
			
			
		
			
		}
		
		
		System.out.println("DO YOU WANT UPDATE QUANTITY OF LTR( ENTER 1)");
		int ch=s.nextInt();
		
		if(ch==1) 
		{
		System.out.println("Enter the  QUANTITYLTR");
		qtyltr=s.nextInt();
		qtyltr+=oldquantityltr;
		}
		else
		{
			qtyltr+=oldquantityltr;
		}
		System.out.println("DO YOU WANT UPDATE PRICE OF LTR( ENTER 1)");
		int c1=s.nextInt();
		if(c1==1)
		{
		System.out.println("Enter the product PRICE LTR");
		priceltr=s.nextInt();
	
		}
		else
		{
			priceltr=newpriceltr;
		}
		
		System.out.println("DO YOU WANT UPDATE QUANTITY OF FULL( ENTER 1)");
		int ch1=s.nextInt();
		
		if(ch1==1)
		{
		System.out.println("Enter the  QUANTITYFULL");
		qtyfull=s.nextInt();
		qtyfull+=oldquantityfull;
		}
		else
		{
		qtyfull=oldquantityfull;	
		}
		System.out.println("DO YOU WANT UPDATE PRICE OF FULL( ENTER 1)");
		int c2=s.nextInt();
		if(c2==1)
		{
		System.out.println("Enter the product PRICE FULL");
		pricefull=s.nextInt();
	
		}
		else
		{
		pricefull=newpricefull;	
		}
		System.out.println("DO YOU WANT UPDATE QUANTITY OF QTR( ENTER 1)");
		int ch2=s.nextInt();
		
		if(ch2==1)
		{
		System.out.println("Enter the  QUANTITY OF QTR");
		qtyqtr=s.nextInt();
		qtyqtr+=oldquantityqtr;
		}
		else
		{
			qtyqtr=oldquantityqtr;
		}
		System.out.println("DO YOU WANT UPDATE PRICE OF QTR( ENTER 1)");
		int c3=s.nextInt();
		if(c3==1)
		{
		System.out.println("Enter the product PRICE FULL");
		priceqtr=s.nextInt();
		
		}
		else
		{
			priceqtr=newpriceqtr;
		}
		System.out.println("DO YOU WANT UPDATE QUANTITY OF HALF( ENTER 1)");
		int ch3=s.nextInt();
		
		if(ch3==1)
		{
		System.out.println("Enter the  QUANTITY OF HALF");
		qtyhalf=s.nextInt();
		qtyhalf+=oldquantityhalf;
		}
		else
		{
			qtyfull=oldquantityhalf;
		}
		System.out.println("DO YOU WANT UPDATE PRICE OF HALF( ENTER 1)");
		int c4=s.nextInt();
		if(c4==1)
		{
		System.out.println("Enter the product PRICE HALF");
		pricehalf=s.nextInt();
		}
		else
		{
			pricehalf=newpricehalf;
		}
		
		String sql="Update addproduct set quantityltr=?, quantityfull=?,quantityhalf=?,quantityqtr=?,priceltr=?,pricehalf=?,priceqtr=?, pricefull=?  where productid=?";
		PreparedStatement st1=c.getconnection().prepareStatement(sql);
	    st1.setInt(1,qtyltr);
		st1.setInt(2,qtyfull);
		st1.setInt(3,qtyhalf);
		st1.setInt(4,qtyqtr);
		st1.setInt(5,priceltr);
		st1.setInt(6,pricehalf);
		st1.setInt(7,priceqtr);
		st1.setInt(8,pricefull);
		st1.setString(9,p1id);
		st1.executeUpdate();
		System.out.println("UPDATE DATA SUCCESSFULLY");
		c.getconnection().close();
	
	}
	
	
	public void removestock() throws ClassNotFoundException, SQLException
	{
		c.getconnection();
		Statement st=c.getconnection().createStatement();
		System.out.println("ENTER THE PRODUCT ID DO YOU WANT TO DELETE");
		String a=s.next();
		PreparedStatement st1=c.getconnection().prepareStatement("DELETE  from  addproduct where productid=?");
		st1.setString(1,a);
		st1.executeUpdate();
		System.out.println("Successfully deleted");
		c.getconnection().close();
	
	}
}
