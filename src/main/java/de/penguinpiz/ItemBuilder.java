package de.penguinpiz;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

    private ItemStack itemStack;
    private ItemMeta meta;

    private SkullMeta skullMeta;

    public ItemBuilder(Material material) {
        itemStack = new ItemStack(material);
        meta = itemStack.getItemMeta();
    }

    public ItemBuilder setSkullOwner(String player) {
        if (skullMeta == null) return null;

        skullMeta.setOwner(player);
        return this;
    }

    public ItemBuilder setDisplayName(String name) {
        if (meta !=null)
            meta.setDisplayName(name);
        if (skullMeta !=null)
            skullMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder toggleGlow() {
        if (meta !=null)
            if (meta.getEnchants().isEmpty()) {
                meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            } else {
                meta.removeEnchant(Enchantment.ARROW_DAMAGE);
                meta.removeItemFlags();
            }
        if (skullMeta !=null)
            if (skullMeta.getEnchants().isEmpty()) {
                skullMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                skullMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            } else {
                skullMeta.removeEnchant(Enchantment.ARROW_DAMAGE);
                skullMeta.removeItemFlags();
            }
        return this;
    }

    public ItemStack buildSkull() {
        skullMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemStack.setItemMeta(skullMeta);
        return itemStack;
    }

    public ItemStack build(){
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

}
