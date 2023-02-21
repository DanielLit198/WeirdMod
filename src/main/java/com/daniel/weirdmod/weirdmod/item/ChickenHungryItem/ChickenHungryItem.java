package com.daniel.weirdmod.weirdmod.item.ChickenHungryItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ChickenHungryItem extends Item implements IAnimatable {
    public ChickenHungryItem() {
        super(new Settings().group(ItemGroup.COMBAT).maxCount(1));
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return GeckoLibUtil.createFactory(this);
    }
}
