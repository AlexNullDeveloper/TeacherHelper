package com.dip.core.mail;

import com.dip.core.database.JdbcHelper;
import com.dip.core.service.StudentService;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by a.talismanov on 07.07.2016.
 */
public class MailSender {

    private static final String SELECT_EMAIL_BY_FIO_SQL = "SELECT E_MAIL FROM STUDENTS WHERE STUDENT_FIO = ?";
    private static final String STUDENTS_GROUP = "ГРУППА 1";
    private static final String EMAIL_LOGIN = "login@yandex.ru";
    private static final String EMAIL_PASSWORD = "password";

    public static void sendRealEmail(String header, String body) {

        Properties props = getProperties();
        Session session = getSession(EMAIL_LOGIN, EMAIL_PASSWORD, props);

        try {
            for (String fio : new StudentService().getStudentListByName(STUDENTS_GROUP)) {
                Connection connection = JdbcHelper.getConnection();
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMAIL_BY_FIO_SQL);
                    preparedStatement.setString(1, fio);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String email = resultSet.getString(1);
                        sendMessageToEmail(session, email, body, header);
                    }
                } catch (SQLException SQLe) {
                    System.out.println(SQLe.getMessage());
                }
            }
            System.out.println("done sending");
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void sendMessageToEmail(Session session, String emailTo, String text, String header) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        setMessage(message, emailTo, header);
        String textOfMessage = text; //getMessageString();
        String encodedText = null;
        try {
            encodedText = new String (textOfMessage.getBytes("UTF-8"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        message.setText(encodedText, "UTF-8");

        Transport.send(message);
    }

    private static Session getSession(final String loginx, final String passwordx, Properties props) {
        return Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(loginx, passwordx);
                    }
                });
    }

    private static void setMessage(MimeMessage message, String emailTo, String header) throws MessagingException {
        //TODO отправку с адреса заменить на основной
        message.setFrom(new InternetAddress(EMAIL_LOGIN));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(emailTo));

        String newHeader = null;
        try {
            newHeader = new String (header.getBytes("UTF-8"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        message.setSubject(newHeader, "UTF-8");
    }

    static Properties getProperties() {
        Properties props = new Properties();
        String smtphost = getSmtpHostByMail();

        props.put("mail.smtp.host", smtphost);
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");//465
        return props;
    }

    private static String getSmtpHostByMail() {


        int index = EMAIL_LOGIN.indexOf("@");

        return "smtp." + EMAIL_LOGIN.substring(index + 1);
    }
}
