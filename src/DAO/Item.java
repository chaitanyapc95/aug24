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
 * @author 1894438
 */
public class Item {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection con = null;
            PreparedStatement stm = null;
            String sql;
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw" );
            sql = "insert into item values (?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, "LL");
            stm.setString(2, "CEO");
            stm.setInt(3, 12);
            
            
            int rs = stm.executeUpdate();
            
            
                System.out.println(rs);
                stm.close();
                con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }
}
    