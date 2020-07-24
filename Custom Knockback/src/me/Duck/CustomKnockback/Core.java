package me.Duck.CustomKnockback;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(), this);
    }

    public void onDisable() {
        System.out.println("Bye bye! Thank you for using this plugin <3");
    }
}
