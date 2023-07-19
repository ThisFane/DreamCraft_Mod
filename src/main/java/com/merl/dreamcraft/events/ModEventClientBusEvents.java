package com.merl.dreamcraft.events;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.blocks.entity.CentralHolderRenderer;
import com.merl.dreamcraft.blocks.entity.HolderRenderer;
import com.merl.dreamcraft.particle.ModParticles;
import com.merl.dreamcraft.particle.TestParticles;
import com.merl.dreamcraft.registry.ModBlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = DreamCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent registerParticleProvidersEvent){
        registerParticleProvidersEvent.registerSpriteSet(ModParticles.TEST_PARTICLES.get(), TestParticles.Provider::new);
    }
    
    @SubscribeEvent
    public static void registerBer(EntityRenderersEvent.@NotNull RegisterRenderers registerEvent){
        registerEvent.registerBlockEntityRenderer(ModBlockEntity.HOLDER_BLOCK_ENTITY.get(), HolderRenderer::new);
        registerEvent.registerBlockEntityRenderer(ModBlockEntity.CENTRAL_HOLDER_BLOCK_ENTITY.get(), CentralHolderRenderer::new);
    }
    
    
    
}
