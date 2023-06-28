package com.merl.dreamcraft.blocks;

import com.merl.dreamcraft.registry.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class SoyCropBlock extends CropBlock {
    public static final IntegerProperty Age =  IntegerProperty.create("age", 0, 3);

    public SoyCropBlock(Properties properties) {
        super(properties);
    }

    protected ItemLike getBaseSeedId() {
        return ModItems.FRESH_SOY_BEANS.get();
    }


    protected IntegerProperty getAgeProperty() {
        return AGE;
    }


    public int getMaxAge() {
        return 3;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }


}
