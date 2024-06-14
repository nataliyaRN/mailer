package org.wierts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.wierts.dto.Message;
import org.wierts.service.MessageService;

@RestController
public class MailController {
    @Autowired
    private MessageService messageService;
    @PostMapping ("/send")
    public Message sendEmail(@RequestBody Message message) throws Exception{
        messageService.sendEmail(message);
        return message;
    }
}
