package org.craftedsw.harddependencies.user;

import org.craftedsw.harddependencies.exception.DependendClassCallDuringUnitTestException;

public class UserSession {

	private static final UserSession userSession = new UserSession();
	
	private UserSession() {
	}
	
	public static UserSession getInstance() {
		return userSession;
	}

	public User getLoggedUser() {
		throw new DependendClassCallDuringUnitTestException(
				"UserSession.getLoggedUser() should not be called in an unit test");
	}

}
