package com.springcoketexample.Controller;

import com.springcoketexample.Model.MessageModel;
import com.springcoketexample.Storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessegeControllar {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public  void sendMessege(@DestinationVariable String to, MessageModel message){
        System.out.println("Handling Messege "+message+" To-: "+ to);
        boolean isExists= UserStorage.getInstance().getUsers().contains(to);
        if(isExists){
            simpMessagingTemplate.convertAndSend("/topic/messages/"+to,message);
        }
    }
}
