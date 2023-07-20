package com.merl.dreamcraft.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class AlucinorLeavesBlock extends LeavesBlock {
    
    public AlucinorLeavesBlock(BlockBehaviour.Properties p_273704_) {
        super(p_273704_);
    }
    
    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles).
     */
    public void animateTick(BlockState blockState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(blockState, pLevel, pPos, pRandom);
        if (pRandom.nextInt(3) == 0) {
            BlockPos blockpos = pPos.below();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (!isFaceFull(blockstate.getCollisionShape(pLevel, blockpos), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(pLevel, pPos, pRandom, ParticleTypes.ENCHANT);
            }
        }
    }
}

