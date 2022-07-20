package de.voidlesh.teamchat;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public final class Teamchat extends Plugin {

    public static String prefix = "§7[§4Team§7] - §7";

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerListener(this, new Chatlistener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
