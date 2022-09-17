/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author sonsi
 */ 
public class ClubDAO {
    
    public static void createClub(String name,String content) throws Exception {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = db.openConnection();
            String sql = "insert into clubs values (?,?,?,?,?,?) ";
            statement = con.prepareStatement(sql);
            statement.setString(2, name);
            statement.setString(3, content);
            statement.setInt(5, 0);
            statement.execute();
            statement.close();
            con.close();
        } catch (Exception e) {
            return;
        }
    }
}
