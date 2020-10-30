package com.cg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.cg.entity.Friend;

@Repository
public class FriendRepository implements IFriendRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public void save(Friend frnd) {
		em.persist(frnd);
	}

	public Friend fetch(int frid) {
		Friend f = em.find(Friend.class, frid);
		return f;
	}

	public List<Friend> fetchAll() {
		return em.createQuery("from Friend").getResultList();
	}

}
