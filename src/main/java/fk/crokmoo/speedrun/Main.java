package fk.crokmoo.speedrun;

import fk.crokmoo.speedrun.command.AideCommand;
import fk.crokmoo.speedrun.command.JoinCommand;
import fk.crokmoo.speedrun.command.RegenCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public void onEnable(){
        getCommand("aide").setExecutor(new AideCommand());
        getCommand("join").setExecutor(new JoinCommand());
        getCommand("regen").setExecutor(new RegenCommand());

        createNewWorld();
        for (int i = -16; i <= 16; ++i) {
            for (int j = -16; j <= 16; ++j) {
                new Location(Bukkit.getWorld("world"), i + 0.0, 150.0, j + 0.0).getBlock().setType(Material.BARRIER);
                new Location(Bukkit.getWorld("world"), i + 0.0, 154.0, j + 0.0).getBlock().setType(Material.BARRIER);
            }
            for (int j = 151; j < 154; ++j) {
                new Location(Bukkit.getWorld("world"), i + 0.0, (double) j, -16.0).getBlock().setType(Material.BARRIER);
                new Location(Bukkit.getWorld("world"), i + 0.0, (double) j, 16.0).getBlock().setType(Material.BARRIER);
                new Location(Bukkit.getWorld("world"), -16.0, (double) j, i + 0.0).getBlock().setType(Material.BARRIER);
                new Location(Bukkit.getWorld("world"), 16.0, (double) j, i + 0.0).getBlock().setType(Material.BARRIER);
            }
        }
        Bukkit.getWorld("world").setSpawnLocation(0, (int) 151.5, 0);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }


    public void createNewWorld() {
        WorldCreator worldCreator = new WorldCreator("speedrun");
        worldCreator.seed(-1954962231574696778L); // Remplacez 123456789 par la seed de votre choix
        worldCreator.createWorld();
    }

    @EventHandler
    public void JoinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        if(!p.getLocation().getWorld().getName().equals("speedrun")) {
            Location loc = new Location(Bukkit.getWorld("world"), 0, (int) 151.5, 0);
            p.teleport(loc);
        }

        p.sendMessage("§6Salut, ce plugin a été créé par §cCrokmoo§6 !");
        p.sendMessage("§7J'espère que le plugin te sera utile pour cette semaine d'entraînement.");
        p.sendMessage("§7S'il y a le moindre §cbug§7 avec celui-ci, n'hésite pas à me prévenir sur §9Discord§7 ! (§b§o@crokmoo§7)");
        p.sendMessage(" ");
        p.sendMessage("§7Bref, normalement ton serveur est prêt et tu peux commencer ta séance d'entraînement en faisant §6/join§7 !");
        p.sendMessage("§eBon courage !");
        Bukkit.broadcastMessage("§8[§2+§8] §7" + e.getPlayer().getName());
        p.sendMessage(" ");
        p.sendTitle("§eFait par §6Crokmoo","§eBon courage !",10,50,10);
        p.sendMessage("§9Je fais quelques events (§6UHC§9, §eFK§9, §aSurvie§9, §2etc§9) sur mon serveur §bDiscord§9.");
        p.sendMessage("§aN'hésite pas à le rejoindre, c'est good vibe §2:D §a»§2 https://www.discord.gg/4utX5UVZnR");

    }

    @EventHandler
    public void LeaveEvent(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§8[§4-§8] §7" + e.getPlayer().getName());
    }

    @EventHandler
    public void DeathEvent(PlayerDeathEvent e) {
        e.getEntity().sendMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » Vous pouvez toujours retourner sur la map à l'aide de §6/join");
    }
}