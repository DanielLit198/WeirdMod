package com.daniel.weirdmod.weirdmod.event;

import com.daniel.weirdmod.weirdmod.init.ItemInit;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;

import java.util.Random;

public class ChestRickRollEvent {
    public static void event(){
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.getBlockState(hitResult.getBlockPos()).hasBlockEntity())
            if (world.getBlockEntity(hitResult.getBlockPos()).getType() == BlockEntityType.CHEST) {
                ChestBlockEntity chest = (ChestBlockEntity) world.getBlockEntity(hitResult.getBlockPos());
                if (new Random().nextInt(10) >= 5) {
                    for (int i = 0; i < chest.size(); i++) {
                        if (chest.getStack(i).getItem() != Items.AIR){
                            System.out.println(chest.getStack(i));
                            chest.removeStack(i);
                            chest.setStack(13, new ItemStack(ItemInit.rick));
                        }
                    }
                }
            }
            return ActionResult.PASS;
        });
    }
}
