package com.cg.repository;

import java.util.List;

import com.cg.entity.Friend;

public interface IFriendRepository {

	void save(Friend frnd);
	
	Friend fetch(int frid);
	
	List<Friend> fetchAll();
}
