/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

/**
 *
 * @author mohit
 */
public class servletconnection extends HttpServlet {
      Connection cn;
    Statement st;
    ResultSet rs;
    public void init()
    {
            try
            {
               Class.forName("com.mysql.jdbc.Driver");
               cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hns","root","");
               System.out.println("Connection done");
            }
            catch(Exception e)
            {
                 System.out.println("Connection fail");
            }
    }

  
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
       
      res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html><body>");
        try
        {           String q="select * from stud";
                    st=cn.createStatement();
                  //(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    rs=st.executeQuery(q);
                    out.println("<table border='1' bordercolor='red'>");
                    rs.next();
                    do
                    {
                        out.println("<tr>");
                        out.println("<td>"+rs.getString(1));
                        out.println("<td>"+rs.getString(2));
                        out.println("<td>"+rs.getString(3));
                    }while(rs.next());
                    cn.close();
        }
       catch(Exception e)
       {

       }
    }



}


    
