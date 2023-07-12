package com.merl.dreamcraft.registry;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.blocks.entity.DreamcatcherBlockEntity;
import com.merl.dreamcraft.blocks.entity.HolderBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DreamCraft.MODID);
    
    
    public static final RegistryObject<BlockEntityType<HolderBlockEntity>> HOLDER_BLOCK_ENTITY = BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register("holder_block_entity", () -> BlockEntityType.Builder.of(HolderBlockEntity::new, ModBlocks.HOLDER.get()).build(null));
    public static final RegistryObject<BlockEntityType<DreamcatcherBlockEntity>> DREAMCADREAMCATCHER_BLOCK_ENTITY = BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register("dreamcatcher", () -> BlockEntityType.Builder.of(DreamcatcherBlockEntity::new, ModBlocks.DREAMCATCHER.get()).build(null));
    
    
    
    public static void register(IEventBus iEventBus){
        BLOCK_ENTITY_TYPE_DEFERRED_REGISTER.register(iEventBus);
    }



}

