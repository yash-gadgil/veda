package com.jackydoge.veda.item;

import com.jackydoge.veda.Veda;
import com.jackydoge.veda.entity.ModEntities;
import com.jackydoge.veda.fluid.ModFluids;
import com.jackydoge.veda.item.weapon.SudarshanChakraItem;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Function;

public class ModItems {

    public static final Item AMRUT = registerItem("amrut", AmrutItem::new, new Item.Properties()
            .component(DataComponents.CONSUMABLE, ModConsumables.AMRUT)
            .rarity(Rarity.EPIC)
            .stacksTo(16));

    public static final Item COPPER_GADA = registerItem("copper_gada", Item::new, new Item.Properties().sword(ToolMaterial.COPPER,12.0F, -3.5F).durability(400));
    public static final Item IRON_GADA = registerItem("iron_gada", Item::new, new Item.Properties().sword(ToolMaterial.IRON,13.0F, -3.5F).durability(750));
    public static final Item GOLDEN_GADA = registerItem("golden_gada", Item::new, new Item.Properties().sword(ToolMaterial.GOLD,10.0F, -3.5F).durability(120));
    public static final Item DIAMOND_GADA = registerItem("diamond_gada", Item::new, new Item.Properties().sword(ToolMaterial.DIAMOND,15.0F, -3.5F).durability(3650));
    public static final Item NETHERITE_GADA = registerItem("netherite_gada", Item::new, new Item.Properties().sword(ToolMaterial.NETHERITE,18.0F, -3.5F).durability(5150).fireResistant());

    public static final Item SUDARSHAN_CHAKRA = registerItem("sudarshan_chakra", SudarshanChakraItem::new,
            new Item.Properties()
                    .durability(1500)
                    .rarity(Rarity.EPIC)
                    .stacksTo(1));

    public static final Item BLOOD_NECTAR_BUCKET = registerItem("blood_nectar_bucket",
            props -> new BucketItem(ModFluids.BLOOD_NECTAR_SOURCE, props),
            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1));

    public static final Item SADHU_SPAWN_EGG = registerItem("sadhu_spawn_egg", SpawnEggItem::new, new Item.Properties().spawnEgg(ModEntities.SADHU));

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
