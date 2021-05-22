package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.Login;
import com.cg.oas.entities.UserTable;

public interface IUserService
{
    public UserTable addUserDetails(UserTable user);
    public Login addLoginDetails(Login login);
    public List<UserTable> getAllUserDetails();
    public List<Login> getAllLoginDetails();
    public UserTable getUserDetailsById(int userId);
    public Login getLoginDetailsById(int loginId);
    public List<UserTable> deleteUserDetailsById(int userId);
    public List<Login> deleteLoginDetailsById(int loginId);
    //public Login changePassword(Login login );
    public Login resetPassword(Login login);
    public UserTable updateUserDetails(UserTable user);
    //add more function if require as per requirnment

    
}
