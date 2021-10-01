package me.hurricane.listener;

import java.util.Random;

import me.hurricane.main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathEvent implements Listener {
	private Main main;
	public DeathEvent(Main main) {
		this.main = main;
	}
	
	private ItemStack[] goldsack = {
			new ItemStack(Material.GOLD_BLOCK, 32),
			new ItemStack(Material.DIAMOND_AXE, 1),
			new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 8),
			new ItemStack(Material.DIAMOND, 32),
			new ItemStack(Material.GOLDEN_APPLE, 8),
			new ItemStack(Material.TOTEM_OF_UNDYING, 3),
			
	};

	@EventHandler()
	public void onDamage(EntityDeathEvent event) {
		if(!(event.getEntity() instanceof Villager) )
			return;
		if(event.getEntity().getCustomName() == null)
			return;
		if(!event.getEntity().getCustomName().contains("Golden Thief"))
			return;
		
		
		Random r = new Random();
		event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), goldsack[r.nextInt(goldsack.length + 0) - 0]);
		
		for (ItemStack item : main.stolenitems) {
			if(item != null)
				event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), item);
		}
			
		
		
		
	}

}

