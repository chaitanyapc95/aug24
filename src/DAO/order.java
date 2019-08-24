/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static com.sun.javafx.print.Units.MM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.HTML.Tag.DD;

/**
 *
 * @author temp
 */
public class order { 
    public static void main (String[] args ){
        try {
            Connection con=null ;
            PreparedStatement stm=null;
            String sql;
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); 
            con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales" ,"anypw");
//            stm=insert(con); 
           
            
              
        } catch (SQLException ex) {
            Logger.getLogger(order.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}

    private static void insert(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="insert into item values(?,?,?)";
        stm=con.prepareStatement(sql);
        stm.setInt(1, 11 );
        stm.setInt(3,90);
       
        int rs = stm.executeUpdate();
        System.out.println(rs);
//        return stm;
    }
    
    private static void delete(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="delete from orders where norder=?";
        stm=con.prepareStatement(sql);
        stm.setInt(1, 11);
        int rs = stm.executeUpdate();
        System.out.println(rs);
//        return stm;
    }
    
    private static void update(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="update orders set noorder=? where noclient=?";
        stm=con.prepareStatement(sql);
        stm.setInt(1, 12 );
        stm.setInt(2,90 );
        int rs = stm.executeUpdate();
        System.out.println(rs);
//        return stm;
    }
    
    private static void List(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="select * from orders";
        stm=con.prepareStatement(sql);
        ResultSet rs= stm.executeQuery();
        System.out.println(rs);
//    return stm;
    }
    
    private static void Single(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm = null;
        sql="select noorder from orders where noclient=?";
        ResultSet rs=stm.executeQuery();
        System.out.println(rs);
        
        
        con.close();
        stm.close();
    }
    
}
