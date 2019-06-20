/**
 * 
 */
package com.alvaroscheid.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.alvaroscheid.model.User;
import com.alvaroscheid.repository.UserRepository;

/**
 * @author alvaro-scheid
 *
 */

@Controller
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/login")
	public String login(@Valid User user, BindingResult result, Model model) {
		for (User userInDatabase : userRepository.findAll()) 
			if (userInDatabase.getUsername().equals(user.getUsername())) 
				if(userInDatabase.getPassword().equals(encryptPassword(user.getPassword())))
					return "success";
		return "invalid";
	}

	@GetMapping("/")
	public String base(User user) {
		return "index";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) throws NoSuchAlgorithmException {
		if (result.hasErrors()) {
			return "add-user";
		}
		user.setPassword(encryptPassword(user.getPassword()));
		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	private String encryptPassword(String passwordToHash) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] messageDigest = md.digest(passwordToHash.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
