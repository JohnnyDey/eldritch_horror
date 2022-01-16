package com.jd.eldritch.socket;

import com.jd.eldritch.CacheStorage;
import com.jd.eldritch.socket.message.common.CommonInputMessage;
import com.jd.eldritch.socket.message.common.CommonOutputMessage;
import com.jd.eldritch.socket.message.game.InputMessage;
import com.jd.eldritch.socket.message.game.OutputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Slf4j
@Controller
public class SocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private CacheStorage storage;

    @MessageMapping("/room/{roomId}")
    public void handleGameMessage(Principal principal, InputMessage msg, @DestinationVariable String roomId) {
        try {
            if (!storage.getGameList().contains(roomId)) {
                throw new IllegalArgumentException("Нет такой команты");
            }
            messagingTemplate.convertAndSendToUser(principal.getName(),
                    "/room/null/subscriber",
                    new OutputMessage("Че ты стучишь в комнату " + roomId + "?))))"));
        } catch (Exception e) {
            log.error("Exception handled", e);
            messagingTemplate.convertAndSendToUser(principal.getName(),
                    "/room/null",
                    e.getMessage());
        }
    }

    @MessageMapping("/common")
    public void createGame(Principal principal, CommonInputMessage msg) {
        CommonOutputMessage outputMessage = new CommonOutputMessage();
        outputMessage.setType(msg.getType());
        if ("room_list".equals(msg.getType())) {
            outputMessage.setValues(storage.getGameList().toArray(new String[0]));
        }
        if ("create_room".equals(msg.getType())) {
            outputMessage.setResult(storage.createGame());
        } else {
            outputMessage.setResult("UnknownMsgType");
        }
        messagingTemplate.convertAndSendToUser(principal.getName(),
                "/common",
                outputMessage);
    }

}