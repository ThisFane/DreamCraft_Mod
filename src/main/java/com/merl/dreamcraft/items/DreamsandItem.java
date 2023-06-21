package com.merl.dreamcraft.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DreamsandItem extends Item {


    public DreamsandItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}
