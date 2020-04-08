package com.mine.db;

import java.sql.*;
import org.postgresql.Driver;
import java.util.*;
import java.text.SimpleDateFormat;
import com.mine.model.*;

public class ConDb {
    private static Connection connection;
    // 传递sql语句
    private static Statement statement;
    // 结果集
    private static ResultSet resultSet;

    public static Connection getDb()
    {
       
        try{
            String url="jdbc:postgresql://127.0.0.1:5432/exampledb";
            String user="yangliang";
            String password = "123456";
            Class.forName("org.postgresql.Driver").newInstance();
            connection= DriverManager.getConnection(url, user, password);
            //System.out.println("是否成功连接pg数据库"+connection);
            // String sql="select count(1) from brch_qry_dtl";
            // statement=connection.createStatement();
            // ResultSet resultSet=statement.executeQuery(sql);
            // while(resultSet.next()){
            //     String name=resultSet.getString(1);
            //     System.out.println(name);
            //  }
            return connection;
        }catch(Exception e){
            System.out.println("error1");
            //throw new RuntimeException(e);
            return null;
        }
       
    }
    public static void insertDb(List<List<String>> data)
     {
        try{
        Connection connection = getDb();
        String sql = "";      
        statement = connection.createStatement();
        System.out.println("是否成功连接pg数据库"+connection);
        //List<List<String>> data = ReadCsv.readCSV("/home/yangliang/data.csv",false);//获取csv文件的list集合
        for (List<String> m : data)
        {
            sql = "INSERT INTO brch_qry_dtl (tran_date , timestampl , acc , amt , dr_cr_flag , rpt_sum) VALUES (cast('%s' as date),'%s', '%s', cast(%s as numeric), cast(%s as integer), '%s')";
            sql = String.format(sql,m.get(0),m.get(1),m.get(2),m.get(3),m.get(4),m.get(5));
            statement.executeUpdate(sql);
            sql = "";
        }
        }catch(Exception e) {
            e.printStackTrace();
        } finally {

            // 释放资源
            try {
            
                connection.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        }      
         
      
     public static List<BrchQryDtl> selectDb_1()
     {
         try{
        Connection connection = getDb();
        String sql = "";
        BrchQryDtl brch = null;      
        statement = connection.createStatement();
        System.out.println("是否成功连接pg数据库"+connection);
        resultSet=statement.executeQuery("select * from brch_qry_dtl");
        List<BrchQryDtl> brchs = new ArrayList<BrchQryDtl>();
        while(resultSet.next()){
            brch = new BrchQryDtl();
            brch.setTranDate(resultSet.getString("tran_date"));
            brch.setTimestampl(resultSet.getString("timestampl"));
            brchs.add(brch);
            }
        
         //return brchs;
        
        return   brchs;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {

            // 释放资源
            try {
            
                connection.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
     }
      
}