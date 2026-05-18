package com.jackydoge.veda.item;

import com.jackydoge.veda.Veda;
import com.jackydoge.veda.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class ModConsumables {

    public static final Consumable AMRUT = Consumables.defaultDrink()
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(
                            List.of(
                                new MobEffectInstance(ModEffects.IMMORTAL, 3200, 0)
                            )
                    )
            )
            .build();

    public static void registerModConsumables() {
        Veda.LOGGER.info("Registering Consumables for " + Veda.MOD_ID);
    }
}
