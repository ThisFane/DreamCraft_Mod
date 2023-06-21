package com.merl.dreamcraft.items;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.blocks.ModBlocks;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DreamCraft.MODID);

    public static RegistryObject<Item> DREAMSTONE = ITEMS.register("dreamstone", () -> new DreamstoneItem(new Item.Properties().rarity(Rarity.EPIC)));
    public static RegistryObject<Item> DREAMSAND = ITEMS.register("dreamsand", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));

    //Emotions form sand
    public static RegistryObject<Item> ANGER = ITEMS.register("anger", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> SADNESS = ITEMS.register("sadness", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> FEAR = ITEMS.register("fear", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> DISGUST = ITEMS.register("disgust", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> HAPPINESS = ITEMS.register("happiness", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> SURPRISE = ITEMS.register("surprise", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> LIFE_ESSENCE = ITEMS.register("life_essence", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));


    public static RegistryObject<Item> SUN = ITEMS.register("sun", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.EPIC)));
    public static RegistryObject<Item> MOON = ITEMS.register("moon", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.EPIC)));


    //Tools
    public static RegistryObject<Item> SWORD_OF_RAGE = ITEMS.register("sword_of_rage", () -> new SwordOfRageItem(Tiers.DIAMOND, 10, 5f, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WIND_WAND = ITEMS.register("wind_wand", () -> new WindWandItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).durability(WindWandItem.Durability())));
    public static final RegistryObject<Item> SUN_STAFF = ITEMS.register("sun_staff", () -> new SunWandItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).durability(WindWandItem.Durability())));
    public static RegistryObject<Item> DREAM_PICK = ITEMS.register("dream_pick", () -> new DreamPickAxeItem(Tiers.DIAMOND, 1, 2.8f, new Item.Properties().stacksTo(1)));


    //Crops
    public static final RegistryObject<Item> FRESH_SOY_BEANS = ITEMS.register("fresh_soy_beans", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> DRIED_SOY_BEANS = ITEMS.register("dried_soy_beans", () -> new ItemNameBlockItem(ModBlocks.SOY_PLANT.get() , new Item.Properties().rarity(Rarity.COMMON)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }



}
