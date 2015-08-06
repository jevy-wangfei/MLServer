/**
 * @author Danyang Li
 */

package org.tbi.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tbi.server.entity.User;
import org.tbi.server.service.DbService;

@RestController
@RequestMapping("/users")
public class DbController {
	
	@Autowired
	private DbService dbService;
	
	@RequestMapping("/addition")
	public void addUser(){
		User user = new User();
		user.setName("Hello World!");
		dbService.addUser(user);
	}
	
	@RequestMapping("/deletion")
	public void deletedUser(){
		String name = "Hello World!";
		dbService.deleteUser(name);
	}
	
	@RequestMapping("/modification")
	public void modifyUser(){
		User user = new User();
		user.setComment("Modified");
		dbService.modifyUser(user);		
	}
	
	@RequestMapping("/query")
	public List<User> queryUser(){
		String name = "Hello World!";
		return dbService.queryUser(name);
	}

}
