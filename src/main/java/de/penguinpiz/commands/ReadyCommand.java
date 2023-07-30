package de.penguinpiz.commands;

import de.penguinpiz.Vorbau;
import de.penguinpiz.abgabe.Abgabe;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReadyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (Abgabe.isReady(player.getUniqueId())) {

            Abgabe.toggleReady(player.getUniqueId());
            Abgabe.reload();
            player.sendMessage(Vorbau.PREFIX + " You declared your Plot as READY");
        }


        return false;
    }
}
