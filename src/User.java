/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seif
 */
public interface User {

 
    void ChangePassword(String username,String userOldPassword, String userNewPassword);
    void logout();
}
