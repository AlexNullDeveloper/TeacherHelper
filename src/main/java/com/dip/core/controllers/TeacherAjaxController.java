package com.dip.core.controllers;

import com.dip.core.pojos.ResponseModel;
import com.dip.core.service.GroupsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Юрий on 21.12.2016.
 */
@Controller
public class TeacherAjaxController {
    private static final String _URL = "../jsps/teacher2page.jsp";


    @RequestMapping(value = "/returnGroups", method = RequestMethod.POST)
    public void returnGroups (@RequestParam(value = "name") String nameOfFaculty, Model model) {
        System.out.println(nameOfFaculty);
        List<String> listOfGroupsByFacName = new GroupsService().getListOfGroupsByFacName(nameOfFaculty);

        model.addAttribute("listOfGroups", listOfGroupsByFacName);
        model.addAttribute("selectedFaculty", nameOfFaculty);

        //забыл зачем это
        ResponseModel responseModel = new ResponseModel(listOfGroupsByFacName, _URL, nameOfFaculty);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(responseModel);

        model.addAttribute("json", json);
    }
}
