package com.jackydoge.veda.effect;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ImmortalMobEffect extends MobEffect {

    public ImmortalMobEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFD700);
    }

    public static void registerEvents() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) ->
                !entity.hasEffect(ModEffects.IMMORTAL));
    }
}
