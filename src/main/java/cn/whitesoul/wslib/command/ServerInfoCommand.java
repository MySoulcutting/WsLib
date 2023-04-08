package cn.whitesoul.wslib.command;

import cn.whitesoul.wslib.message.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerInfoCommand implements CommandExecutor {
    private final long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
    private final long totalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
    private final long freeMemory = Runtime.getRuntime().freeMemory() / 1024 / 1024;
    private final long usedMemory = totalMemory - freeMemory;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.isOp()) {
            //服务器基本信息
            Message.sendMessage(player, "&a服务器信息:");
            System.gc();
            Message.sendMessage(player, "&a版本: &b" + player.getServer().getVersion());
            Message.sendMessage(player, "&aBukkit版本: &b" + player.getServer().getBukkitVersion());
            Message.sendMessage(player, "&a在线人数: &b " + player.getServer().getOnlinePlayers().size() + " / " + player.getServer().getMaxPlayers());
            Message.sendMessage(player, "&a端口: &b" + player.getServer().getPort());
            //服务器内存
            Message.sendMessage(player, "&a内存: &b" + usedMemory + "/" + maxMemory + "MB");
            //服务器硬盘
            Message.sendMessage(player, "&a硬盘: &b" + player.getServer().getWorldContainer().getUsableSpace() / 1024 / 1024 / 1024 + " GB" + " / " + +player.getServer().getWorldContainer().getTotalSpace() / 1024 / 1024 / 1024 + " GB");
            //服务器java信息
            Message.sendMessage(player, "&aJava版本: &b" + System.getProperty("java.version"));
            Message.sendMessage(player, "&aJava供应商: &b" + System.getProperty("java.vendor"));
            //服务器操作系统信息
            Message.sendMessage(player, "&a操作系统: &b" + System.getProperty("os.name"));
            Message.sendMessage(player, "&a操作系统架构: &b" + System.getProperty("os.arch"));
            Message.sendMessage(player, "&a操作系统版本: &b" + System.getProperty("os.version"));
            //服务器文件编码
            Message.sendMessage(player, "&a文件编码: &b" + System.getProperty("file.encoding"));
            //CPU名字
            Message.sendMessage(player, "&aCPU名字: &b" + System.getenv("PROCESSOR_IDENTIFIER"));
            Message.sendMessage(player, "&aCPU核心数: &b" + Runtime.getRuntime().availableProcessors());
            //服务器插件信息
            Message.sendMessage(player, "&a插件数量: &b" + player.getServer().getPluginManager().getPlugins().length);
        }
        return false;
    }
}
