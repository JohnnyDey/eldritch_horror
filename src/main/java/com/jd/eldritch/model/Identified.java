package com.jd.eldritch.model;


import lombok.Getter;

import java.util.UUID;

@Getter
public class Identified {
    protected final String id;

    public Identified() {
        id = UUID.randomUUID().toString();
    }
}
