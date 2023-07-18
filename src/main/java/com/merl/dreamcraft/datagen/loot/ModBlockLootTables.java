package com.merl.dreamcraft.datagen.loot;

import com.merl.dreamcraft.registry.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.DREAMCATCHER.get());
        this.dropSelf(ModBlocks.HOLDER.get());
        this.dropSelf(ModBlocks.STONE_SEPARATOR.get());
        this.dropSelf(ModBlocks.DRYING_TABLE.get());
        this.dropSelf(ModBlocks.CORTEX_BLOCK.get());
        this.dropSelf(ModBlocks.CORTEX_BRICK.get());
        this.dropSelf(ModBlocks.DREAMING_FLOWER.get());
        this.dropSelf(ModBlocks.DREAM_SAND_BLOCK.get());


        this.dropSelf(ModBlocks.ALUCINOR_STRIPPED_LOG.get());
        this.dropSelf(ModBlocks.ALUCINOR_LOG.get());
        this.dropSelf(ModBlocks.ALUCINOR_SAPLING.get());
        this.dropSelf(ModBlocks.ALUCINOR_PLANKS.get());
        this.dropSelf(ModBlocks.SUN_BLOCK.get());
        this.dropSelf(ModBlocks.MOON_BLOCK.get());
        this.dropSelf(ModBlocks.CENTRAL_HOLDER.get());





        this.add(ModBlocks.ALUCINOR_LEAVES.get(), block -> createLeavesDrops(ModBlocks.ALUCINOR_LEAVES.get(), ModBlocks.DREAMING_FLOWER.get(), 50F));

    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}
