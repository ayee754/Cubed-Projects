package me.Duck.CustomKnockback;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Events implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageByEntityEvent event) {

        Entity attacker = event.getDamager();
        Entity victim = event.getEntity();

        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) {
            return;
        }

        if (event.isCancelled()) {
            return;
        }

        if (((Player) attacker).getNoDamageTicks() > ((Player) attacker).getMaximumNoDamageTicks() / 2D) {
            return;
        }
        
        try {
            if(attacker instanceof Player) {
                if(((Player) attacker).isSprinting()) {
                    if (victim.isOnGround()) {
                        victim.setVelocity(attacker.getLocation().getDirection().multiply(-0.58D).setY(-0.42F));
                    } else {
                        victim.setVelocity(attacker.getLocation().getDirection().multiply(-0.38D).setY(-0.42F));
                    }
                } else {
                    if (victim.isOnGround()) {
                        victim.setVelocity(attacker.getLocation().getDirection().multiply(-0.1D).setY(-0.109F));
                    } else {
                        victim.setVelocity(attacker.getLocation().getDirection().multiply(-0.03D).setY(-0.42F));
                    }
                }
            }
        } catch(NumberFormatException | ClassCastException e) {}
    }
}
