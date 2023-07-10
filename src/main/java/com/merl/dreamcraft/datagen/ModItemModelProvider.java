package com.merl.dreamcraft.datagen;

import com.merl.dreamcraft.DreamCraft;
import com.merl.dreamcraft.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DreamCraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    simpleItem(ModItems.AMETHYST_RUNE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),new ResourceLocation("item/generated")).texture("layer0",new ResourceLocation(DreamCraft.MODID, "item/" + item.getId().getPath()));
    }


}
