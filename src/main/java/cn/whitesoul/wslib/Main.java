package cn.whitesoul.wslib;

import cn.whitesoul.wslib.file.WsYaml;
import cn.whitesoul.wslib.item.WsItem;
import cn.whitesoul.wslib.message.ServerInfo;
import cn.whitesoul.wslib.util.WsVault;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        ServerInfo.sendInfo("&a插件已加载");
        ServerInfo.sendInfo("&a插件版本: " + this.getDescription().getVersion());


    }

    @Override
    public void onDisable() {
    }
}
