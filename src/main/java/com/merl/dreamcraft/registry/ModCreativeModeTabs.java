package com.merl.dreamcraft.registry;


import com.merl.dreamcraft.DreamCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static DeferredRegister<CreativeModeTab> C_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DreamCraft.MODID);

    public static RegistryObject<CreativeModeTab> DREAMCRAFT_TAB = C_MOD_TABS.register("dreamcraft_tab",
            () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + DreamCraft.MODID + "dreamcraft")).icon(
                    () -> new ItemStack(ModItems.DREAMSAND.get())).displayItems((enabledFeatures, entries) -> {
                entries.accept(ModItems.DREAMSTONE.get());
                entries.accept(ModItems.LIVING_INGOT.get());
                entries.accept(ModItems.DREAMSAND.get());
                entries.accept(ModItems.ANGER.get());
                entries.accept(ModItems.SADNESS.get());
                entries.accept(ModItems.FEAR.get());
                entries.accept(ModItems.DISGUST.get());
                entries.accept(ModItems.HAPPINESS.get());
                entries.accept(ModItems.SURPRISE.get());
                entries.accept(ModItems.LIFE_ESSENCE.get());
                entries.accept(ModItems.AIR_ESSENCE.get());
                entries.accept(ModItems.SUN.get());
                entries.accept(ModItems.MOON.get());
                entries.accept(ModItems.AMETHYST_SCRAPS.get());


                entries.accept(ModItems.AMETHYST_RUNE.get());
                entries.accept(ModItems.LAPIS_LAZULI_RUNE.get());
                entries.accept(ModItems.REDSTONE_RUNE.get());
                entries.accept(ModItems.ENDER_RUNE.get());
                entries.accept(ModItems.EMERALD_RUNE.get());
                entries.accept(ModItems.DIAMOND_RUNE.get());
                entries.accept(ModItems.CORRUPTED_RUNE.get());



                entries.accept(ModItems.DREAM_PICK.get());
                entries.accept(ModItems.SUN_STAFF.get());
                entries.accept(ModItems.WIND_WAND.get());
                entries.accept(ModItems.SWORD_OF_RAGE.get());
                entries.accept(ModItems.AMETHYST_SWORD.get());
                entries.accept(ModItems.ANTITRADERWAND.get());

                entries.accept(ModItems.FRESH_SOY_BEANS.get());
                entries.accept(ModItems.DRIED_SOY_BEANS.get());
                entries.accept(ModBlocks.DREAMING_FLOWER.get());

                entries.accept(ModBlocks.DREAM_SAND_BLOCK.get());
                entries.accept(ModBlocks.CORTEX_BLOCK.get());
                entries.accept(ModBlocks.CORTEX_BRICK.get());
                entries.accept(ModBlocks.DREAMCATCHER.get());
                entries.accept(ModBlocks.DRYING_TABLE.get());
                entries.accept(ModBlocks.STONE_SEPARATOR.get());
                entries.accept(ModBlocks.HOLDER.get());
                entries.accept(ModBlocks.ALUCINOR_LEAVES.get());

    }).build());



}
