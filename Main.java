package me.hurricane.main;

import java.util.ArrayList;
import java.util.List;

import me.hurricane.listener.BlockPlace;
import me.hurricane.listener.DeathEvent;
import me.hurricane.listener.HitEvent;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public List<ItemStack> stolenitems = new ArrayList<ItemStack>();
	
	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new BlockPlace(this), this); 
		pm.registerEvents(new DeathEvent(this), this);
		pm.registerEvents(new HitEvent(this), this);
		
		
	}
	@Override
	public void onDisable() {
		
		
		
		
	}
	

}
