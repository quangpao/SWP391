/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.ConnectDB;
import entity.Meeting;

/**
 *
 * @author quangpao
 */
public class MeetingDAO implements MeetingDAOInterface {
    
    ConnectDB db = ConnectDB.getInstance();
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    public ArrayList<Meeting> getMeeting() {
        ArrayList<Meeting> list = new ArrayList<>();
        try {
            con = db.openConnection();
            String sql = "SELECT * FROM [MEETINGS] order by postID";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int postID = Integer.parseInt(rs.getString(1).trim());
                String location = rs.getString(2).trim();
                Date time = rs.getDate(3);
                list.add(new Meeting(postID, location, time));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addMeeting(Meeting meeting) {
        try {
            con = db.openConnection();
            String sql = "INSERT INTO [MEETINGS] VALUES(?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setInt(1, meeting.getPostID());
            statement.setString(2, meeting.getLocation());
            statement.setDate(3, meeting.getTime());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            statement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean deleteMeeting(int postID) {
        try {
            con = db.openConnection();
            String sql = "DELETE FROM [MEETINGS] WHERE postID = ?";
            statement = con.prepareStatement(sql);
            statement.setInt(1, postID);
            statement.executeUpdate();
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MeetingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MeetingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updateMeeting(Meeting meeting) {
        try {
            con = db.openConnection();
            String sql = "UPDATE [MEETINGS] SET location = ?, time = ? WHERE postID = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, meeting.getLocation());
            statement.setDate(2, meeting.getTime());
            statement.setInt(3, meeting.getPostID());
            statement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MeetingDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MeetingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MeetingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
