package org.wierts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wierts.dto.Message;
import org.wierts.service.MessageService;

@RestController
public class MailController {

    private MessageService messageService;
    @PostMapping ("/send")
    public Message sendEmail(@RequestParam(value = "message") Message message) {
        messageService.sendEmail(message);
        return message;
    }
}
