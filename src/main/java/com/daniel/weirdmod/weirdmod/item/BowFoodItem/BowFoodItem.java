package com.daniel.weirdmod.weirdmod.item.BowFoodItem;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BowFoodItem extends Item {
    public BowFoodItem() {
        super(new Settings().food(new FoodComponent.Builder().snack().alwaysEdible().build()).group(ItemGroup.FOOD).maxCount(1));
    }
}
