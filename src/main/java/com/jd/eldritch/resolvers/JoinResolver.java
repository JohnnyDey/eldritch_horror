package com.jd.eldritch.resolvers;


import com.jd.eldritch.model.Player;
import com.jd.eldritch.model.investigators.Andy;
import org.springframework.stereotype.Component;

@Component("JOIN")
public class JoinResolver extends AbstractResolver{

    @Override
    protected void invoke() {
        doWithLock(() -> {
            game.getPlayers().add(new Player(new Andy(), inputMessage.getSenderUid()));
        });
    }
}
