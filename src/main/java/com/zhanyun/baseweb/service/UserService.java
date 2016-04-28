package com.zhanyun.baseweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhanyun.baseweb.entity.User;
import com.zhanyun.baseweb.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		List<User> userLst = userRepository.getUserByName(name);
		if (userLst == null || userLst.get(0) == null)
			throw new UsernameNotFoundException("The user with name " + name + " was not found");
		
		return userLst.get(0);
	}

}
