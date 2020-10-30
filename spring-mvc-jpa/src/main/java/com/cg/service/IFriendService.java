package com.cg.service;

import java.util.List;

import com.cg.entity.Friend;

public interface IFriendService {

	void add(Friend frnd);
	
	Friend get(int frid);
	
	List<Friend> getAll();
}
