package com.jackydoge.veda.item;

import com.jackydoge.veda.Veda;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Function;

public class ModItems {

    public static final Item AMRUT = registerItem("amrut", Item::new, new Item.Properties().component(DataComponents.CONSUMABLE, ModConsumables.AMRUT));

    public static final Item COPPER_GADA   = registerItem("copper_gada",   Item::new, new Item.Properties().sword(ToolMaterial.COPPER,    8.0F, -3.4F).durability(1000));
    public static final Item IRON_GADA     = registerItem("iron_gada",     Item::new, new Item.Properties().sword(ToolMaterial.IRON,      8.0F, -3.4F).durability(1500));
    public static final Item GOLDEN_GADA   = registerItem("golden_gada",   Item::new, new Item.Properties().sword(ToolMaterial.GOLD,      8.0F, -3.4F).durability(750));
    public static final Item DIAMOND_GADA  = registerItem("diamond_gada",  Item::new, new Item.Properties().sword(ToolMaterial.DIAMOND,   8.0F, -3.4F).durability(4500));
    public static final Item NETHERITE_GADA = registerItem("netherite_gada", Item::new, new Item.Properties().sword(ToolMaterial.NETHERITE, 8.0F, -3.4F).durability(6500).fireResistant());

    private static <T extends Item> T registerItem(String name, Function<Item.Properties, T> function, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Veda.MOD_ID, name),
                function.apply(properties.setId(ResourceKey.create(Registries.ITEM,
                        Identifier.fromNamespaceAndPath(Veda.MOD_ID, name)))));
    }

    private static <T extends Item> T registerItem(String name, Function<Item.Properties, T> function) {
        return registerItem(name, function, new Item.Properties());
    }

    public static void registerModItems() {
        Veda.LOGGER.info("Registering Items for " + Veda.MOD_ID);
    }
}
