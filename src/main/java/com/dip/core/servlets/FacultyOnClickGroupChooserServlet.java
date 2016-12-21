package com.dip.core.servlets;

import com.dip.core.pojos.ResponseModel;
import com.dip.core.service.GroupsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Юрий on 30.10.2016.
 */
//@WebServlet("/returnGroups")
@Deprecated
public class FacultyOnClickGroupChooserServlet extends HttpServlet {
    private static final String _URL = "../jsps/teacher2page.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameOfFaculty = req.getParameter("name");
        System.out.println(nameOfFaculty);
        List<String> listOfGroupsByFacName = new GroupsService().getListOfGroupsByFacName(nameOfFaculty);

        req.setAttribute("listOfGroups", listOfGroupsByFacName);
        req.setAttribute("selectedFaculty", nameOfFaculty);
        //req.setAttribute("redirect",;
        ResponseModel responseModel = new ResponseModel(listOfGroupsByFacName, _URL, nameOfFaculty);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(responseModel);

        resp.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
