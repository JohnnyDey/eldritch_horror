package com.jd.eldritch.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class GameMap {
    private Map<String, Location> locations = new HashMap<>();

    private void initLocations() {
        addLocation(new Location("1", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("2", Location.Type.SEA, "Northeast of Hawaii, USA"));
        addLocation(new Location("3", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("4", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("5", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("6", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("7", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("8", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("9", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("10", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("11", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("12", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("13", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("14", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("15", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("16", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("17", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("18", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("19", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("20", Location.Type.CITY, "Anchorage, Alaska, USA"));
        addLocation(new Location("21", Location.Type.CITY, "Anchorage, Alaska, USA"));


    }

    private void addLocation(Location location){
        locations.put(location.getCode(), location);
    }
}
