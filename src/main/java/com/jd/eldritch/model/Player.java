package com.jd.eldritch.model;

import com.jd.eldritch.model.decks.Card;
import com.jd.eldritch.model.investigators.Investigator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Investigator investigator;
    private List<Card> hand = new ArrayList<>();
    //stats
    private int health;
    private int sanity;
    //skills
    private int lore;
    private int influence;
    private int observation;
    private int strength;
    private int will;

    public Player(Investigator investigator) {
        this.investigator = investigator;
        this.health = investigator.getHealth();
        this.sanity = investigator.getSanity();
        this.lore = investigator.getLore();
        this.influence = investigator.getInfluence();
        this.observation = investigator.getObservation();
        this.strength = investigator.getStrength();
        this.will = investigator.getWill();
    }


}
