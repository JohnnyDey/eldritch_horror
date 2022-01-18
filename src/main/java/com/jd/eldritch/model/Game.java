package com.jd.eldritch.model;

import com.jd.eldritch.model.decks.Deck;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Game extends Identified {
    private GameStatus status = GameStatus.READY;
    private List<Player> players = new ArrayList<>();
    private GameMap map = new GameMap();
    private Map<String, Deck> decks = new HashMap<>();
    private GameLock lock;

}
