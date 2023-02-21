package com.daniel.weirdmod.weirdmod.init;

import com.daniel.weirdmod.weirdmod.Weirdmod;
import com.daniel.weirdmod.weirdmod.item.BowFoodItem.BowFoodItem;
import com.daniel.weirdmod.weirdmod.item.ChickenHungryItem.ChickenHungryItem;
import com.daniel.weirdmod.weirdmod.item.ChickenHungryItem.ChickenHungryItemRenderer;
import com.daniel.weirdmod.weirdmod.item.ChikenItem.ChickenItem;
import com.daniel.weirdmod.weirdmod.item.ChikenItem.ChickenItemRenderer;
import com.daniel.weirdmod.weirdmod.item.RickRollItem.RickRollItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class ItemInit {
    public static final Item chicken = Registry.register(Registry.ITEM,new Identifier(Weirdmod.MOD_ID,"chicken"),new ChickenItem());
    public static final Item chickenHungry = Registry.register(Registry.ITEM,new Identifier(Weirdmod.MOD_ID,"chicken_hungry"),new ChickenHungryItem());
    public static final Item bowFood = Registry.register(Registry.ITEM,new Identifier(Weirdmod.MOD_ID,"bow_food"),new BowFoodItem());
    public static final Item rick = Registry.register(Registry.ITEM,new Identifier(Weirdmod.MOD_ID,"rick"),new RickRollItem());
    public static void init(){

        GeoItemRenderer.registerItemRenderer(chicken,new ChickenItemRenderer());
        GeoItemRenderer.registerItemRenderer(chickenHungry,new ChickenHungryItemRenderer());
//        Item test = Registry.register(Registry.ITEM,new Identifier(Weirdmod.MOD_ID,"test"),new TestItem());

    }
}
