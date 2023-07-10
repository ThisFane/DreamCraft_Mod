package com.merl.dreamcraft.datagen;

import com.merl.dreamcraft.registry.ModBlocks;
import com.merl.dreamcraft.registry.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    private static final List<ItemLike> SOY_SMELTING = List.of(ModItems.FRESH_SOY_BEANS.get());


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        //Shaped Recipe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DREAM_SAND_BLOCK.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.SAND)
                .define('B',ModBlocks.DREAM_SAND_BLOCK.get())
                .unlockedBy("has_dreamsand", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.DREAMING_FLOWER.get()).build()))
                .save(pWriter);

        //Shapeless Recipe

        //Smelting
        oreSmelting(pWriter, SOY_SMELTING, RecipeCategory.MISC, ModItems.FRESH_SOY_BEANS.get(), 1, 100, "soy");

    }
}