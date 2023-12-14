package pl.vatiaz.core.command;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cTa komenda jest tylko dla graczy!"));
            return true;
        }

        Player player = (Player) sender;
        if (player.isOp() || player.hasPermission("cmd.gamemode")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cPodaj tryb gry&8: &70, 1, 2, 3"));
                return true;
            }
    
            GameMode newGameMode;
            switch (args[0].toLowerCase()) {
                case "0":
                    newGameMode = GameMode.SURVIVAL;
                    break;
                case "1":
                    newGameMode = GameMode.CREATIVE;
                    break;
                case "2":
                    newGameMode = GameMode.ADVENTURE;
                    break;
                case "3":
                    newGameMode = GameMode.SPECTATOR;
                    break;
                default:
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cNiepoprawny tryb gry: &7" + args[0]));
                    return true;
            }
            
            player.setGameMode(newGameMode);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cZmieniono tryb gry na &7" + newGameMode.name().toLowerCase() + "."));
            return true;
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNie masz uprawnien &7(cmd.gamemode)"));
            return true;
        }
    }
}
