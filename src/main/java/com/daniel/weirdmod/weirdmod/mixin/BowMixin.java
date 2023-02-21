package com.daniel.weirdmod.weirdmod.mixin;

import com.daniel.weirdmod.weirdmod.init.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BowItem.class)
public abstract class BowMixin {
    @Shadow
    public static float getPullProgress(int useTicks) {
        return 0;
    }

    @Inject(at = @At("HEAD"), method = "onStoppedUsing")
    public void attack(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci){
        if (stack.getNbt().getBoolean("skeleton")) {
            for (int i = 0; i < 200; i++) {
                ItemStack itemStack = user.getArrowType(user.getStackInHand(ProjectileUtil.getHandPossiblyHolding(user, Items.BOW)));
                PersistentProjectileEntity persistentProjectileEntity = ProjectileUtil.createArrowProjectile(user, itemStack, getPullProgress(remainingUseTicks));
                persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                int a = new Random().nextInt(2) == 0 ? -1 : 1;
                int b = new Random().nextInt(2) == 0 ? -1 : 1;
                int c = new Random().nextInt(2) == 0 ? -1 : 1;

                double d = user.getRotationVector().getX() + (new Random().nextDouble(1) * a);
                double e = user.getRotationVector().getY() + (new Random().nextDouble(1) * b);
                double f = user.getRotationVector().getZ() + (new Random().nextDouble(1) * c);
                persistentProjectileEntity.setVelocity(d, e, f, 1.6F, (float) (14 - user.world.getDifficulty().getId() * 4));
                user.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (user.getRandom().nextFloat() * 0.4F + 0.8F));
                user.world.spawnEntity(persistentProjectileEntity);
            }
            if (user.getMainHandStack() == stack) {
                stack.decrement(1);
                user.setStackInHand(Hand.MAIN_HAND, new ItemStack(ItemInit.bowFood, 1));
            } else {
                stack.decrement(1);
                user.setStackInHand(Hand.OFF_HAND, new ItemStack(ItemInit.bowFood, 1));
            }
        }
    }
}
