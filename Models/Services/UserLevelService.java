package com.nicoz.NZWanderlust.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nicoz.NZWanderlust.Entity.Buyer;
import com.nicoz.NZWanderlust.Entity.UserLevel;
import com.nicoz.NZWanderlust.Repository.UserLevelRepository;
import com.nicoz.NZWanderlust.Repository.BuyerRepository;

@Service
public class UserLevelService {

	@Autowired
	private UserLevelRepository userLevelRepository;
	
	@Transactional
	public UserLevel newUserLevel(Integer userID) {
		UserLevel newUserLevel = new UserLevel();
		newUserLevel.setLevelName("Beginner");	
		newUserLevel.setNumberOfTickets(0);
		newUserLevel.setProfit(0.0);
		newUserLevel.setUserID(userID);	
		
		return userLevelRepository.save(newUserLevel);
	}

    @Transactional
    public void deleteUserLevel(Integer id) {
    	UserLevel userLevel = searchUserLevel(id);
    	userLevelRepository.delete(userLevel);
    }   
	
	@Transactional(readOnly = true)
	public UserLevel searchUserLevel(Integer id) {
		return userLevelRepository.findById(id).get();
	}
	
	@Transactional
	public UserLevel updateUserLevel(UserLevel userLevel)  {
		UserLevel userLevelToUpdate = searchUserLevel(userLevel.getUserLevelID());
		userLevelToUpdate.setLevelName(userLevel.getLevelName());	
		userLevelToUpdate.setNumberOfTickets(userLevel.getNumberOfTickets());
		userLevelToUpdate.setProfit(userLevel.getProfit());
		
		return userLevelRepository.save(userLevelToUpdate);

	}
}
