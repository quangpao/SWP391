/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import DAO.CommentDAO;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author quangpao
 */
public class Post {
    
    private int postID;
    private char postType;
    private String content;
    private Date time;
    private int permission;
//    foreign key
    private int clubID;
    private int userID;
    private ArrayList<Comment> postComments;
    
    
    private CommentDAO DAO = new CommentDAO();
    public Post() {
    }

    public Post(int postID, char postType, String content, Date time, int permission, int clubID, int userID) {
        this.postID = postID;
        this.postType = postType;
        this.content = content;
        this.time = time;
        this.permission = permission;
        this.clubID = clubID;
        this.userID = userID;
    }
    
    //Set method
    public void setPostID(int postID) {
        this.postID = postID;
    }


    public void setPostType(char postType) {
        this.postType = postType;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    //Get method

    public int getPostID() {
        return postID;
    }

    public char getPostType() {
        return postType;
    }

    public String getContent() {
        return content;
    }

    public int getPermission() {
        return permission;
    }

    public Date getTime() {
        return time;
    }

    public int getClubID() {
        return clubID;
    }

    public int getUserID() {
        return userID;
    }
    
    public void setComment(ArrayList<Comment> comments) {
        this.postComments = comments;
    }
    
    public ArrayList<Comment> getComment() {
        return this.postComments;
    }
    
    public ArrayList<String> timeParse() {
        
        ArrayList<String> list = new ArrayList<>();
        
        DateFormat dateFormat = new SimpleDateFormat("MMM dd");  
        
        String strDate = dateFormat.format(time);
        
        StringTokenizer stkn = new StringTokenizer(strDate);
        
        while (stkn.hasMoreTokens())
            list.add(stkn.nextToken());
        
        return list;
    }
    
//    private void fetchComments() {
//        
//        ArrayList<Comment> list = DAO.getPostComments(postID);
//        
//        this.postComments = list;
//        
//    }
//    
//    public ArrayList<Comment> getAllComments() {
//        
//        fetchComments();
//        
//        return this.postComments;
//    }
//    
//    public ArrayList<Comment> deleteComment(int i) {
//        
//    }
    
}
