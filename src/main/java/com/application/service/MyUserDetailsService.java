package com.application.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.application.model.Form;
import com.application.model.User;
import com.application.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.info("Inside loadUserByUsername method..");
		Optional<User> user = userRepository.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + username));
		return user.map(MyUserDetails::new).get();
	}

	public User saveUserDetails(Form form) {
		// TODO Auto-generated method stub
		User user = new User();
		if (form != null) {
			try {
				log.info("Inside saveUserDetails method..");
				user.setRoles("ROLE_USER");
				user.setActive(true);
				user.setUserName(form.getFirstName().toLowerCase());
				user.setPassword(form.getFirstName().toLowerCase() + "@123#");
				userRepository.save(user);
			} catch (Exception e) {
				log.error("Exception occured in saveUserDetails method", e);
			}
		}
		return user;
	}

	@Transactional
	public void deleteUser(int id) {
		try {
			log.info("Inside deleteUser method..");
			userRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Exception occured in deleteUser method", e);
		}
	}
}
