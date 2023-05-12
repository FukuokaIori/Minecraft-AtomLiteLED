package jp.ac.kochict.actiondetection;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.fazecast.jSerialComm.*;

public final class ActionDetection extends JavaPlugin implements Listener {
    private SerialPort port;
    private boolean isConnected;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        // シリアルポートの設定
        port = SerialPort.getCommPort("COM3");  // M5StacksAtomLiteに接続されたシリアルポート名を指定する
        port.setComPortParameters(115200, 8, 1, SerialPort.NO_PARITY);
        port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        // シリアルポートのオープン
        if (port.openPort()) {
            getServer().getConsoleSender().sendMessage("[ActionDetection]" + ChatColor.GREEN + " Open serial port");
            isConnected = true;
        } else {
            getServer().getConsoleSender().sendMessage("[ActionDetection]" + ChatColor.RED + " Failed to open serial port");
            isConnected = false;
        }
    }

    @Override
    public void onDisable() {
        port.closePort();
    }

    @EventHandler
    public void onJump(PlayerJumpEvent e) {
        if (isConnected) {
            port.writeBytes("jump".getBytes(), "jump".getBytes().length);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (isConnected) {
            port.writeBytes("blockbreak".getBytes(), "blockbreak".getBytes().length);
        }
    }

    @EventHandler
    public void chatEvent(AsyncChatEvent e) {
        if (isConnected) {
            port.writeBytes("chat".getBytes(), "chat".getBytes().length);
        }
    }
}