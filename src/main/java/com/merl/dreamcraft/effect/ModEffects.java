package com.merl.dreamcraft.effect;

import com.merl.dreamcraft.DreamCraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DreamCraft.MODID);


    public static final RegistryObject<MobEffect> DREAM = MOD_EFFECTS.register("dream", () -> new DreamEffect(MobEffectCategory.NEUTRAL, 9021902));


    public static void register(IEventBus eventBus){
        MOD_EFFECTS.register(eventBus);
    }

}
