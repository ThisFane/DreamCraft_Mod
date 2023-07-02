package com.merl.dreamcraft.blocks;

import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractSeparator extends BaseEntityBlock {
    protected AbstractSeparator(Properties pProperties) {
        super(pProperties);
    }



    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }



}
