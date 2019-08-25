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
            stm = insert(con);
            stm = delete(con);
            stm = update(con);
            stm = list(con);
            stm = select(con);
            
                stm.close();
                con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }

    private static PreparedStatement select(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql = "select NOITEM from Items where STOCKQUANTITY = ?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, 5);
        ResultSet rs = stm.executeQuery();
        System.out.println(rs);
        return stm;
    }

    private static PreparedStatement list(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql = "select * from ITEMS";
        stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        System.out.println(rs);
        return stm;
    }

    private static PreparedStatement update(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql = "update ITEM set STOCKQUANTITY =? where DESCRIPTION =?";
        stm = con.prepareStatement(sql);
        stm.setInt(1, 11);
        stm.setString(2, "SAPIN");
        int rs = stm.executeUpdate();
        System.out.println(rs);
        return stm;
    }

    private static PreparedStatement delete(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql = "delete from ITEM where DESCRIPTION = ?";
        stm = con.prepareStatement(sql);
        stm.setString(1,"sapin");
        int rs = stm.executeUpdate();
        System.out.println(rs);
        return stm;
    }

    private static PreparedStatement insert(Connection con) throws SQLException {
        String sql;
        PreparedStatement stm;
        sql = "insert into ITEM values (?,?,?)";
        stm = con.prepareStatement(sql);
        stm.setString(1, "LL");
        stm.setString(2, "CEO");
        stm.setInt(3, 12);
        int rs = stm.executeUpdate();
        System.out.println(rs);
        return stm;
    }
}
    