/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Database.ConnectDB;
import entity.Post;

/**
 *
 * @author quangpao
 */
public class PostDAO implements PostDAOInterface{

    ConnectDB db = ConnectDB.getInstance();
    Connection con = null;
    PreparedStatement statement = null;
    ResultSet rs = null;


    @Override
    public ArrayList<Post> getPost() {
        ArrayList<Post> list = new ArrayList<>();
        try {
            con = db.openConnection();
            String sql = "SELECT * FROM [POSTS] order by postID";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int postID = Integer.parseInt(rs.getString(1).trim());
                char postType = rs.getString(2).charAt(0);
                String content = rs.getString(3).trim();
                int clubID = rs.getInt(4);
                int userID = rs.getInt(5);
                Date time = rs.getDate(6);
                int permission = rs.getInt(7);
                list.add(new Post(postID, postType, content, time, permission, clubID, userID));
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void addPost(Post post) {
        try {
            con = db.openConnection();
            String sql = "INSERT INTO [POSTS] VALUES(?,?,?,?,?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setInt(1, post.getPostID());
            statement.setString(2, String.valueOf(post.getPostType()));
            statement.setString(3, post.getContent());
            statement.setInt(4, post.getClubID());
            statement.setInt(5, post.getUserID());
            statement.setDate(6, post.getTime());
            statement.setInt(7, post.getPermission());
            statement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean deletePost(int postID) {
        try {
            con = db.openConnection();
            String sql = "DELETE FROM [POSTS] WHERE postID = ?";
            statement = con.prepareStatement(sql);
            statement.setInt(1, postID);
            statement.executeUpdate();
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updatePost(Post post) {
        try {
            con = db.openConnection();
            String sql = "UPDATE [POSTS] SET postType = ?, content = ?, clubID = ?, userID = ?, time = ?, permission = ? WHERE postID = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, String.valueOf(post.getPostType()));
            statement.setString(2, post.getContent());
            statement.setInt(3, post.getClubID());
            statement.setInt(4, post.getUserID());
            statement.setDate(5, post.getTime());
            statement.setInt(6, post.getPermission());
            statement.setInt(7, post.getPostID());
            statement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Post> getClubPosts(int clubID) {
        ArrayList<Post> list = new ArrayList<>();
        try {
            con = db.openConnection();
            String sql = "SELECT * FROM [POSTS] WHERE clubID = " + clubID + " order by postID";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int postID = Integer.parseInt(rs.getString(1).trim());
                char postType = rs.getString(2).charAt(0);
                String content = rs.getString(3).trim();
                // int clubID = rs.getInt(4);
                int userID = rs.getInt(5);
                Date time = rs.getDate(6);
                int permission = rs.getInt(7);
                list.add(new Post(postID, postType, content, time, permission, clubID, userID));
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Post getPostByID(int postID) {
        try {
            con = db.openConnection();
            String sql = "SELECT * FROM [POSTS] WHERE postID = " + postID;
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                // int postID = Integer.parseInt(rs.getString(1).trim());
                char postType = rs.getString(2).charAt(0);
                String content = rs.getString(3).trim();
                int clubID = rs.getInt(4);
                int userID = rs.getInt(5);
                Date time = rs.getDate(6);
                int permission = rs.getInt(7);
                return new Post(postID, postType, content, time, permission, clubID, userID);
                
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rs.close();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
