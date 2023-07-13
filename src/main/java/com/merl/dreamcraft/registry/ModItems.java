package com.merl.dreamcraft.registry;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.items.*;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DreamCraft.MODID);

    public static RegistryObject<Item> DREAMSTONE = ITEMS.register("dreamstone", () -> new DreamstoneItem(new Item.Properties().rarity(Rarity.EPIC)));
    public static RegistryObject<Item> DREAMSAND = ITEMS.register("dreamsand", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> LIVING_INGOT = ITEMS.register("living_ingot", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.EPIC)));


    //Emotions form sand
    public static RegistryObject<Item> EARTH_ESSENCE = ITEMS.register("earth_essence", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> WATER_ESSENCE = ITEMS.register("water_essence", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> FIRE_ESSENCE = ITEMS.register("fire_essence", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> WIND_ESSENCE = ITEMS.register("wind_essence", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> VOID_ESSENCE = ITEMS.register("void_essence", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> LIFE_ESSENCE = ITEMS.register("life_essence", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));



    public static RegistryObject<Item> AMETHYST_SCRAPS = ITEMS.register("amethyst_scraps", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));



    public static RegistryObject<Item> AMETHYST_RUNE = ITEMS.register("amethyst_rune", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> CORRUPTED_RUNE = ITEMS.register("corrupted_rune", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> DIAMOND_RUNE = ITEMS.register("diamond_rune", () -> new DreamsandItem(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> EMERALD_RUNE = ITEMS.register("emerald_rune", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> ENDER_RUNE = ITEMS.register("ender_rune", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> LAPIS_LAZULI_RUNE = ITEMS.register("lapis_lazuli_rune", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static RegistryObject<Item> REDSTONE_RUNE = ITEMS.register("redstone_rune", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));




    //Tools
    public static RegistryObject<Item> SWORD_OF_RAGE = ITEMS.register("sword_of_rage", () -> new SwordOfRageItem(Tiers.DIAMOND, 10, 5f, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WIND_WAND = ITEMS.register("wind_wand", () -> new WindWandItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).durability(WindWandItem.Durability())));
    public static final RegistryObject<Item> WATER_WAND = ITEMS.register("water_wand", () -> new WaterWandItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).durability(WindWandItem.Durability())));
    
    public static final RegistryObject<Item> SUN_STAFF = ITEMS.register("sun_staff", () -> new SunWandItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).durability(WindWandItem.Durability())));
    public static RegistryObject<Item> DREAM_PICK = ITEMS.register("dream_pick", () -> new DreamPickAxeItem(Tiers.DIAMOND, 1, 2.8f, new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword", () -> new SwordItem(Tiers.DIAMOND, 8, 2.8f, new Item.Properties().stacksTo(1)));
    public static RegistryObject<Item> ANTITRADERWAND = ITEMS.register("anti_trader_wand", () -> new AntiTraderStick(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1)));



    //Crops
    public static final RegistryObject<Item> FRESH_SOY_BEANS = ITEMS.register("fresh_soy_beans", () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));
    public static final RegistryObject<Item> DRIED_SOY_BEANS = ITEMS.register("dried_soy_beans", () -> new ItemNameBlockItem(ModBlocks.SOY_PLANT.get() , new Item.Properties().rarity(Rarity.COMMON)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }



}
