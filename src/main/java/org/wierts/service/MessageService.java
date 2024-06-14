package org.wierts.service;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.wierts.dto.Message;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class MessageService {

    public void sendEmail(Message message) throws Exception {
        LocalDateTime time = LocalDateTime.now();
        File file = new File(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmssSSSSSS"))+".txt");
        FileUtils.writeStringToFile(file, message.getEmail()+" "+message.getMessage());
    }


}
