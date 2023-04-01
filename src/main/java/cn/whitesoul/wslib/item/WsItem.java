package cn.whitesoul.wslib.item;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WsItem extends ItemStack {
    public WsItem(ItemStack itemStack) {
        super(itemStack);
    }
    public WsItem(Material material , int amount,String name , String... lore) {
        super(material, amount);
        ItemMeta itemMeta = this.getItemMeta();
        itemMeta.setDisplayName(name.replace("&", "§"));
        List<String> list = new ArrayList<>();
        for (String s : lore) {
            list.add(s.replace("&", "§"));
            itemMeta.setLore(list);
        }
        this.setItemMeta(itemMeta);
    }
    public void addLore(String... lore) {
        ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta.hasLore()) {
            List<String> list = itemMeta.getLore();
            for (String s : lore) {
                list.add(itemMeta.getLore().toString());
                list.add(s.replace("&", "§"));
                itemMeta.setLore(list);
                this.setItemMeta(itemMeta);
            }
        } else {
            List<String> list = new ArrayList<>();
            for (String s : lore) {
                list.add(s.replace("&", "§"));
                itemMeta.setLore(list);
                this.setItemMeta(itemMeta);
            }
        }
        this.setItemMeta(itemMeta);
    }
    public void removeLore(int index){
        ItemMeta itemMeta = this.getItemMeta();
        if (itemMeta.hasLore()) {
            List<String> list = itemMeta.getLore();
            list.remove(index);
            itemMeta.setLore(list);
            this.setItemMeta(itemMeta);
        }
    }
}
