package com.merl.dreamcraft.particle;

import com.merl.dreamcraft.DreamCraft;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPE_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, DreamCraft.MODID);


    public static final RegistryObject<SimpleParticleType> TEST_PARTICLES = PARTICLE_TYPE_DEFERRED_REGISTER.register("test_particles",() -> new SimpleParticleType(true));
    
    public static void register(IEventBus eventBus){
        PARTICLE_TYPE_DEFERRED_REGISTER.register(eventBus);
    }

}
