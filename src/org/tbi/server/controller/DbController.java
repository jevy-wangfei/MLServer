

package org.tbi.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tbi.server.entity.ErrorCode;
import org.tbi.server.entity.User;
import org.tbi.server.entity.UserInfor;
import org.tbi.server.service.UserService;

@RestController
@RequestMapping("/users")
public class DbController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/signin")
	@ResponseBody
	public UserInfor getUser(@RequestParam("name")String name, @RequestParam("password")String password){
		System.out.println("befor try");
		try{
			System.out.println("in try line1");
			final User user = userService.getUser(name.trim());
			System.out.println("in try line2");
			final UserInfor result = new UserInfor(user);
			System.out.println("in try line3");
			if(result.getPassWord().equals(password)){
				System.out.println("in if line1");
				return result;
			}
		}catch(Exception e){
			System.out.println("in catch line1");
			 return new UserInfor("Not found this user, please try again.", ErrorCode.PERSIST_ERROR);
		}
		System.out.println("after catch line1");
		return new UserInfor("Not found this user, please try again.", ErrorCode.PERSIST_ERROR);
	}
	
	
	
	@RequestMapping("/addition")
	public void addUser(){
		User user = new User();
		user.setName("linda");
		user.setPassWord("123");
		userService.addUser(user);
	}
	
	@RequestMapping("/deletion")
	public void deletedUser(){
		String name = "Danyang";
		userService.deleteUser(name);
	}
	
	@RequestMapping("/modification")
	public void modifyUser(){
		User user = new User();
		user.setStatus("Modified");
		userService.modifyUser(user);		
	}
	
	@RequestMapping("/query")
	public List<User> queryUser(){
		String name = "linda";
		return userService.queryUser(name);
	}

}
