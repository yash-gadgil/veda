package com.jackydoge.veda.client.datagen;

import com.jackydoge.veda.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new ModRecipes(registries, output);
    }

    @Override
    public String getName() {
        return "Veda Recipes";
    }

    private static class ModRecipes extends RecipeProvider {

        private final HolderLookup.Provider registries;

        ModRecipes(HolderLookup.Provider registries, RecipeOutput output) {
            super(registries, output);
            this.registries = registries;
        }

        @Override
        public void buildRecipes() {
            gadaRecipe(Items.COPPER_INGOT, Items.COPPER_BLOCK, ModItems.COPPER_GADA);
            gadaRecipe(Items.IRON_INGOT, Items.IRON_BLOCK, ModItems.IRON_GADA);
            gadaRecipe(Items.GOLD_INGOT, Items.GOLD_BLOCK, ModItems.GOLDEN_GADA);
            gadaRecipe(Items.DIAMOND, Items.DIAMOND_BLOCK, ModItems.DIAMOND_GADA);
            gadaRecipe(Items.NETHERITE_INGOT, Items.NETHERITE_BLOCK, ModItems.NETHERITE_GADA);
        }

        private void gadaRecipe(ItemLike ingot, ItemLike block, Item result) {
            ShapedRecipeBuilder.shaped(registries.lookupOrThrow(Registries.ITEM), RecipeCategory.COMBAT, result)
                    .pattern(" I ")
                    .pattern("IBI")
                    .pattern(" S ")
                    .define('I', ingot)
                    .define('B', block)
                    .define('S', Items.STICK)
                    .unlockedBy(getHasName(ingot), has(ingot))
                    .save(output);
        }
    }
}
