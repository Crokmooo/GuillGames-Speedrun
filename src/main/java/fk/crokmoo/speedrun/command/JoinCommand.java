package fk.crokmoo.speedrun.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("join")) {
            if(Bukkit.getWorld("speedrun") != null) {
                Location loc = new Location(Bukkit.getWorld("speedrun"), -2, 99, 36);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.teleport(loc);
                    Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §6" + p.getName() + " §7a bien été téléporté !");
                }
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §7Tout le monde a bien téléporté dans le monde §7speedrun §7!");
                Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §6Bon courage ! §c:D");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §7Executez §6/regen§7 pour §arégénérer§7 la map !");

            } else {
                Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §cLe monde §6speedrun§c n'a pas été généré.");
                Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §7Faites §6/regen§7 pour générer la map !");

            }
        }
        return false;
    }


}