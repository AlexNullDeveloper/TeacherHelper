package com.dip.core.servlets;

import com.dip.core.service.TeachersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Юрий on 30.10.2016.
 */
@WebServlet("/teacherAgree")
public class TeacherAgreeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String[] parameterValues = req.getParameterValues("teacher_params");
        if (parameterValues != null) {
            for (int i = 0; i < parameterValues.length; i++) {
                String[] strings = parameterValues[i].split(" ");
                String phone = strings[3];
                new TeachersService().setTeacherAgreed(phone);
            }
        }

        resp.sendRedirect("jsps/adminka.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
