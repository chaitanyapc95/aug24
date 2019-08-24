/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1896052
 */
public class detaildelivery {
    
      public static void main(String[] args) {
    
          try {
              Connection con=null;
              
              PreparedStatement stm=null;
              
              String sql = null;
              
              DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
              
              con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE","sales","anypw");
              
              
              
            getInsert(con, sql);
            getDelete(con, sql);
              
          } catch (SQLException ex) {
              Logger.getLogger(detaildelivery.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
      }

    public static void getInsert(Connection con, String sql) throws SQLException {
        PreparedStatement stm;
        sql="insert into detaildelivery values(?,?,?,?)";
        stm=con.prepareStatement(sql);
        stm.setInt(1, 105);
        stm.setInt(2, 1);
        stm.setInt(3, 10);
        stm.setInt(4, 2);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        //                con.commit();
      
    }
    
    public static void getDelete(Connection con, String sql) throws SQLException {
        PreparedStatement stm;
        sql="delete from detaildelivery where nodelivery=?";
        stm=con.prepareStatement(sql);
        stm.setInt(1, 105);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        
         
    }
    
    public static void getUpdate(Connection con, String sql) throws SQLException {
        PreparedStatement stm;
        sql="update detaildelivery set nedlivery=? where noitem=?";
        stm=con.prepareStatement(sql);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        
    }
    
    public static void getList(Connection con, String sql) throws SQLException {
        
        PreparedStatement stm;
        sql="select * from detaildelivery";
        stm=con.prepareStatement(sql);
        ResultSet rs=stm.executeQuery();
        System.out.println(rs);
    }
    
    public static void getSingle(Connection con, String sql) throws SQLException {
        
        PreparedStatement stm = null;
        sql="select nodelivery,noorder,noitem from detaildelivery where quantitydelivery=?";
        stm.setInt(1, 2);
        stm=con.prepareStatement(sql);
        ResultSet rs=stm.executeQuery();
        System.out.println(rs);
        con.close();
        stm.close();
        
    }
}    
    
    
    
    
    

