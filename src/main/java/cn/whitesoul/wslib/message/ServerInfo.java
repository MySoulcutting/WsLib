package cn.whitesoul.wslib.message;

import cn.whitesoul.wslib.Main;

public class ServerInfo {
    public static void sendInfo(String info) {
        Main.INSTANCE.getLogger().info(info.replace("&", "§"));
    }
}
