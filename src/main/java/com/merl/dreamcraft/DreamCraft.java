package com.merl.dreamcraft;

import com.merl.dreamcraft.blocks.entity.ModBlockEntity;
import com.merl.dreamcraft.effect.ModEffects;
import com.merl.dreamcraft.items.DreamPickAxeItem;
import com.merl.dreamcraft.registry.ModBlockEntities;
import com.merl.dreamcraft.registry.ModBlocks;
import com.merl.dreamcraft.registry.ModCreativeModeTabs;
import com.merl.dreamcraft.registry.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(DreamCraft.MODID)
public class DreamCraft
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "dreamcraft";
    public static final String RESOURCE_PREFIX = MODID + ":";

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace


    public DreamCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEffects.register(modEventBus);
        ModCreativeModeTabs.C_MOD_TABS.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModBlockEntity.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(DreamPickAxeItem.class);
        // Register the item to a creative tab

    }

    private void commonSetup(final FMLCommonSetupEvent event) {


    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
    }




    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
