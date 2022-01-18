package com.jd.eldritch.resolvers;

import com.jd.eldritch.model.Game;
import com.jd.eldritch.model.Player;
import com.jd.eldritch.socket.message.game.InputMessage;
import com.jd.eldritch.socket.message.game.OutputMessage;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;

@Log
public abstract class AbstractResolver {
    protected InputMessage inputMessage;
    protected OutputMessage outputMessage;
    protected Game game;

    @Autowired
    protected SimpMessagingTemplate messagingTemplate;

    public final OutputMessage resolve(InputMessage inputMessage, Game game) {
        this.inputMessage = inputMessage;
        this.game = game;
        invoke();
        sendMessageToPlayers();
        return outputMessage;
    }

    protected abstract void invoke();

    public static String getDestination(String gameId) {
        return "/room/" + gameId;
    }

    protected void sendMessageToPlayers() {
        List<Player> players = game.getPlayers();
        String destination = getDestination(game.getId());
        players.forEach((player) -> sendMessage(player.getUid(), destination));
    }

    private void sendMessage(String receiveUid, String destination) {
        if (outputMessage != null) {
            messagingTemplate.convertAndSendToUser(receiveUid, destination, outputMessage);
        }
    }

    protected void doWithLock(Runnable runnable) {
        game.getLock().lock(inputMessage.getSenderUid());
        try {
            runnable.run();
        } finally {
            game.getLock().unlock(inputMessage.getSenderUid());
        }
    }


}
