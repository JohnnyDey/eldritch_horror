package com.jd.eldritch.model.investigators;

import lombok.Getter;

@Getter
public abstract class Investigator {
    protected final String name;
    protected final int health;
    protected final int sanity;
    protected final int lore;
    protected final int influence;
    protected final int observation;
    protected final int strength;
    protected final int will;

    protected Investigator(String name, int health, int sanity, int lore, int influence, int observation, int strength, int will) {
        this.name = name;
        this.health = health;
        this.sanity = sanity;
        this.lore = lore;
        this.influence = influence;
        this.observation = observation;
        this.strength = strength;
        this.will = will;
    }
}
