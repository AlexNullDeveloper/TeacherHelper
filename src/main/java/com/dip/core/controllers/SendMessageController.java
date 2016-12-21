package com.dip.core.controllers;

import com.dip.core.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Юрий on 21.12.2016.
 */
@Controller
public class SendMessageController {

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public String sendEmail(@RequestParam("messageHeader") String messageHeader, @RequestParam("messageBody") String messageBody) {
        System.out.println(messageHeader + " " + messageBody);

        MailSender.sendRealEmail(messageHeader, messageBody);

        return "sendmessage";
    }

}
