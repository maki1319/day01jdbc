package jdbc;


import java.sql.*;
//解耦的思路 尽量使用反射，不使用new
public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
       // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");//降低耦合程度
     Connection connection=  DriverManager.getConnection("jdbc:mysql://localhost:3306/testsb","root","maki");
       PreparedStatement preparedStatement=connection.prepareStatement("select * from account");
        ResultSet rs=preparedStatement.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("name"));

        }
        rs.close();
        preparedStatement.close();
        connection.close();


    }
}
