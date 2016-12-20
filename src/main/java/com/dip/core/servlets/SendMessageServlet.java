package com.dip.core.servlets;

import com.dip.core.mail.MailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Юрий on 30.10.2016.
 */
@WebServlet("/sendMessage")
public class SendMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageHeader = req.getParameter("messageHeader");
        String messageBody = req.getParameter("messageBody");
        System.out.println(messageHeader + " " + messageBody);

        MailSender.sendRealEmail(messageHeader, messageBody);

        resp.sendRedirect("/html/sendmessege.html");
    }
}
