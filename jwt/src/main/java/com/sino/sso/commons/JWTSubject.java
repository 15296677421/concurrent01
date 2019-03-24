package com.sino.sso.commons;
/**
 * 作为Subject数据使用。也就是payload中的public claims.
 * 其中不包含任何敏感数据。
 * 开发中建议使用实体类。或BO，DTO对象。
 */
public class JWTSubject {
    private String username;
    public JWTSubject() {
    	
    }
    
    public JWTSubject(String username) {
    	this.username = username;
    }
    
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
    
}
