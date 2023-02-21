package com.daniel.weirdmod.weirdmod.entity.TreeEntity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class TreeEntity extends AnimalEntity implements IAnimatable {
    AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public TreeEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        refreshPositionAndAngles(getBlockPos(),0,0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1,new EscapeDangerGoal(this,1));
        super.initGoals();
    }

    @Override
    public void travel(Vec3d movementInput) {
        super.travel(movementInput);
    }

    public static DefaultAttributeContainer.Builder set(){
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH,25d);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        this.dropStack(new ItemStack(Items.OAK_WOOD,5));
        super.onDeath(damageSource);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
