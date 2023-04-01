package cn.whitesoul.wslib.util;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.RegisteredServiceProvider;

public class WsVault {
    private static Economy economy;
    private static Chat chat;

    private static Permission permission;
    //初始化
    public WsVault() {
        RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null)
            economy = (Economy)economyProvider.getProvider();
        RegisteredServiceProvider<Chat> ch = Bukkit.getServer().getServicesManager().getRegistration(Chat.class);
        if (ch != null)
            chat = (Chat)ch.getProvider();
        RegisteredServiceProvider<Permission> per = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
        if (per != null)
            permission = (Permission)per.getProvider();
    }
    //获取经济
    public static Economy getEconomy() {
        return economy;
    }
    //获取聊天
    public static Chat getChat() {
        return chat;
    }
    //获取权限
    public static Permission getPermission() {
        return permission;
    }
    //增加经济
    public static void addEconomy(OfflinePlayer player, double money) {
        economy.depositPlayer(player, money);
    }
    //减少经济
   public static void removeEconomy(OfflinePlayer player, double money) {
        economy.withdrawPlayer(player, money);
    }
    //获取经济
    public static double getEconomy(OfflinePlayer player) {
        return economy.getBalance(player);
    }
    //查询经济
    public static boolean hasEconomy(OfflinePlayer player, double money) {
        return economy.has(player, money);
    }
}
