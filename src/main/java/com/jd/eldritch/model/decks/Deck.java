package com.jd.eldritch.model.decks;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Deck {
    private List<Card> cards = new ArrayList<>();
}
