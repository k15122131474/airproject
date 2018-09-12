package com.sfa.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class DbUtiles {
	public static Map<String, HttpSession> mapSession = new HashMap<String,HttpSession>();
	public static void userLogout(String username){
		if(mapSession.get(username)!=null){
			//得到需要退出的用户的session
			HttpSession session = mapSession.get(username);
			//在map<username,session>中移除该用户，记住想要退出该用户，必须将该session废除或是remove掉user
			mapSession.remove(username);
			//得到session的所属性合集
			Enumeration e = session.getAttributeNames();
			//删除所有属性
			while(e.hasMoreElements()){
				String sessionName = (String) e.nextElement();
				session.removeAttribute(sessionName);
			}
			//废除该session
			session.invalidate();
		}
	}
	
	/**
	 * 检查是否已经含有此session
	 * @param username
	 * @return true:已经存在，该删！  false：未存在
	 */
	public static boolean cheackSession(String username){
		HttpSession session = mapSession.get(username);
		if(session!=null){
			return true;
		}
		return false;
	}
}
