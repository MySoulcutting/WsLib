package cn.whitesoul.wslib.message;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerInfo {
    private final JavaPlugin plugin;
    public ServerInfo(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public void sendInfo(String info) {
        this.plugin.getLogger().info(info.replace("&", "§"));
    }
}
