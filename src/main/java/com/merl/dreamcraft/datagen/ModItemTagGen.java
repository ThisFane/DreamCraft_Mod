package com.merl.dreamcraft.datagen;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.registry.ModItems;
import com.merl.dreamcraft.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGen extends ItemTagsProvider {

    public ModItemTagGen(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, lookupCompletableFuture, DreamCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.LIVING_ESSENCE)
                .add(ModItems.LIFE_ESSENCE.get());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
