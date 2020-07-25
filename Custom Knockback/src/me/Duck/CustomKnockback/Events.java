package me.Duck.CustomKnockback;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

public class Events implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageByEntityEvent event) {

        Player attacker = ((Player) event.getDamager());
        Vector atkLoc = attacker.getLocation().getDirection();
        Entity victim = event.getEntity();

        if(!(victim instanceof Player)) return;
        if (!(attacker instanceof Player)) return;
        if (event.isCancelled()) return;
        if (attacker.getNoDamageTicks() > attacker.getMaximumNoDamageTicks() / 2) return;

        try {
            if(attacker.isSprinting()) {
                if (victim.isOnGround()) {
                    victim.setVelocity(atkLoc.multiply(-0.17D).setY(-0.42F));
                } else {
                    victim.setVelocity(atkLoc.multiply(-0.38D).setY(-0.42F));
                }
            } else {
                if (victim.isOnGround()) {
                    victim.setVelocity(atkLoc.multiply(-0.1D).setY(-0.109F));
                } else {
                    victim.setVelocity(atkLoc.multiply(-0.03D).setY(-0.42F));
                }
            }
        } catch(NumberFormatException | ClassCastException e) { e.printStackTrace(); }
    }
}
