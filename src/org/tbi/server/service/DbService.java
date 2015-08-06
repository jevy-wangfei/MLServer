/**
 *@author Danyang Li 
 */

package org.tbi.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tbi.server.dao.Dao;
import org.tbi.server.entity.User;

@Service
public class DbService {
	
	@Autowired
	private Dao dao;
	
	public void addUser(User user){
		dao.save(user);		
	}

	public void deleteUser(String name){
		List<User> users = dao.findByName(name);
		dao.delete(users);	
	}
	
	public void modifyUser(User user){
		List<User> users = dao.findByName(user.getId());
		for(User u : users){
			u.setName(user.getName());
		}
		dao.save(users);
	}
	
	public List<User> queryUser(String name){
		List<User> users = dao.findByName(name);
		return users;
	}
}
