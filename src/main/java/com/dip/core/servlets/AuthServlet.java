package com.dip.core.servlets;

import com.dip.core.service.UsersService;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Юрий on 29.10.2016.
 */
//@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private static final String ADMIN_PAJE = "jsps/adminka.jsp";
    public static final String TEACHER_PAGE = "jsps/teacher.jsp";
    private static final String ERROR_PAGE = "jsps/errorlogin.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpassword = req.getParameter("password");

        UsersService usersService = new UsersService();
        boolean isPasswordCorrect = usersService.checkPasswordCorrectness(username, userpassword);

        if (isPasswordCorrect) {

            boolean isAdmin = usersService.isAdmin(username);

            if (isAdmin) {
                resp.sendRedirect(ADMIN_PAJE);
            } else {
                resp.sendRedirect(TEACHER_PAGE);
            }
        } else {
            resp.sendRedirect(ERROR_PAGE);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
