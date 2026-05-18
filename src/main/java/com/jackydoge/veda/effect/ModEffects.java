package com.jackydoge.veda.effect;

import com.jackydoge.veda.Veda;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

public class ModEffects {


    public static final Holder<MobEffect> IMMORTAL = register("immortal",
           new ImmortalMobEffect());

    private static Holder<MobEffect> register(String name, MobEffect mobEffect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(Veda.MOD_ID, name),
                mobEffect);
    }

    public static void registerModEffects() {
        Veda.LOGGER.info("Registering Effects for " + Veda.MOD_ID);
    }
}
