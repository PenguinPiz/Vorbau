package de.penguinpiz.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class VorbauGUI extends GUI{

    public VorbauGUI() {
        //setup gui from config with players that are ready
        gui = Bukkit.createInventory(null, 9 * 3);
    }

    @Override
    public Inventory getGUI() {
        return gui;
    }

    @Override
    public void reload() {
        //reload players that are ready
    }
}
