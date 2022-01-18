package com.jd.eldritch.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class GameMap {
    private Map<String, Location> locations = new HashMap<>();

    public GameMap() {
        initLocations();
    }

    public void putToken(Token token, String locationCode){
        Location location = locations.get(locationCode);
        if (location == null) {
            throw new IllegalArgumentException("No location with code " + locationCode);
        }
        location.getTokens().add(token);
    }

    private void initLocations() {
        addLocation(new Location("1", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("2", Location.Type.SEA, "Northeast of Hawaii, USA"));
        addLocation(new Location("3", Location.Type.SEA, "Oceanic Pole of Inaccessibility"));
        addLocation(new Location("4", Location.Type.WILDERNESS, "Ft. Providence, Canada"));
        addLocation(new Location("5", Location.Type.CITY, "Sioux Falls, SD/Minneapolis, MN"));
        addLocation(new Location("6", Location.Type.CITY, "Houston, Texas, USA"));
        addLocation(new Location("7", Location.Type.CITY, "Panama"));
        addLocation(new Location("8", Location.Type.SEA, "Bermuda Triangle"));
        addLocation(new Location("9", Location.Type.WILDERNESS, "Disko Island, Greenland"));
        addLocation(new Location("10", Location.Type.WILDERNESS, "Dakar, Senegal"));
        addLocation(new Location("11", Location.Type.SEA, "Inaccessible Island"));
        addLocation(new Location("12", Location.Type.SEA, "South Sandwich Islands"));
        addLocation(new Location("13", Location.Type.SEA, "North of Franz-Josef Land"));
        addLocation(new Location("14", Location.Type.CITY, "Helsinki, Finland"));
        addLocation(new Location("15", Location.Type.CITY, "Cape Town, South Africa"));
        addLocation(new Location("16", Location.Type.CITY, "Krasnoyarsk, Russia"));
        addLocation(new Location("17", Location.Type.CITY, "Bombay (Mumbai), India"));
        addLocation(new Location("18", Location.Type.SEA, "Port-aux-Francais, French"));
        addLocation(new Location("19", Location.Type.WILDERNESS, "Beringovsky, Russia"));
        addLocation(new Location("20", Location.Type.CITY, "Makassar, Indonesia"));
        addLocation(new Location("21", Location.Type.WILDERNESS, "Uluru, Northern Territories, Australia"));
        addLocation(new Location("AM", "The Amazon", Location.Type.WILDERNESS,  ""));
        addLocation(new Location("PY", "The Pyramids", Location.Type.WILDERNESS, ""));
        addLocation(new Location("HA", "The Heart of Africa", Location.Type.WILDERNESS, ""));
        addLocation(new Location("HM", "The Himalayas", Location.Type.WILDERNESS, ""));
        addLocation(new Location("TG", "Tunguska", Location.Type.WILDERNESS, ""));
        addLocation(new Location("AN", "Antarctica", Location.Type.SEA, ""));
        addLocation(new Location("SF", "San Francisco", Location.Type.CITY, "Improve Observation"));
        addLocation(new Location("AR", "Arkham", Location.Type.CITY, "Gain Incantation Spells"));
        addLocation(new Location("BA", "Buenos Aires", Location.Type.CITY, "Gain Ritual Spells"));
        addLocation(new Location("LN", "London", Location.Type.CITY, "Spawn Clue Tokens"));
        addLocation(new Location("RM", "Rome", Location.Type.CITY, "Improve Will"));
        addLocation(new Location("IS", "Istanbul", Location.Type.CITY, "Improve Influence"));
        addLocation(new Location("TK", "Tokyo", Location.Type.CITY, "Defeat Monsters"));
        addLocation(new Location("SH", "Shanghai", Location.Type.CITY, "Improve Lore"));
        addLocation(new Location("SY", "Sydney", Location.Type.CITY, "Improve Strength"));
    }

    private void addLocation(Location location){
        locations.put(location.getCode(), location);
    }
}
