package com.merl.dreamcraft.registry;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.blocks.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DreamCraft.MODID);

    public static final RegistryObject<Block> DREAMCATCHER = registerBlock("dreamcatcher", () -> new DreamcatcherBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> HOLDER = registerBlock("holder", () -> new HolderBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().requiresCorrectToolForDrops().strength(5F)));
    public static final RegistryObject<Block> CENTRAL_HOLDER = registerBlock("central_holder", () -> new CentralHolderBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().requiresCorrectToolForDrops().strength(5F)));
    
    
    
    public static final RegistryObject<Block> STONE_SEPARATOR = registerBlock("stone_separator", () -> new StoneSeparatorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DRYING_TABLE = registerBlock("drying_tables", () -> new DryingTableBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORTEX_BLOCK = registerBlock("cortex_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CORTEX_BRICK = registerBlock("cortex_brick", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DREAMING_FLOWER = registerBlock("dreaming_flower", () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));



    public static final RegistryObject<Block> DREAM_SAND_BLOCK = registerBlock("dream_sand_block", () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND).requiresCorrectToolForDrops()));


    //Plants
    public static final RegistryObject<Block> SOY_PLANT = registerBlockItem("soy_plant", () -> new SoyCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noLootTable()));
    public static final RegistryObject<Block> ALUCINOR_LEAVES = registerBlock("alucinor_leaves", () -> new AlucinorLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.AZALEA_LEAVES).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALUCINOR_LOG = registerBlock("alucinor_log", () -> new LogBlock(BlockBehaviour.Properties.copy((Blocks.OAK_LOG))));
    public static final RegistryObject<Block> ALUCINOR_STRIPPED_LOG = registerBlock("alucinor_stripped_log", () -> new LogBlock(BlockBehaviour.Properties.copy((Blocks.OAK_LOG))));
    public static final RegistryObject<Block> ALUCINOR_SAPLING = registerBlock("alucinor_sapling", () -> new SaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ALUCINOR_PLANKS = registerBlock("alucinor_planks", () -> new Block(BlockBehaviour.Properties.copy((Blocks.OAK_PLANKS))));


    public static final RegistryObject<Block> SUN_BLOCK = registerBlock("sun_block", () -> new StellarBlock(BlockBehaviour.Properties.copy((Blocks.OAK_PLANKS)).noOcclusion()));
    public static final RegistryObject<Block> MOON_BLOCK = registerBlock("moon_block", () -> new StellarBlock(BlockBehaviour.Properties.copy((Blocks.OAK_PLANKS)).noOcclusion()));






    public static void registerBlock(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
