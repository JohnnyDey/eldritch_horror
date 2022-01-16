package com.jd.eldritch.model;

import com.jd.eldritch.model.decks.Deck;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Game {
    private final String id;
    private GameStatus status = GameStatus.READY;
    private List<Player> players = new ArrayList<>();
    private GameMap map = new GameMap();
    private Map<String, Deck> decks = new HashMap<>();

    public Game() {
        id = UUID.randomUUID().toString();
    }
}
