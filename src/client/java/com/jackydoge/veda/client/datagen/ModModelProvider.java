package com.jackydoge.veda.client.datagen;

import com.jackydoge.veda.Veda;
import com.jackydoge.veda.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.select.DisplayContext;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    private static final ModelTemplate GADA_IN_HAND = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath(Veda.MOD_ID, "item/gada")),
            Optional.of("_in_hand"),
            TextureSlot.TEXTURE, TextureSlot.PARTICLE
    );

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        gen.generateFlatItem(ModItems.AMRUT, ModelTemplates.FLAT_ITEM);

        generateGada(gen, ModItems.COPPER_GADA, "copper");
        generateGada(gen, ModItems.IRON_GADA, "iron");
        generateGada(gen, ModItems.GOLDEN_GADA, "golden");
        generateGada(gen, ModItems.DIAMOND_GADA, "diamond");
        generateGada(gen, ModItems.NETHERITE_GADA, "netherite");
    }

    private void generateGada(ItemModelGenerators gen, Item item, String tier) {
        Identifier flatModelId = gen.createFlatItemModel(item, ModelTemplates.FLAT_ITEM);

        Material inHandTexture = new Material(Identifier.fromNamespaceAndPath(Veda.MOD_ID, "item/" + tier + "_gada_in_hand"));
        TextureMapping inHandMapping = new TextureMapping()
                .put(TextureSlot.TEXTURE, inHandTexture)
                .put(TextureSlot.PARTICLE, inHandTexture);
        Identifier inHandModelId = GADA_IN_HAND.create(item, inHandMapping, gen.modelOutput);

        ItemModel.Unbaked flatModel = ItemModelUtils.plainModel(flatModelId);
        ItemModel.Unbaked inHandModel = ItemModelUtils.plainModel(inHandModelId);

        gen.itemModelOutput.accept(item, ItemModelUtils.select(
                new DisplayContext(),
                inHandModel,
                ItemModelUtils.when(ItemDisplayContext.GUI, flatModel),
                ItemModelUtils.when(ItemDisplayContext.FIXED, flatModel)
        ));
    }
}
