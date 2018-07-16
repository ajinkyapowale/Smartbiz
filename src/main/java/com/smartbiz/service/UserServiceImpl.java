package com.smartbiz.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartbiz.model.User;
import com.smartbiz.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	@Transactional (readOnly=true)
	public User findByUserName(String userName) {
		User user = null;
		try {
			user = userRepo.findByEmailId(userName);
			if (user!=null)
				user.setUserGroup(user.getUserGroup());
			logger.debug("####### "+user);
		}catch(Exception ex) {
			logger.error(ex.getStackTrace());
		}
		return user;
	}

}
