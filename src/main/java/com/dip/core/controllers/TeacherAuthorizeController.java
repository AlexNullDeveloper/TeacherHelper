package com.dip.core.controllers;

import com.dip.core.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherAuthorizeController {

    @Autowired
    TeachersService teachersService;

    @RequestMapping(value="/teacher_authtorize", method = {RequestMethod.POST, RequestMethod.GET})
    public String authtorizeTeachers(@RequestParam(value = "teacher_params") String[] parameterValues) {
        if (parameterValues != null) {
            for (int i = 0; i < parameterValues.length; i++) {
                String[] strings = parameterValues[i].split(" ");
                String phone = strings[3];
                teachersService.setTeacherAgreed(phone);
            }
        }

        return "adminka";
    }

    @RequestMapping(value = "/teacherDecline", method = RequestMethod.POST)
    public void declineTeachers() {

    }
}