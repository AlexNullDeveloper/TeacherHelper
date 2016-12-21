package com.dip.core.controllers;

import com.dip.core.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Юрий on 20.12.2016.
 */
@Controller
public class AuthController {

    //TODO сделать
//    @Autowired
//    private UsersService usersService;
//
//    public void setUsersService(UsersService usersService) {
//        this.usersService = usersService;
//    }

    @RequestMapping(value = "/auth", method = {RequestMethod.GET, RequestMethod.POST})
    public String perform(@RequestParam("username") String username, @RequestParam("password") String password) {

        UsersService usersService = new UsersService();
        boolean isPasswordCorrect = usersService.checkPasswordCorrectness(username, password);

        if (isPasswordCorrect) {

            boolean isAdmin = usersService.isAdmin(username);

            if (isAdmin) {
                return "adminka";
            } else {
                return "teacher";
            }
        } else {
            return "errorlogin";
        }
    }

}
