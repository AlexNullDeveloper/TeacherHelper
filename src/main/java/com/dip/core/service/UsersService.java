package com.dip.core.service;

import com.dip.core.dao.UsersDao;

public class UsersService {
    private static final UsersDao userDao = new UsersDao();
    private static final int ADMIN_ROLE = 1;

    public boolean isAdmin(String login) {
        int userRoleByLogin = userDao.getUserRoleByLogin(login);
        if (userRoleByLogin == ADMIN_ROLE) {
            return true;
        }
        return false;
    }

    public boolean checkPasswordCorrectness(String user, String password) {
        String dbPassword = userDao.getPasswordByLogin(user);
        if (dbPassword.equals(password)) {
            return true;
        }
        return false;
    }
}
