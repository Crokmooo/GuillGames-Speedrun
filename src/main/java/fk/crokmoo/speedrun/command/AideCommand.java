package fk.crokmoo.speedrun.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AideCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("aide")) {
            sender.sendMessage("§6Salut, ce plugin a été créé par §cCrokmoo§6 !");
            sender.sendMessage("§7J'espère que le plugin te sera utile pour cette semaine d'entraînement.");
            sender.sendMessage("§7S'il y a le moindre §cbug§7 avec celui-ci, n'hésite pas à me prévenir sur §9Discord§7 ! (§b§o@crokmoo§7)");
            sender.sendMessage(" ");
            sender.sendMessage("§7Bref, normalement ton serveur est prêt et tu peux commencer ta séance d'entraînement en faisant §6/join§7 !");
            sender.sendMessage("§eBon courage !");
            sender.sendMessage(" ");
            sender.sendMessage("§9Je fais quelques events (§6UHC§9, §eFK§9, §aSurvie§9, §2etc§9) sur mon serveur §bDiscord§9.");
            sender.sendMessage("§aN'hésite pas à le rejoindre, c'est good vibe §2:D §a»§2 https://www.discord.gg/4utX5UVZnR");
        }
        return false;
    }
}
