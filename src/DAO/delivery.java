/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author temp
 */
public class delivery {
    
    public static void main(String[] args){
        
        try {
            Connection con;
            PreparedStatement stm;
            String sql;
            DriverManager.deregisterDriver(new oracle.jdbc.OracleDriver());
            con=DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE","sales","anypw");
            sql="insert into delivery values(?,to_date(?,'YY/MM/DD')";
            stm=con.prepareStatement(sql);
            stm.setInt(1,10);
            stm.setString(2,"2000/04/08");
            int rs=stm.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
