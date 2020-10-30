package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Friend;
import com.cg.repository.IFriendRepository;

@Service
public class FriendService implements IFriendService {
	
	@Autowired
	private IFriendRepository repo;

	public void add(Friend frnd) {
		repo.save(frnd);
	}

	public Friend get(int frid) {
		return repo.fetch(frid);
	}

	public List<Friend> getAll() {
		return repo.fetchAll();
	}

}
