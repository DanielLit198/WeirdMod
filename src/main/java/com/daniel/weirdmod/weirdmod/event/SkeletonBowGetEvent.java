package com.daniel.weirdmod.weirdmod.event;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class SkeletonBowGetEvent {
    public static void event (){
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity instanceof SkeletonEntity) {
                ((SkeletonEntity) entity).getStackInHand(Hand.MAIN_HAND).decrement(1);
                ((SkeletonEntity) entity).getStackInHand(Hand.OFF_HAND).decrement(1);
                ItemStack bow = new ItemStack(Items.BOW, 1);
                bow.setNbt(new NbtCompound());
                bow.getNbt().putBoolean("skeleton",true);
                player.setStackInHand(Hand.MAIN_HAND,bow);
            }
            return ActionResult.PASS;
        });
    }
}
