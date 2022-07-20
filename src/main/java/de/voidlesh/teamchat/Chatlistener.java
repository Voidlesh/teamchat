package de.voidlesh.teamchat;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;

import net.md_5.bungee.event.EventHandler;

public class Chatlistener implements Listener {

    @EventHandler
    public void onChat(ChatEvent event) {
        ProxiedPlayer pp = (ProxiedPlayer)event.getSender();
        String msg = event.getMessage();

        if(msg.startsWith("@team ")) {
            msg = msg.replace("@team ", "");
            if(pp.hasPermission("teamchat.access")) {
                for(ProxiedPlayer pps : ProxyServer.getInstance().getPlayers()) {
                    if(pps.hasPermission("teamchat.access")) {
                        pps.sendMessage(Teamchat.prefix + pp.getName() + ": §e" + msg);
                        event.setCancelled(true);
                    }
                }
            }else {
                pp.sendMessage(Teamchat.prefix + "§cDazu hast du keine Berechtigungen!");
                event.setCancelled(true);
            }
        }
    }

}