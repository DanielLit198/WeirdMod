package com.daniel.weirdmod.weirdmod.entity.TreeEntity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TreeEntityRenderer extends GeoEntityRenderer<TreeEntity> {
    public TreeEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TreeEntityModel());
        this.shadowRadius = 0.5f;
    }


}
