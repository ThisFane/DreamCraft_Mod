package com.merl.dreamcraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class StoneSeparatorBlock extends AbstractSeparator{
    public StoneSeparatorBlock(Properties pProperties) {
        super(pProperties);
    }





    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }



}
