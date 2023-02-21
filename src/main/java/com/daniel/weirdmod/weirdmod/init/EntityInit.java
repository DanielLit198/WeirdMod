package com.daniel.weirdmod.weirdmod.init;

import com.daniel.weirdmod.weirdmod.Weirdmod;
import com.daniel.weirdmod.weirdmod.entity.TreeEntity.TreeEntity;
import com.daniel.weirdmod.weirdmod.entity.TreeEntity.TreeEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityInit {
   public static EntityType<TreeEntity> tree = Registry.register(
           Registry.ENTITY_TYPE, new Identifier(Weirdmod.MOD_ID,"tree"),
           FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TreeEntity::new)
                           .dimensions(EntityDimensions.fixed(1f,5f)).build());
    public static final void init(){
        FabricDefaultAttributeRegistry.register(EntityInit.tree, TreeEntity.set());
        EntityRendererRegistry.register(EntityInit.tree, TreeEntityRenderer::new);

    }
}
