package com.ghost.games.numberhero.activity;

import android.test.AndroidTestCase;
import android.util.Log;

import com.ghost.games.numberhero.dao.UserDAO;
import com.ghost.games.numberhero.model.User;

public class UserDAOTest extends AndroidTestCase {
	private final static String TAG = "UserDAOTest";

	public void testFind() {
		UserDAO userDAO = new UserDAO(this.getContext());
		User user = userDAO.find(1);
		if (null == user) {
			Log.i(TAG, "not find");
		} else {
			Log.i(TAG, "" + user.getName());
		}
	}

}
