package fk.crokmoo.speedrun.command;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RegenCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("regen")) {
            if(Bukkit.getWorld("speedrun") != null) {
                Location loc = new Location(Bukkit.getWorld("world"), 0, (int) 151.5, 0);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.teleport(loc);
                }
                File worldFolder = Bukkit.getWorld("speedrun").getWorldFolder();
                deleteWorldFolder(worldFolder);

                createNewWorld();

            } else {
                Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §cLe monde n'existe pas. (/join pour le généré)");
            }
        }
        return false;
    }

    private boolean deleteWorldFolder(File worldFolder) {
        try {
            Bukkit.unloadWorld(Bukkit.getWorld("speedrun"),false);
            FileUtils.deleteDirectory(worldFolder); // supprime le dossier du monde
            Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §7Le monde speedrun a bien été §csupprimé§7 !");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void createNewWorld() {
        Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §aRégénération du monde...");
        Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §cRisque de freeze et de timed out !");
        WorldCreator worldCreator = new WorldCreator("speedrun");
        worldCreator.seed(-1954962231574696778L); // Remplacez 123456789 par la seed de votre choix
        worldCreator.createWorld();
        Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §7Le monde speedrun a bien été §arégénéré§7 !");
        Bukkit.broadcastMessage(" ");
        Bukkit.broadcastMessage("§8[§6Speedrun §e- §6Guill Games§8]§7 » §7Faites la commande §6/join§7 pour téléporter tout les joueurs dans le monde speedrun afin de commencer votre entrainement.");
    }
}