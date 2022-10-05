/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.servlet;

import DAO.PostDAO;
import entity.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "PostServlet", urlPatterns = {"/PostServlet"})
public class PostServlet extends HttpServlet {
    
    //Cái này sẽ hơi bị conflict do chưa làm xong phần Club.
    //Khả năng test hết = 0 nên đừng mong gì nhiều
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Khi truy cap vao 1 club, thi se set cai session clubID thanh ID cua club do de thuan tien cho viec truy xuat sau nay.
        int clubID = Integer.parseInt((String) request.getSession().getAttribute("clubID"));
         
        PostDAO postDAO = new PostDAO();
        
        List<Post> listPost = postDAO.getClubPosts(clubID);
        
        request.getSession().setAttribute("posts", listPost);
        
        //Tro den path cua thang blog.html
        request.getRequestDispatcher("blog.jsp").forward(request, response);
    }

    //Dung de handle may cai request o trang post, co the la search nhung chua implement voi
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
