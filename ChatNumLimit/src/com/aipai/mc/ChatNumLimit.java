package com.aipai.mc;
import java.io.File;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.ChatColor;

public class ChatNumLimit  extends JavaPlugin
implements Listener{
	public static ChatNumLimit plugin;
	public void onEnable(){
		plugin=this;
		Bukkit.getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getConsoleSender().sendMessage("[ChatNumLimit]Enabled!");
	}
	public void onDisable(){
		Bukkit.getServer().getConsoleSender().sendMessage("[ChatNumLimit]Disabled!");
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		if(e.getPlayer()!=null && e.getMessage().getBytes().length > 25){
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.RED+"您输入的字符数量过长！");
		}
	}
	//bukkit事件系统的原理：遍历listener的每一个方法，并用getAnnonation检查每个类头部是否有eventhandler注解，有的话作为事件函数载入并保存到handlerlist
	//里面
}
