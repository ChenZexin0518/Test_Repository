package com.demo;

import java.sql.*;

public class Demo_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,username,password);
            if(!conn.isClosed())
            System.out.println("数据库连接成功！");
            Statement Statement=conn.createStatement();
            String sql="select * from Student" ;
            ResultSet rs=Statement.executeQuery(sql);
             System.out.println("-------------------------------");
             System.out.println("执行结果如下所示:");  
             System.out.println("-------------------------------");  
             System.out.println("姓名" + "\t" + "年龄");  
             System.out.println("-------------------------------");  
             String name=null;
             int age=0;
             while(rs.next()){
                 name=rs.getString("Name");
                 age=rs.getInt("Age");
                System.out.println(name+"\t"+age);
             }
             rs.close();
             conn.close();
         }
         catch(ClassNotFoundException e){
        System.out.println("数据库驱动加载失败！");
        e.printStackTrace();
         }
        catch(SQLException e1){
         e1.printStackTrace();
        }
        catch(Exception e2){
        e2.printStackTrace();
        }
        finally{
             System.out.println("-------------------------------");  
            System.out.println("数据库数据获取成功！");
        }

	}

}
