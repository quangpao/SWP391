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
import entity.Comment;
import entity.Post;

/**
 *
 * @author quangpao
 */
public class PostDAO implements PostDAOInterface{

    ConnectDB db = ConnectDB.getInstance();
    

    public ArrayList<Comment> getCommentByPost(int postID) {
        Connection con;
        PreparedStatement statement;
        ResultSet rs;
        ArrayList<Comment> list = new ArrayList<>();
        try {
            con = db.openConnection();
            String sql = "SELECT * FROM [COMMENTS] WHERE postID=" + postID + " order by commentID";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int commentID = Integer.parseInt(rs.getString(1).trim());
                int userID = Integer.parseInt(rs.getString(2).trim());
                Date time = rs.getDate(4);
                String content = rs.getString(5);
                list.add(new Comment(commentID, userID, postID, time, content));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
        
    }

    @Override
    public ArrayList<Post> getPost() {
        Connection con;
        PreparedStatement statement;
        ResultSet rs;
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
                Post newPost = new Post(postID, postType, content, time, permission, clubID, userID);
                newPost.setComment(getCommentByPost(postID));
                list.add(newPost);
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void addPost(Post post) {
        Connection con;
        PreparedStatement statement;
//        ResultSet rs;
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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean deletePost(int postID) {
        Connection con;
        PreparedStatement statement;
//        ResultSet rs;
        try {
            con = db.openConnection();
            String sql = "DELETE FROM [POSTS] WHERE postID = ?";
            statement = con.prepareStatement(sql);
            statement.setInt(1, postID);
            statement.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void updatePost(Post post) {
        Connection con;
        PreparedStatement statement;
//        ResultSet rs = null;
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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Post> getClubPosts(int clubID) {
        Connection con;
        PreparedStatement statement;
        ResultSet rs;
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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Post getPostByID(int postID) {
        Connection con;
        PreparedStatement statement;
        ResultSet rs;
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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
}
