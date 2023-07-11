package com.merl.dreamcraft.blocks.entity;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;

public class BeamBlock extends Block implements BeaconBeamBlock {
    public BeamBlock(Properties pProperties) {
        super(pProperties);
    }

    
    @Override
    public DyeColor getColor() {
        return null;
    }
}
