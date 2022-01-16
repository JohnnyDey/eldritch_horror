package com.jd.eldritch.model.investigators;

import lombok.Getter;

@Getter
public abstract class Investigator {
    protected int health;
    protected int sanity;
    protected int lore;
    protected int influence;
    protected int observation;
    protected int strength;
    protected int will;
}
