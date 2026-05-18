package com.jackydoge.veda.creativemodetab;

import com.jackydoge.veda.Veda;
import com.jackydoge.veda.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabs {

    public static final CreativeModeTab VEDA_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Veda.MOD_ID, "veda"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.AMRUT))
                    .title(Component.translatable("creativemodetab.veda.veda"))
                    .displayItems((parameters, output) -> {

                        output.accept(ModItems.AMRUT);
                        output.accept(ModItems.COPPER_GADA);
                        output.accept(ModItems.IRON_GADA);
                        output.accept(ModItems.GOLDEN_GADA);
                        output.accept(ModItems.DIAMOND_GADA);
                        output.accept(ModItems.NETHERITE_GADA);

                    }).build());


    public static void registerModCreativeModeTabs() {
        Veda.LOGGER.info("Registering Creative Mode Tabs for " + Veda.MOD_ID);
    }
}
