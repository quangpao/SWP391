/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import entity.User;

/**
 *
 * @author kin
 */
public interface UserDAOInterface {
    ArrayList<User> getUser();
    void addUser(User user);
    boolean deleteUser(int userID);
    void updateUser(User user);
}
