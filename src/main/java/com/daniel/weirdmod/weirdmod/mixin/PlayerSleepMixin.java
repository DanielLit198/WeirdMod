package com.daniel.weirdmod.weirdmod.mixin;

import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerPlayerEntity.class)
public abstract class PlayerSleepMixin{

    @Shadow public abstract void sendMessage(Text message, boolean overlay);

    @Inject(method = "tick", at = @At("HEAD"))
    private void checkVillagerAround(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.isSleeping()) {
            World world = player.world;
            BlockPos pos = player.getBlockPos();
            Box box = new Box(pos).expand(2, 2, 2);
            List<VillagerEntity> villagers = world.getEntitiesByClass(VillagerEntity.class, box, entity -> true);
            if (!villagers.isEmpty()) {
                player.wakeUp(false, true);
                this.sendMessage(Text.of("村民不让你睡"),true);
            }
        }
    }
}
