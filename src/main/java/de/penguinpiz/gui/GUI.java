package de.penguinpiz.gui;

import org.bukkit.inventory.Inventory;

public abstract class GUI {

    public Inventory gui;

    public abstract Inventory getGUI();

    public abstract void reload();

}
