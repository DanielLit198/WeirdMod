package com.daniel.weirdmod.weirdmod.item.ChikenItem;

import com.daniel.weirdmod.weirdmod.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.Random;

public class ChickenItem extends Item implements IAnimatable {
    public ChickenItem() {
        super(new Settings().group(ItemGroup.COMBAT).maxCount(1));
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //发射鸡蛋并且计算鸡的子弹数量
        if (!world.isClient) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (new Random().nextFloat() * 0.4F + 0.8F));
            EggEntity egg = new EggEntity(world,user);
            egg.setVelocity(user.getRotationVector().x*2,user.getRotationVector().y*2,user.getRotationVector().z*2);
            world.spawnEntity(egg);
            if (!user.getStackInHand(hand).hasNbt()) user.getStackInHand(hand).setNbt(new NbtCompound());
            user.getStackInHand(hand).getNbt().putInt("ammo",user.getStackInHand(hand).getNbt().getInt("ammo")+1);
            //当鸡被榨干时
            if(user.getStackInHand(hand).getNbt().getInt("ammo") >= 20){
                user.getStackInHand(hand).getNbt().putInt("ammo",0);
                user.getStackInHand(hand).decrement(1);
                user.setStackInHand(hand,new ItemStack(ItemInit.chickenHungry));
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void registerControllers(AnimationData animationData) {
    }

    @Override
    public AnimationFactory getFactory() {
        return GeckoLibUtil.createFactory(this);
    }
}
