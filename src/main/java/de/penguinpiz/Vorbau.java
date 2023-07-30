package de.penguinpiz;

import com.plotsquared.core.plot.flag.GlobalFlagContainer;
import de.penguinpiz.abgabe.Abgabe;
import de.penguinpiz.commands.SetSpawnCommand;
import de.penguinpiz.commands.SpawnCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Vorbau extends JavaPlugin {

    public static final String PREFIX = ChatColor.AQUA + "SERVER";

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + " starting...");

        if (Bukkit.getPluginManager().getPlugin("PlotSquared") == null) {
            Bukkit.getConsoleSender().sendMessage(PREFIX + " plugin 'PlotSquared' is missing");
            onDisable();
            return;
        }

        AbstractConfig.setup();
        AbstractConfig.get().options().copyDefaults(true);
        AbstractConfig.save();

        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());

        Abgabe.setup();

        Bukkit.getConsoleSender().sendMessage(PREFIX + " started Successfully");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + " stopping...");

        Bukkit.getConsoleSender().sendMessage(PREFIX + " stopped Successfully");
    }


}
