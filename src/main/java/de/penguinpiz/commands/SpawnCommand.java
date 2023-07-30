package de.penguinpiz.commands;

import de.penguinpiz.AbstractConfig;
import de.penguinpiz.ItemBuilder;
import de.penguinpiz.LocationUnit;
import de.penguinpiz.Vorbau;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;


        if (!AbstractConfig.exists("Location.SPAWN")) {
            player.sendMessage(Vorbau.PREFIX + ChatColor.RED + " There is no spawn set!");
            return false;
        }

        player.teleport(LocationUnit.get("Spawn", true));
        player.playSound(player.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 10 , 10);

        return false;
    }
}
