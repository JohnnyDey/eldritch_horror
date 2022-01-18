package com.jd.eldritch.model;

import com.jd.eldritch.model.decks.Card;
import com.jd.eldritch.model.investigators.Investigator;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player extends Identified {
    private final String uid;
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

    public Player(Investigator investigator, String uid) {
        super();
        this.investigator = investigator;
        this.health = investigator.getHealth();
        this.sanity = investigator.getSanity();
        this.lore = investigator.getLore();
        this.influence = investigator.getInfluence();
        this.observation = investigator.getObservation();
        this.strength = investigator.getStrength();
        this.will = investigator.getWill();
        this.uid = uid;
    }


}
