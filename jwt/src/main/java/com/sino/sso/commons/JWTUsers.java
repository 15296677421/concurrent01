package com.sino.sso.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * 用来模拟用户数据的.
 */
public class JWTUsers {
    private static final Map<String, String> USERS = new HashMap<String, String>(16);
    
    static {
    	for(int i = 0; i < 10; i++) {
    		USERS.put("admin" + i, "password" + i);
    	}
    }
    
    public static boolean isLogin(String username, String password) {
    	if(null == username || username.trim().length() ==0) {
    		return false;
    	}
    	String obj = USERS.get(username);
    	if(null == obj || !obj.equals(password)) {
    		return false;
    	}
    	return true;
    }
}
