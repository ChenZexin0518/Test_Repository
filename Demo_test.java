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
            System.out.println("���ݿ����ӳɹ���");
            Statement Statement=conn.createStatement();
            String sql="select * from Student" ;
            ResultSet rs=Statement.executeQuery(sql);
             System.out.println("-------------------------------");
             System.out.println("ִ�н��������ʾ:");  
             System.out.println("-------------------------------");  
             System.out.println("����" + "\t" + "����");  
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
        System.out.println("���ݿ���������ʧ�ܣ�");
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
            System.out.println("���ݿ����ݻ�ȡ�ɹ���");
        }

	}

}
