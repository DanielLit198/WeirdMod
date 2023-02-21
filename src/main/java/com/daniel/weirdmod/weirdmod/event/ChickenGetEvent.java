package com.daniel.weirdmod.weirdmod.event;

import com.daniel.weirdmod.weirdmod.init.ItemInit;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ChickenGetEvent {
    public static void event(){
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof ChickenEntity) {
                ItemStack chicken = new ItemStack(ItemInit.chicken, 1);
                entity.discard();
                player.setStackInHand(Hand.MAIN_HAND,chicken);
            }
            return ActionResult.PASS;
        });
    }
}
