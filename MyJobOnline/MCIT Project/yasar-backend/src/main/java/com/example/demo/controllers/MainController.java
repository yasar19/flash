package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.repositories.ICreateUserRepo;
import com.example.models.Profile;
import com.example.models.User;
import com.onlineResume.app.models.Users;


@RestController
public class MainController {

	@Autowired
	private ICreateUserRepo iCreateUserRepo;

	@RequestMapping(method=RequestMethod.POST, value="/registration")
	public String createUser(@RequestBody User user) {
		iCreateUserRepo.save(user);
		return "success";
	}

	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String login(@RequestBody User user) {
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		if(demoUser!=null) {
			if(iCreateUserRepo.findByEmail(user.getEmail()).getEmail().equals(user.getEmail())) {
				return demoUser.getEmail();
			}
		}else {
			return "";
		}

		return "";
	}

	@RequestMapping(method=RequestMethod.GET, value="/profile")
	public User profile(@RequestParam String email) {
		System.out.println(email);
		return iCreateUserRepo.findByEmail(email);
	}

	@RequestMapping(method=RequestMethod.POST, value="/name")
	public void name(@RequestBody User user ) {
//		System.out.println(user.getEmail());
//		System.out.println(user.getName());
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		demoUser.setName(user.getName());
		iCreateUserRepo.save(demoUser);
	}
	@RequestMapping(method=RequestMethod.POST, value="/email")
	public void email(@RequestBody User user ) {
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		demoUser.setEmail(user.getEmail());
		iCreateUserRepo.save(demoUser);

	}
	@RequestMapping(method=RequestMethod.POST, value="/position")
	public void position(@RequestBody User user) {
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		demoUser.setPosition(user.getPosition());
		iCreateUserRepo.save(demoUser);

	}
	@RequestMapping(method=RequestMethod.POST, value="/location")
	public void location(@RequestBody User user) {
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		demoUser.setLocation(user.getLocation());
		iCreateUserRepo.save(demoUser);

	}
	@RequestMapping(method=RequestMethod.POST, value="/education")
	public void education(@RequestBody User user ) {
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		demoUser.setEducation(user.getEducation());
		iCreateUserRepo.save(demoUser);
	}
	@RequestMapping(method=RequestMethod.POST, value="/experience")
	public void experience(@RequestBody User user ) {
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		demoUser.setExperience(user.getExperience());
		iCreateUserRepo.save(demoUser);

	}
	@RequestMapping(method=RequestMethod.POST, value="/aboutMe")
	public void aboutMe(@RequestBody User user ) {
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		demoUser.setAboutMe(user.getAboutMe());
		iCreateUserRepo.save(demoUser);

	}
	@RequestMapping(method=RequestMethod.POST, value="/skill")
	public void skill(@RequestBody User user ) {
		User demoUser=iCreateUserRepo.findByEmail(user.getEmail());
		demoUser.setSkill(user.getSkill());
		iCreateUserRepo.save(demoUser);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
			}
		};
	}

}
