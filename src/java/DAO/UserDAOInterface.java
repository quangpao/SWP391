/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.User;

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
