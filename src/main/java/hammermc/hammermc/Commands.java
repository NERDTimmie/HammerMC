package hammermc.hammermc;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import hammermc.hammermc.*;


public class Commands implements CommandExecutor, Listener {
    private HammerMC plugin;

    public Commands(HammerMC plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("TK.HammerMC.hammer")) {

                    ItemStack hammer = new ItemStack(Material.ANVIL);
                    NamespacedKey key = new NamespacedKey(plugin, "HAMMER");
                    NamespacedKey time = new NamespacedKey(plugin, "time");
                    ItemMeta meta = hammer.getItemMeta();
                    meta.setDisplayName(ChatColor.BOLD + "" + ChatColor.RED + "BAN HAMMER");
                    meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 1);
                    meta.addEnchant(Enchantment.DAMAGE_ALL, 10000, true);
                    hammer.setItemMeta(meta);
                    p.getInventory().addItem(hammer);
            }
        }
        return true;
    }
}
