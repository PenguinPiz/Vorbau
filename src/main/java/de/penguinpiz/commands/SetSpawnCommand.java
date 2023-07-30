package de.penguinpiz.commands;

import de.penguinpiz.AbstractConfig;
import de.penguinpiz.LocationUnit;
import de.penguinpiz.Vorbau;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        switch (args.length) {
            case 0:
                LocationUnit.saveLocation(player.getLocation(), "Spawn");
                Bukkit.broadcastMessage(Vorbau.PREFIX + ChatColor.GREEN + " New spawn was set by " + ChatColor.GRAY + player.getDisplayName());
                break;
            default:
                player.sendMessage(Vorbau.PREFIX + ChatColor.RED + " too many arguments!");
                return false;
        }

        return false;
    }
}
