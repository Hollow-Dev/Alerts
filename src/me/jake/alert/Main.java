package me.jake.alert;

import java.io.PrintStream;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  public void onEnable()
  {
    System.out.println("Alert has been enabled!");
  }
  
  public void onDisable()
  {
    System.out.println("Alert has been disabled!");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!sender.hasPermission("alert.use"))
    {
      sender.sendMessage(noperms);
      return true;
    }
    if (args.length == 0)
    {
      sender.sendMessage(ChatColor.RED + "Usage: /alert <Message>");
      return true;
    }
    if (args.length > 0)
    {
      String msg = "";
      for (int i = 0; i < args.length; i++) {
        msg = msg + " " + args[i];
      }
      msg = msg.replace("&", "?");
      
      Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Alert" + ChatColor.DARK_GRAY + "]" + ChatColor.DARK_RED + msg);
    }
    return true;
  }
  
  public static String noperms = ChatColor.RED + "No permissions.";
  public static String notaplayer = ChatColor.RED + "You can not run this cmd from a console.";
}
