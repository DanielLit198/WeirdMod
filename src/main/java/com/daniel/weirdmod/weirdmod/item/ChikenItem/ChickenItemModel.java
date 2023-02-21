package com.daniel.weirdmod.weirdmod.item.ChikenItem;

import com.daniel.weirdmod.weirdmod.Weirdmod;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChickenItemModel extends AnimatedGeoModel<ChickenItem> {
    @Override
    public Identifier getModelResource(ChickenItem object) {
        return new Identifier(Weirdmod.MOD_ID,"geo/item/chicken.geo.json");
    }

    @Override
    public Identifier getTextureResource(ChickenItem object) {
        return new Identifier(Weirdmod.MOD_ID,"textures/item/chicken.png");
    }

    @Override
    public Identifier getAnimationResource(ChickenItem animatable) {
        return null;
    }
}
