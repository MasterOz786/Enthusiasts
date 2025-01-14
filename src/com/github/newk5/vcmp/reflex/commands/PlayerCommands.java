package com.github.newk5.vcmp.reflex.commands;

import com.maxorator.vcmp.java.tools.commands.Command;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.tools.commands.CommandController;
import com.maxorator.vcmp.java.plugin.integration.generic.Colour;
import static com.github.newk5.vcmp.reflex.controllers.MainController.server;
import com.maxorator.vcmp.java.plugin.integration.vehicle.VehicleColours;

public class PlayerCommands implements CommandController {

    private final static Colour LIGHT_GREEN = new Colour(200, 255, 200);

    public PlayerCommands() {
    }

    @Override
    public boolean checkAccess(Player player) {
        return true;
    }

    @Command(usage = "<playerID>")
    public void ping(Player player, Integer id) {
        Player p = server.getPlayer(id);
        if (p != null) {
            server.sendClientMessage(player, LIGHT_GREEN, p.getName() + "'s ping: " + p.getPing());
        }
    }

    @Command
    public void getcar(Player player, String veh) {
        int vehID;
        switch (veh) {
            case "pcj":
                vehID = 191;
                break;
            default:
                vehID = Integer.parseUnsignedInt(veh);
        }

        float x = player.getPosition().x + 5, y = player.getPosition().y, z = player.getPosition().z;
        server.createVehicle(vehID, player.getWorld(), x, y, z, 0, 12, 13);
        server.getVehicle(vehID);
    }
}
