package hammermc.hammermc;
import hammermc.hammermc.*;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.w3c.dom.events.Event;

public class Hammerhit implements Listener {
    private HammerMC plugin;
    public Hammerhit(HammerMC plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onDamger(EntityDamageByEntityEvent e){
        if(e.getEntity().getType() == EntityType.PLAYER) {
            Player D = (Player) e.getDamager();
            Player V = (Player) e.getEntity();
            NamespacedKey key = new NamespacedKey(plugin, "HAMMER");
            ItemStack item = D.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer container = meta.getPersistentDataContainer();
            if(D.hasPermission("TK.HammerMC.ban")){
                if(container.has(key, PersistentDataType.INTEGER)) {
                    int i =  container.get(key, PersistentDataType.INTEGER);
                    if (i == 1){
                        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "ban " + V.getName().toString() + " You got hit with the banhammer by " + D.getName());
                    }
                }

            }
        }
    }
    @EventHandler
    public void onPlaceblock(BlockPlaceEvent e){
        Player p = e.getPlayer();
        NamespacedKey key = new NamespacedKey(plugin, "HAMMER");
        if(p.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(key, PersistentDataType.INTEGER)){
            e.setCancelled(true);
        }
    }
}
