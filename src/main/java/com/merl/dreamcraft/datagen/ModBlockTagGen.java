package com.merl.dreamcraft.datagen;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGen extends BlockTagsProvider {
    public ModBlockTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DreamCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
    this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.DREAMCATCHER.get(),
                    ModBlocks.HOLDER.get(),
                    ModBlocks.STONE_SEPARATOR.get(),
                    ModBlocks.DRYING_TABLE.get(),
                    ModBlocks.CORTEX_BLOCK.get(),
                    ModBlocks.CORTEX_BRICK.get()
                    );

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.DREAM_SAND_BLOCK.get()
                );



    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
