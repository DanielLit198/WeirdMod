package com.daniel.weirdmod.weirdmod.event;


import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.util.ActionResult;

public class IronGolemEvent {
    public static void event(){
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof IronGolemEntity) {
                IronGolemEntity golem = (IronGolemEntity) entity;
                int health = (int) golem.getHealth();
                System.out.println(golem.getY() - player.getY());
                if (health <= 80 && health >= 60 && player.getY() - golem.getY() >= 3 && golem.getTarget() != null) {

                    golem.setVelocity(0,1.5,0);
                }
                if (health <= 60 && golem.getTarget() != null){
                    EnderPearlEntity eye = new EnderPearlEntity(world, (LivingEntity) entity);
                    eye.refreshPositionAfterTeleport(entity.getX()+entity.getRotationVector().getX(),
                            entity.getY()+2.5+entity.getRotationVector().getY(),
                            entity.getZ()+entity.getRotationVector().getZ());
                    eye.setVelocity((player.getX()-eye.getX())/5,(player.getY()+1.5-eye.getY())/5,(player.getZ()-eye.getZ())/5);
                    world.spawnEntity(eye);
                }
            }
            return ActionResult.PASS;
        });
    }
}


