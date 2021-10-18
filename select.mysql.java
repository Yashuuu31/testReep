
package demo;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
       try
           	{
		Connection cn;
		Statement st;
		ResultSet rs;

Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hns","root","");

System.out.println("Connection done");

  	      st=cn.createStatement();
	     rs = st.executeQuery("select * from stud");

while(rs.next())

{
         	System.out.println(rs.getString(1));
	System.out.println(rs.getString(2));
	System.out.println(rs.getString(3));

      }
     	cn.close();
	 rs.close();

	}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
   }
