package com.daniel.weirdmod.weirdmod.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(AbstractSkeletonEntity.class)
public class SkeletonMixin {
    @Inject(at = @At("HEAD"), method = "attack")
    public void attack(LivingEntity target, float pullProgress, CallbackInfo ci){
        AbstractSkeletonEntity skeleton = (AbstractSkeletonEntity) (Object) this;
        for (int i = 0; i < 200; i++) {
            ItemStack itemStack = skeleton.getArrowType(skeleton.getStackInHand(ProjectileUtil.getHandPossiblyHolding(skeleton, Items.BOW)));
            PersistentProjectileEntity persistentProjectileEntity = ProjectileUtil.createArrowProjectile(skeleton, itemStack, pullProgress);
            int a = new Random().nextInt(2) == 0 ? -1 : 1;
            int b = new Random().nextInt(2) == 0 ? -1 : 1;
            int c = new Random().nextInt(2) == 0 ? -1 : 1;

            double d = target.getX() - skeleton.getX() + (new Random().nextDouble(4) * a);
            double e = target.getBodyY(0.3333333333333333) - persistentProjectileEntity.getY() + (new Random().nextDouble(4) * b);
            double f = target.getZ() - skeleton.getZ() + (new Random().nextDouble(4) * c);
            double g = Math.sqrt(d * d + f * f);
            persistentProjectileEntity.setVelocity(d, e + g * 0.20000000298023224, f, 1.6F, (float)(14 - skeleton.world.getDifficulty().getId() * 4));
            skeleton.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (skeleton.getRandom().nextFloat() * 0.4F + 0.8F));
            skeleton.world.spawnEntity(persistentProjectileEntity);
        }
    }
}
