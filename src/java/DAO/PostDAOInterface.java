/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;

import entity.Post;

/**
 *
 * @author quangpao
 */
public interface PostDAOInterface {
    
    ArrayList<Post> getPost();
    void addPost(Post post);
    boolean deletePost(int postID);
    void updatePost(Post post);

}
