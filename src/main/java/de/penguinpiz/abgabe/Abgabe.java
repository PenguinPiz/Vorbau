package de.penguinpiz.abgabe;

import de.penguinpiz.AbstractConfig;

import java.util.ArrayList;
import java.util.UUID;

public class Abgabe {

    public static ArrayList<UUID> readyPlayers;

    public static void setup() {

        readyPlayers = new ArrayList<>();

        for (String key : AbstractConfig.get().getConfigurationSection("Ready").getKeys(false)) {
            if (isReady(UUID.fromString(key)))
                readyPlayers.add(UUID.fromString(key));
        }

    }

    public static boolean isReady(UUID uuid) {
        return AbstractConfig.exists("Ready." + uuid) && AbstractConfig.get().getBoolean("Ready." + uuid + ".status");
    }

    public static void toggleReady(UUID uuid) {
        AbstractConfig.get().set("Ready." + uuid + ".status", !isReady(uuid));
    }

    public static void reload() {

        readyPlayers = new ArrayList<>();

        for (String key : AbstractConfig.get().getConfigurationSection("Ready").getKeys(false)) {
            if (isReady(UUID.fromString(key)))
                readyPlayers.add(UUID.fromString(key));
        }
    }



}
