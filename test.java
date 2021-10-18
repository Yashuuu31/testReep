import java.sql.*;

class InsertMysql{
    public static void main(String args[]){
        try{
            Connection cn;
            Statement st;
            ResultSet rs;

            class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hns_mysql", "root", "");

            System.out.println("Connection Done.");

            st = cn.createStatement(ReseltSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATE);

            Int i = st.executeUpdate("insert into student value (1, 'Yash Chauhan', 'Rajkot')");

            if(i > 0){
                System.out.println('Data Inserted Successfully');
            }

            rs = st.exexuteQuery("select * from student");

            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
            
            cn.close();
            rs.close();

        } catch(Exception e){
            System.out.println("Error :- " + e);
        }
    }
}