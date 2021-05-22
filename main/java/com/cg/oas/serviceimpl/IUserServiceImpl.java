package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.Login;
import com.cg.oas.entities.UserTable;
import com.cg.oas.exception.UserNotFoundException;
import com.cg.oas.repository.ILoginRepository;
import com.cg.oas.repository.IUserRepository;
import com.cg.oas.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService {
	@Autowired
	IUserRepository iUserRepo;
	@Autowired
	ILoginRepository iLoginRepo;

	@Override
	public UserTable addUserDetails(UserTable user) {
		// TODO Auto-generated method stub
		return iUserRepo.save(user) ;
	}

	@Override
	public Login addLoginDetails(Login login) {
		// TODO Auto-generated method stub
		return iLoginRepo.save(login);
	}

	@Override
		public List<UserTable> getAllUserDetails() throws UserNotFoundException{
			// TODO Auto-generated method stub
			List<UserTable> list=iUserRepo.findAll();
			if(list.isEmpty()) {
				throw new UserNotFoundException("No User Found");
			}
			else
			return iUserRepo.findAll();
	}

	@Override
		public UserTable getUserDetailsById(int userId) throws UserNotFoundException {
			
			Optional<UserTable> optional = iUserRepo.findById(userId);
			if(optional.isPresent()) {
				return optional.get();	
			}
			else
				throw new UserNotFoundException("No User Found");
	}

	@Override
	public Login getLoginDetailsById(int loginId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login> optional = iLoginRepo.findById(loginId);
		if(optional.isPresent()) {
			return optional.get();	
		}
		else
			throw new UserNotFoundException("No User Found");
	}

	@Override
		public List<UserTable> deleteUserDetailsById(int userId) throws UserNotFoundException{
			
			Optional<UserTable> optional = iUserRepo.findById(userId);
			if(optional.isPresent()) {
				iUserRepo.deleteById(userId);
			return iUserRepo.findAll();
			}
			else
				throw new UserNotFoundException("No User Found");
	}

	@Override
	public List<Login> deleteLoginDetailsById(int loginId) throws UserNotFoundException{
		Optional<Login> optional = iLoginRepo.findById(loginId);
		if(optional.isPresent()) {
			iLoginRepo.deleteById(loginId);
		return iLoginRepo.findAll();
		}
		else
			throw new UserNotFoundException("No User Found");
		}
	@Override
		public UserTable updateUserDetails(UserTable user) throws UserNotFoundException {

			Optional<UserTable> optional = iUserRepo.findById(user.getUserId());
			if(optional.isPresent()) {
				iUserRepo.save(user);
			return user;
			}
			else
				throw new UserNotFoundException("No User Found");
	}

	@Override
		public Login resetPassword(Login login) throws UserNotFoundException {

			Optional<Login> optional = iLoginRepo.findById(login.getLoginId());
			if(optional.isPresent()) {
				iLoginRepo.save(login);
			return login;
			}
			else
				throw new UserNotFoundException("No User Found");
	}

	@Override
		public List<Login> getAllLoginDetails() throws UserNotFoundException{
			// TODO Auto-generated method stub
			List<Login> list=iLoginRepo.findAll();
			if(list.isEmpty()) {
				throw new UserNotFoundException("No User Found");
			}
			else
			return iLoginRepo.findAll();
	}
	}

