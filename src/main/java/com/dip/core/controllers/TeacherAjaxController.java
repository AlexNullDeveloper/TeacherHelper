package com.dip.core.controllers;

import com.dip.core.service.GroupsService;
import com.dip.core.service.StudentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@EnableWebMvc
public class TeacherAjaxController {

    @Autowired
    StudentService studentService;

    @Autowired
    GroupsService groupsService;

    @RequestMapping(value = "/returnGroups", headers = "Accept=*/*", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void returnGroups(@RequestParam(value = "name") String nameOfFaculty, HttpServletResponse response) {
        List<String> listOfGroupsByFacName = groupsService.getListOfGroupsByFacName(nameOfFaculty);
        responseInJson(response, listOfGroupsByFacName);
    }

    @RequestMapping(value = "/returnStudents", headers = "Accept=*/*", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void returnStudents(@RequestParam(value = "name") String nameOfGroup, HttpServletResponse response) {
        List<String> listOfStudentsByGroup = studentService.getStudentListByName(nameOfGroup);
        responseInJson(response, listOfStudentsByGroup);

        System.out.println("returnStudents done");
    }

    private void responseInJson(HttpServletResponse response, List<String> listOfGroupsByFacName) {
        response.setHeader("Content-Type", "application/json ; charset=utf-8");

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(listOfGroupsByFacName);
        System.out.println("--------json----------");
        System.out.println(json);

        try {
            byte[] utf8s = json.getBytes("UTF8");
            response.getOutputStream().write(utf8s, 0, utf8s.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
