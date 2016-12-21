package com.dip.core.controllers;

import com.dip.core.service.TeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Юрий on 21.12.2016.
 */
@Controller
public class TeacherAuthorizeController {

    @RequestMapping(value="/teacher_authtorize", method = {RequestMethod.POST, RequestMethod.GET})
    public String authtorizeTeachers(@RequestParam(value = "teacher_params") String[] parameterValues) {
        if (parameterValues != null) {
            for (int i = 0; i < parameterValues.length; i++) {
                String[] strings = parameterValues[i].split(" ");
                String phone = strings[3];
                new TeachersService().setTeacherAgreed(phone);
            }
        }

        return "adminka";
    }

    @RequestMapping(value = "/teacherDecline", method = RequestMethod.POST)
    public void declineTeachers() {

    }

}