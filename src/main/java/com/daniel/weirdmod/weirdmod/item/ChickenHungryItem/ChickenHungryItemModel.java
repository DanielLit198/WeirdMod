package com.daniel.weirdmod.weirdmod.item.ChickenHungryItem;

import com.daniel.weirdmod.weirdmod.Weirdmod;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChickenHungryItemModel extends AnimatedGeoModel<ChickenHungryItem> {
    @Override
    public Identifier getModelResource(ChickenHungryItem object) {
        return new Identifier(Weirdmod.MOD_ID,"geo/item/chicken_hungry.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChickenHungryItem object) {
        return new Identifier(Weirdmod.MOD_ID,"textures/item/chicken.png");
    }

    @Override
    public Identifier getAnimationResource(ChickenHungryItem animatable) {
        return null;
    }
}
