package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Friend;
import com.cg.service.IFriendService;

@RestController
public class FriendRestController {
	
	@Autowired
	private IFriendService service;
	
	// URL: http://localhost:8080/spring-mvc-jpa/nayadost
	@PostMapping(value="/nayadost", consumes = "application/json")
	public String addFriend(@RequestBody Friend frnd) {
		service.add(frnd);
		return "Friend added successfully.";
	}
	
	// URL: http://localhost:8080/spring-mvc-jpa/find?id=121
	@GetMapping(value = "/find", produces = "application/json")
	public Friend findFriend(@RequestParam("id") int id) {
		Friend friend = service.get(id);
		return friend;
	}
	
	// URL: http://localhost:8080/spring-mvc-jpa/list
	@GetMapping(value = "/list", produces = "application/json")
	public List<Friend> friendList() {
		List<Friend> friends = service.getAll();
		return friends;
	}
}
