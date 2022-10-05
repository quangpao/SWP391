/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.ConnectDB;
import entity.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonsi
 */
public class MemberDAO {

    public static void addMember(Member member) throws Exception {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        java.sql.Date sqlDate = new java.sql.Date(member.getDayJoined().getTime());
        try {
            con = db.openConnection();
            String sql = "insert into member values (?,?,?,?,?,?) ";
            statement = con.prepareStatement(sql);
            statement.setInt(1, member.getMemberID());
            statement.setInt(2, member.getUserID());
            statement.setInt(3, member.getRole());
            statement.setInt(4, member.getPoint());
            statement.setDate(5, sqlDate);
            statement.setInt(6, member.getMembership());
            con.close();
        } catch (Exception e) {
            return;
        }
    }

    public static void delete(Member member) throws Exception {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
//        java.sql.Date sqlDate = new java.sql.Date(club.getDatedCreated().getTime());
        try {
            con = db.openConnection();
            String sql = "delete member where memberID = ? ";
            statement = con.prepareStatement(sql);
            statement.setInt(1, member.getMemberID());
            con.close();
        } catch (Exception e) {
            return;
        }
    }
    
    public static List<Member> getAllClubs() throws Exception {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = null;
        List<Member> members = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
//        String check = null;
        try {
            con = db.openConnection();
            String sql = "SELECT * FROM MEMBERS";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                java.util.Date  date = new java.util.Date(rs.getDate(5).getTime());
                members.add(new Member(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),date,rs.getInt(6)));
            }
            rs.close();
            statement.close();
            con.close();

        } catch (Exception e) {
            return null;
        }
        return members;
    }
}
