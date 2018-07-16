package com.smartbiz.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smartbiz.model.User;
import com.smartbiz.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	private final Logger logger = Logger.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	UserService userService;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findByUserName(userName);
		if (user ==  null) {
			throw new UsernameNotFoundException("Username not found");
		}

		logger.debug("User Group: "+user.getUserGroup());
		return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), 
                 true, true, true, true, getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       //authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        logger.debug("Authorizing user as: "+user.getUserGroup().getGroupName());
        authorities.add(new SimpleGrantedAuthority(user.getUserGroup().getGroupName()));
       /* for(UserProfile userProfile : user.getUserProfiles()){
            //logger.info("UserProfile : {}", userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }*/
        //logger.info("authorities : {}", authorities);
        return authorities;
    }

}
