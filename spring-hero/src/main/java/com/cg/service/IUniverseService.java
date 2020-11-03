package com.cg.service;

import com.cg.entity.Universe;
import com.cg.exception.UniverseNotFoundException;

public interface IUniverseService {

	void add(Universe universe);
	
	Universe get(int uid) throws UniverseNotFoundException;

	Universe get(String uname) throws UniverseNotFoundException;
}
