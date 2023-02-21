package com.daniel.weirdmod.weirdmod.entity.TreeEntity;

import com.daniel.weirdmod.weirdmod.Weirdmod;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TreeEntityModel extends AnimatedGeoModel<TreeEntity> {
    @Override
    public Identifier getModelResource(TreeEntity object) {
        return new Identifier(Weirdmod.MOD_ID, "geo/entity/tree_leaf.geo.json");
    }

    @Override
    public Identifier getTextureResource(TreeEntity object) {
        return new Identifier(Weirdmod.MOD_ID,"textures/entity/tree_leaf.png");
    }

    @Override
    public Identifier getAnimationResource(TreeEntity animatable) {
        return null;
    }
}
