package com.jd.eldritch.socket;

import com.jd.eldritch.model.InputMessage;
import com.jd.eldritch.model.OutputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
public class SocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private static final List<String> rooms = List.of("1", "2", "13");

    @MessageMapping("/room/{roomId}")
    public void handleGameMessage(Principal principal, InputMessage msg, @DestinationVariable String roomId) {
        try {
            if (!rooms.contains(roomId)) {
                throw new IllegalArgumentException("Нет такой команты");
            }
            messagingTemplate.convertAndSendToUser(principal.getName(),
                    "/room/null/subscriber",
                    new OutputMessage("Че ты стучишь в комнату " + roomId + "?))))"));
        } catch (Exception e) {
            log.error("Exception handled", e);
            messagingTemplate.convertAndSendToUser(principal.getName(),
                    "/room/null/subscriber",
                    e.getMessage());
        }
    }

    @MessageMapping("/common/{type}")
    public void createGame(Principal principal, @DestinationVariable String type) {
        if ("room_list".equals(type)) {
            messagingTemplate.convertAndSendToUser(principal.getName(),
                    "/common",
                    rooms);
        } else {
            messagingTemplate.convertAndSendToUser(principal.getName(),
                    "/common",
                    "UnknownType");
        }
    }

}