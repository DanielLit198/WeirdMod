package com.daniel.weirdmod.weirdmod.init;

import com.daniel.weirdmod.weirdmod.event.ChestRickRollEvent;
import com.daniel.weirdmod.weirdmod.event.ChickenGetEvent;
import com.daniel.weirdmod.weirdmod.event.IronGolemEvent;
import com.daniel.weirdmod.weirdmod.event.SkeletonBowGetEvent;

public class EventInit {
    public static void init(){
        IronGolemEvent.event();
        ChickenGetEvent.event();
        SkeletonBowGetEvent.event();
        ChestRickRollEvent.event();
    }
}
