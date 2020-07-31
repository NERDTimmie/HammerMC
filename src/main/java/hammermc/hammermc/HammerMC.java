package hammermc.hammermc;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HammerMC extends JavaPlugin implements Listener {
private Commands commands = new Commands(this);
    @Override
    public void onEnable() {
        getCommand("hammer").setExecutor(commands);
        this.getServer().getPluginManager().registerEvents(new Hammerhit(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
