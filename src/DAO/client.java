/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author temp
 */
public class client {
   // @SuppressWarnings("null")
    public static void main(String[] args){
        
    
        try {
            Connection con;
            PreparedStatement stm= null;
            String sql;
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE","sales","anypw");
            stm=Insert(con);
           stm=Delete(con);
           stm=Update(con);
           stm=List(con);
           stm=Singlelist(con);
            stm.close();
            con.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}

    private static PreparedStatement Singlelist(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="select noclient,clientname from client where notelephone=?";
        stm=con.prepareStatement(sql);
        stm.setString(1, "0000000");
        int rs=stm.executeUpdate();
        System.out.println(rs);
        return stm;
    }

    private static PreparedStatement List(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="select * from  client";
        stm=con.prepareStatement(sql);
        int rs=stm.executeUpdate();
        System.out.println(rs);
        return stm;
    }

    private static PreparedStatement Update(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="update client set clientname=? where notelephone=?";
        stm=con.prepareStatement(sql);
        stm.setString(1, "Akhil");
        stm.setString(2, "0000000");
        int rs=stm.executeUpdate();
        System.out.println(rs);
        return stm;
    }

    private static PreparedStatement Delete(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="delete from client where nameclient=?";
        stm=con.prepareStatement(sql);
        stm.setString(1,"Lin Bo");
        int rs=stm.executeUpdate();
        System.out.println(rs);
        return stm;
    }

    private static PreparedStatement Insert(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql="insert into client values(?,?,?)";
        stm=con.prepareStatement(sql);
        stm.setInt(1,12);
        stm.setString(2,"akhil");
        stm.setString(3, "888888888");
        int rs=stm.executeUpdate();
        System.out.println(rs);
        // sql="delete from client where noclient=?";
        return stm;
    }

   
}
