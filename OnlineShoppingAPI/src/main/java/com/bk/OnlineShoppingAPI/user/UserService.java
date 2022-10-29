package com.bk.OnlineShoppingAPI.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public void addUser(User user) {
		userRepo.save(user);
		return;
	}
	
	public void addAllUser(List<User> users) {
		userRepo.saveAll(users);
		return;
	}
	
	public List<User> getAllUser() throws UserNotFoundException
	{
		
		List<User> listOfUser = userRepo.findAll();
		if(listOfUser.isEmpty())
			throw new UserNotFoundException("There is No User at All");
		return listOfUser;			
	}
	
	public User getUserById(Long id) throws UserNotFoundException
	{
		User user = userRepo.findByUserId(id);
		if(user == null)
			throw new UserNotFoundException("User with given Id is Not Found");
		return user;		
	}

	public void updateUserDetails(Long id, User user) throws UserNotFoundException {
		User existingUser = userRepo.findByUserId(id);
		if(existingUser == null)
		{
			throw new UserNotFoundException("User with given Id is Not Found");
		}
		if(user.getUserName()!=null)
		existingUser.setUserName(user.getUserName());
		if(user.getEmailId()!=null)
		existingUser.setEmailId(user.getEmailId());
		if(user.getContactNo()!=null)
		existingUser.setContactNo(user.getContactNo());
		if(user.getAddress()!=null)
		existingUser.setAddress(user.getAddress());
		if(user.getPincode()!=null)
		existingUser.setPincode(user.getPincode());
		userRepo.save(existingUser);
	}
	
	public void removeUserById(Long id)
	{
		userRepo.deleteById(id);
	}
	
	public void removeAllUser()
	{
		userRepo.deleteAll();
	}
}
