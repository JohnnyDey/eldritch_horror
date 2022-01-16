package com.jd.eldritch.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Location {
    private String code;
    private String name;
    private Type type;
    private List<Location> connections = new ArrayList<>();
    private String note;
    private List<Token> tokens = new ArrayList<>();

    public Location(String code, String name, Type type, String note) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.note = note;
    }

    public Location(String code, Type type, String note) {
        this.code = code;
        this.name = "Space " + code;
        this.type = type;
        this.note = note;
    }
    public enum Type {
        CITY,
        SEA,
        WILDERNESS
    }
}
