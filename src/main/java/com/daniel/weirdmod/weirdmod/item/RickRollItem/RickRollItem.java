package com.daniel.weirdmod.weirdmod.item.RickRollItem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class RickRollItem extends Item {
    public RickRollItem() {
        super(new Settings().group(ItemGroup.MISC).maxCount(1));
    }
}
