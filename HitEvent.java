package me.hurricane.listener;

import java.util.Random;

import me.hurricane.main.Main;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class HitEvent implements Listener {
	public Main main;
	public HitEvent(Main main) {
		this.main = main;
	}
	
	private ItemStack[] goldsack = {
			new ItemStack(Material.GOLD_BLOCK, 8),
			new ItemStack(Material.GOLDEN_AXE, 1),
			new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 4),
			new ItemStack(Material.DIAMOND, 5),
			new ItemStack(Material.IRON_BLOCK, 8),
			new ItemStack(Material.TOTEM_OF_UNDYING, 1),
			
	};

	@EventHandler()
	public void onDamage(EntityDamageEvent event) {
		if(!(event.getEntity() instanceof Villager) )
			return;
		if(event.getEntity().getCustomName() == null)
			return;
		if(!event.getEntity().getCustomName().contains("Golden Thief"))
			return;
		
		
		Random r = new Random();
		event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), goldsack[r.nextInt(goldsack.length + 0) - 0]);
			
		
		
		
	}

}
