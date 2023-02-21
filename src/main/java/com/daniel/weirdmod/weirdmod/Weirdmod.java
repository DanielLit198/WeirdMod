package com.daniel.weirdmod.weirdmod;

import com.daniel.weirdmod.weirdmod.init.EntityInit;
import com.daniel.weirdmod.weirdmod.init.EventInit;
import com.daniel.weirdmod.weirdmod.init.ItemInit;
import com.daniel.weirdmod.weirdmod.world.gen.EntitySpawn;
import net.fabricmc.api.ModInitializer;

public class Weirdmod implements ModInitializer {
    public static final String MOD_ID = "weirdmod";
    @Override
    public void onInitialize() {
        ItemInit.init();
        EventInit.init();
        EntityInit.init();
        EntitySpawn.spawn();
    }
}
