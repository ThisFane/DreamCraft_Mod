package com.merl.dreamcraft.datagen;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DreamCraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Blocks
        blockWithItem(ModBlocks.DREAM_SAND_BLOCK);
        blockWithItem(ModBlocks.ALUCINOR_PLANKS);

        logBlock((RotatedPillarBlock) ModBlocks.ALUCINOR_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.ALUCINOR_STRIPPED_LOG.get());


        saplingBlock(ModBlocks.ALUCINOR_SAPLING);

        //Items
        blockItem(ModBlocks.ALUCINOR_STRIPPED_LOG);
        blockItem(ModBlocks.ALUCINOR_LOG);
        blockItem(ModBlocks.ALUCINOR_SAPLING);


    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("dreamcraft:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("dreamcraft:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
}
