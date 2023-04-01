package cn.whitesoul.wslib.file;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class WsYaml {
    private final JavaPlugin plugin;
    private final File file;
    private FileConfiguration yaml;
    //创建Yaml
    public WsYaml(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), fileName);
        if (!this.file.exists()) {
            this.plugin.saveResource(fileName, false);
        }
        this.yaml = YamlConfiguration.loadConfiguration(file);
    }
    //保存Yaml
    public void save() {
        try {
            yaml.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //重新加载Yaml
    public void reload() {
        yaml = YamlConfiguration.loadConfiguration(file);
    }
    //获取Yaml
    public FileConfiguration getConfig() {
        return yaml;
    }
    //获取Yaml
    public Configuration getYaml(){
        return yaml;
    }
}
