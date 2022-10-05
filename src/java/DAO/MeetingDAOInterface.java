/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;

import entity.Meeting;

/**
 *
 * @author quangpao
 */
public interface MeetingDAOInterface {
    
    ArrayList<Meeting> getMeeting();
    void addMeeting(Meeting meeting);
    boolean deleteMeeting(int postID);
    void updateMeeting(Meeting meeting);
    

}
