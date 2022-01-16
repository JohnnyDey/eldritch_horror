package com.jd.eldritch;

import com.jd.eldritch.model.Game;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component("singleton")
public class CacheStorage {
    private Map<String, Game> games = new HashMap<>();

    public synchronized String createGame() {
        Game game = new Game();
        String id = game.getId();
        games.put(id, game);
        return id;
    }

    public synchronized Set<String> getGameList() {
        return games.keySet();
    }

    public synchronized Game getGame(String id) {
        return games.get(id);
    }
}
