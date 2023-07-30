package de.penguinpiz;

import org.bukkit.Location;

public class LocationUnit {

    public static void saveLocation(Location location, String name) {

        if (exists(name)) return;

        AbstractConfig.get().set("Location." + name.toUpperCase(), location);
        AbstractConfig.save();
    }


    public static Location get(String name, boolean block) {
        if (!exists(name.toUpperCase())) throw new NullPointerException("Can't find location in Config");


        Location loc = AbstractConfig.get().getLocation("Location." + name.toUpperCase());
        return (block) ? loc.toBlockLocation() : loc;
    }

    public static boolean exists(String name) {
        return AbstractConfig.get().isLocation(name.toUpperCase());
    }

}
