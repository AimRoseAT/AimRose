package at.aimrose.service.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import at.aimrose.service.Main;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("aimrose.fly") || (player.hasPermission("aimrose.*"))) {
                if (args.length == 0) {
                    if (player.getAllowFlight()) {
                        player.sendMessage(Main.PREFIX + "§7Dein Flugmodus wurde deaktiviert.");
                        player.setAllowFlight(false);
                        player.setFlying(false);
                    } else {
                        player.sendMessage(Main.PREFIX + "§7Dein Flugmodus wurde aktiviert.");
                        player.setAllowFlight(true);
                        player.setFlying(true);
                    }

                } else
                    player.sendMessage(Main.PREFIX + "§7Bitte benutze /fly.");
            } else
                player.sendMessage(Main.PREFIX + Main.NOPERMS);
        } else
            sender.sendMessage("§4Du musst ein Spieler sein für diesen Command.");


        return false;
    }
}
