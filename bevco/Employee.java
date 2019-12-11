package bevco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	String pid,pname;
	int priceltr,priceqtr,pricefull,pricehalf;
	int qtyltr,qtyhalf,qtyfull,qtyqtr;

	Connection1 c=new Connection1();
	Scanner s=new Scanner(System.in);
	public void viewproduct() throws ClassNotFoundException, SQLException
	{
		Statement st=c.getconnection().createStatement();
		String qry="select * from addproduct";
		ResultSet r=st.executeQuery(qry);
		System.out.println("PRODUCT ID"+"      "+"PRODUCT NAME"+"       "+"QUANTYITY OF LTR"+"        "+"QUANTITY OF  FULL"+"        "+"QUANTYITY OF QTR"+"        "+"QUANTITY OF  HALF"+"        "+" PRICE OF LTR"+"        "+
		" PRICE OF HALF"+"         "+"PRICE OF QTR"+"         "+"PRICE OF FULL");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	
		while(r.next())
		{
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println(r.getString(1)+"                    "+r.getString(2)+"                   "+r.getInt(3)+"                   "+ r.getInt(4)+
					"                    "+r.getInt(5)+"                  "+r.getInt(6)+"                         "+r.getInt(7)+"                      "+r.getInt(8)+"                 "+r.getInt(9)+
					"                       "+r.getInt(10));
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	 c.getconnection().close();
		
	     
	}
	public void sell() throws ClassNotFoundException, SQLException
	{
		
		

		int newpriceltr=0 ,newpricehalf = 0,newpricefull=0,newpriceqtr=0;
		int oldquantityltr=0,oldquantityhalf=0,oldquantityfull=0,oldquantityqtr=0;
		int  a=0,b=0,c1=0,d=0,e=0,f=0,g=0,h=0;
		String name=null;
		
		System.out.println("ENTER THE ID OF THE PRODUCT YOU HAVE TO SELL");
		String p1id=s.next();
		
		
		Statement st=c.getconnection().createStatement();
		ResultSet r=st.executeQuery("select productname,quantityltr, quantityfull,quantityhalf,quantityqtr,priceltr,pricehalf,priceqtr, pricefull from addproduct where productid='"+p1id+"'");
		if(r.next())
		{   name=r.getString(1);
			oldquantityltr=r.getInt(2);
			oldquantityhalf=r.getInt(4);
			oldquantityfull=r.getInt(3);
			oldquantityqtr=r.getInt(5);
			
			newpriceltr=r.getInt(6);
			newpricehalf=r.getInt(7);
			newpricefull=r.getInt(9);
			newpriceqtr=r.getInt(8);;
			
			
		
			
		}
		else
		{
			System.out.println("Record not fount");
		}
		
		System.out.println("YOU WANT LITTRE(PRESS 1)");
		int ch=s.nextInt();
		if(ch==1)
		{
		System.out.println("Enter the  QUANTITYLTR");
		qtyltr=s.nextInt();
		if(qtyltr>oldquantityltr)
		{
			System.out.println("OUT OF STOCK");
		}
		else
		{
		a=oldquantityltr-qtyltr;
		e=qtyltr*newpriceltr;
		}
		
		}
		
		
		
		else
		{
			a=oldquantityltr;
		}
		
		
		System.out.println("YOU WANT FULL(PRESS 1)");
		int ch1=s.nextInt();
		
		if(ch1==1)
		{
		System.out.println("Enter the  QUANTITYFULL");
		qtyfull=s.nextInt();
		if(qtyfull>oldquantityltr)
		{
			System.out.println("OUT OF STOCK");
		}
		else
		{
		b=oldquantityfull-qtyfull;
		f=qtyfull*newpricefull;
		}
		}
		else
		{
		b=oldquantityfull;	
		}
	
		
		System.out.println("YOU WANT QUATER(PRESS 1)");
		int ch2=s.nextInt();
		
		if(ch2==1)
		{
		System.out.println("Enter the  QUANTITY OF QTR");
		qtyqtr=s.nextInt();
		if(qtyqtr>oldquantityltr)
		{
			System.out.println("OUT OF STOCK");
		}
		else
		{
		c1=oldquantityqtr-qtyqtr;
		g=qtyqtr*newpriceqtr;
		}
		}
		else
		{
			c1=oldquantityqtr;
		}
		
		System.out.println("YOU WANT HALF(PRESS 1)");
		int ch3=s.nextInt();
		
		if(ch3==1)
		{
		System.out.println("Enter the  QUANTITY OF HALF");
		qtyhalf=s.nextInt();
		if(qtyhalf>oldquantityltr)
		{
			System.out.println("OUT OF STOCK");
		}
		else
		{
		d=oldquantityhalf-qtyhalf;
		h=qtyhalf*newpricehalf;
		}
		}
		else
		{
			d=oldquantityhalf;
		}
		int total=e+f+g+h;
		
		System.out.println("\n");
		System.out.println("----------------------------------------------------");
		System.out.println("product name :"+name);
		System.out.println("Quantity     Price     Toatal ");
		if(ch==1)
		{
			System.out.println("      "+qtyltr+"       "+newpriceltr+"      "+e);
		}
		if(ch1==1)
		{
			System.out.println("      "+qtyfull+"       "+newpricefull+"      "+f);
		}
		if(ch2==1)
		{
			System.out.println("      "+qtyqtr+"       "+newpriceqtr+"      "+g);
		}
		if(ch3==1)
		{
			System.out.println("      "+qtyhalf+"        "+newpricehalf+"   "+h);
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("Total Amount = "+total);
				System.out.println("Bill Generated");
				System.out.println("Not Transferable");
				System.out.println("\n");
		String sql="Update addproduct set quantityltr=?, quantityfull=?,quantityhalf=?,quantityqtr=?  where productid=?";
		PreparedStatement st1=c.getconnection().prepareStatement(sql);
	    st1.setInt(1,a);
		st1.setInt(2,b);
		st1.setInt(3,c1);
		st1.setInt(4,d);
		st1.setString(5,p1id);
		
		st1.executeUpdate();
		c.getconnection().close();
	
		
		
		
	}

}
