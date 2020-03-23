package cn.xtuly.mcp.wrenchfix;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class WrenchFIX extends JavaPlugin implements Listener {
    private static FileConfiguration config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
        config = this.getConfig();
        initDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void initDefaultConfig() {
        //初始化默认设置
        config.options().copyDefaults(true);
        config.addDefault("Option", "default");
        config.addDefault("Message.warn", "[§aWrenchFix§f]检测到你正在你用扳手刷物品bug,你已被警告");
        config.addDefault("Message.kick", "[§aWrenchFix§f]检测到你正在你用扳手刷物品bug,你已被kick");
        config.addDefault("Message.ban", "[§aWrenchFix§f]检测到你正在你用扳手刷物品bug,你已被ban");
        this.saveConfig();

    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
//        if(e.getPlayer().isOp()){
//            e.getPlayer().sendMessage("Action:" + e.getAction().name());
//            e.getPlayer().sendMessage("BlockId:" + e.getClickedBlock().getTypeId());
//            e.getPlayer().sendMessage("MainhandItemId:" + e.getPlayer().getInventory().getItemInMainHand().getTypeId());
//            e.getPlayer().sendMessage("OffhandItemId:" + e.getPlayer().getInventory().getItemInOffHand().getTypeId());
//        }
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            int itemID = e.getPlayer().getInventory().getItemInMainHand().getTypeId();
            if(itemID == 4226 || itemID == 4227 || itemID == 4238){
                if(e.getClickedBlock().getTypeId() == 346){
                    if(e.getPlayer().getInventory().getItemInOffHand().getType() != Material.AIR){
                        //e.getPlayer().sendMessage("Canceled");
                        e.setCancelled(true);
                        switch(config.getString("Option")){
                            case "warn":
                                e.getPlayer().sendMessage(config.getString("Message.warn"));
                                break;
                            case "kick":
                                e.getPlayer().kickPlayer(config.getString("Message.kick"));
                                break;
                            case "ban":
                                Bukkit.getBanList(BanList.Type.NAME).addBan(e.getPlayer().getName(),config.getString("Message.ban"),null,"WrenchFix");
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    }
}
