package me.hurricane.listener;

import java.util.Random;

import me.hurricane.main.Main;
import me.hurricane.mob.Thief;
import net.minecraft.server.v1_16_R3.WorldServer;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlace implements Listener {
	public Main main;
	public BlockPlace(Main main) {
		this.main = main;
	}
	
	
	@EventHandler()
	
	public void onPlace(BlockPlaceEvent event) {
		if(!event.getBlock().getType().equals(Material.GOLD_BLOCK))
			return;
		Random r = new Random();
		if((r.nextInt(1000 + 0) - 0) > 100)
			return;
		Thief dirty = new Thief(event.getPlayer().getLocation());
		WorldServer ws = ((CraftWorld) event.getPlayer().getWorld()).getHandle();
		
		ws.addEntity(dirty);
		
		event.setCancelled(true);
		
		for (ItemStack item : event.getPlayer().getInventory().getContents()) 
			main.stolenitems.add(item);
		
		event.getPlayer().getInventory().clear();
		
		
	}

}
