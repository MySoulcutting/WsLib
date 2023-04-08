package cn.whitesoul.wslib;

import cn.whitesoul.wslib.command.ServerInfoCommand;
import cn.whitesoul.wslib.message.ServerInfo;
import org.bukkit.plugin.java.JavaPlugin;

public final class WsLib extends JavaPlugin {
    public static WsLib INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        ServerInfo serverInfo = new ServerInfo(this);
        serverInfo.sendInfo("&a插件作者: " + this.getDescription().getAuthors());
        serverInfo.sendInfo("&a插件版本: " + this.getDescription().getVersion());
        serverInfo.sendInfo("&a加载成功!");
        getCommand("serverinfo").setExecutor(new ServerInfoCommand());
    }

    @Override
    public void onDisable() {
    }
}
