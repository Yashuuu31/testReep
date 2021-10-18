/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package upadetemysql;
import java.sql.*;
/**
 *
 * @author mohit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try
           	{
		Connection cn;
		Statement st;
		ResultSet rs;

Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hns","root","");

System.out.println("Connection done..........");

  	     st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

         int i=st.executeUpdate("update stud set city='rajkot' where city='goa' ");

if(i>0)
{	
    System.out.println("update success..........");
}

else
{
             System.out.println("record not found so not updated"); }


          rs = st.executeQuery("select * from stud");

while(rs.next())

{
  	int id  = rs.getInt(1);
	String name = rs.getString(2);
	String city=rs.getString(3);

         System.out.println("id: " + id);
         System.out.println("name: " + name);
         System.out.println("city name is : " + city);
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

}
