package cn.whitesoul.wslib.message;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
public class Message {
   private static BossBar bossbar = null;

    //玩家消息
    public static void sendMessage(Player player, String message) {
        player.sendMessage(message.replace("&", "§"));
    }
    //发送标题
    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title.replace("&", "§"), subtitle.replace("&", "§"), fadeIn, stay, fadeOut);
    }
    //发送聊天栏上方的消息
    public static void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,  new TextComponent(message.replace("&", "§")));
    }
    //发送Bossbar
    public static void sendBossBar(Player player, String message,BarColor color, BarStyle style) {
        bossbar = Bukkit.createBossBar(message.replace("&","§"), color, style);
        bossbar.addPlayer(player);
        bossbar.setVisible(true);
    }
    //发送Bossbar 2
    public static void sendBossBar(Player player, String message,BarColor color, BarStyle style, double progress) {
        bossbar = Bukkit.createBossBar(message.replace("&","§"), color, style);
        bossbar.addPlayer(player);
        bossbar.setVisible(true);
        bossbar.setProgress(progress);
    }
    //删除Bossbar
    public static void removeBossBar(Player player) {
        bossbar.removePlayer(player);
    }
    //向全服玩家发送消息
     public static void sendAllPlayerMessage(String message) {
        Bukkit.broadcastMessage(message.replace("&", "§"));
        }
     //
    }


