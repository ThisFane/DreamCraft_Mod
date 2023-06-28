package com.merl.dreamcraft.registry;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.blocks.entity.DreamcatcherBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DreamCraft.MODID);

    public static final RegistryObject<BlockEntityType<DreamcatcherBlockEntity>> DREAMCADREAMCATCHER_BLOCK_ENTITY = BLOCK_ENTITIES.register("dreamcatcher", () -> BlockEntityType.Builder.of(DreamcatcherBlockEntity::new, ModBlocks.DREAMCATCHER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }




}
