package com.cg.oas.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.Login;
import com.cg.oas.entities.University;
import com.cg.oas.entities.UserTable;
@Repository
public interface IUserRepository extends JpaRepository<UserTable,Integer>
{

	Login save(Login login);
//    public User addUserDetails(User user);
//    public Login addLoginDetails(Login login);
//    public ArrayList<User> getAllUserDetails();
//   // public ArrayList<Login> getAllLoginDetails();
//    public User getUserDetailsById(String userId);
//    public Login getLoginDetailsById(String userId);
//    public Login deleteUserDetailsById(String userId);
//    public Login deleteLoginDetailsById(String userId);
//    public Login changePassword(Login login );
//    public Login resetPassword(Login login );
//    public User updateUserDetails(User user);
//    //add more function if require as per requirnment

    
}
