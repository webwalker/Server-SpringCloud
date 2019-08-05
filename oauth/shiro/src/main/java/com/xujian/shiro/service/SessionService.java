package com.xujian.shiro.service;

import com.xujian.shiro.pojo.UserOnline;

import java.util.List;

public interface SessionService {
	
	List<UserOnline> list();
	boolean forceLogout(String sessionId);
}
