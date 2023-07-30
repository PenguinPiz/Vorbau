package de.penguinpiz;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class AbstractConfig {

    private static File file;
    private static FileConfiguration abstractFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Vorbau").getDataFolder(), "abstractConfig");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {

            }
        }

        abstractFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return abstractFile;
    }

    public static void save() {
        try {
            abstractFile.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean exists(String path) {
        return abstractFile.isSet(path);
    }

}
