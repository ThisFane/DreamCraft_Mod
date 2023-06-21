package com.merl.dreamcraft.items;



import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static DeferredRegister<CreativeModeTab> C_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DreamCraft.MODID);

    public static RegistryObject<CreativeModeTab> DREAMCRAFT_TAB = C_MOD_TABS.register("dreamcrafttab",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + DreamCraft.MODID + "dreamcraft")).icon(
                    () -> new ItemStack(ModItems.DREAMSAND.get())).displayItems((enabledFeatures, entries) -> {
                entries.accept(ModItems.DREAMSTONE.get());
                entries.accept(ModBlocks.DREAM_SAND_BLOCK.get());
                entries.accept(ModItems.DREAMSAND.get());
                entries.accept(ModItems.ANGER.get());
                entries.accept(ModItems.SADNESS.get());
                entries.accept(ModItems.FEAR.get());
                entries.accept(ModItems.DISGUST.get());
                entries.accept(ModItems.HAPPINESS.get());
                entries.accept(ModItems.SURPRISE.get());
                entries.accept(ModItems.LIFE_ESSENCE.get());
                entries.accept(ModItems.SUN.get());
                entries.accept(ModItems.MOON.get());


                entries.accept(ModItems.DREAM_PICK.get());
                entries.accept(ModItems.SUN_STAFF.get());
                entries.accept(ModItems.WIND_WAND.get());
                entries.accept(ModItems.SWORD_OF_RAGE.get());

                entries.accept(ModItems.FRESH_SOY_BEANS.get());
                entries.accept(ModItems.DRIED_SOY_BEANS.get());
                entries.accept(ModBlocks.DREAMING_FLOWER.get());

                entries.accept(ModBlocks.STELLAR_COLLECTOR.get());
                entries.accept(ModBlocks.CORTEX_BLOCK.get());
                entries.accept(ModBlocks.CORTEX_BRICK.get());
                entries.accept(ModBlocks.DREAMCATCHER.get());
                entries.accept(ModBlocks.DRYING_TABLE.get());
                entries.accept(ModBlocks.SEPARATOR.get());

    }).build());



}
