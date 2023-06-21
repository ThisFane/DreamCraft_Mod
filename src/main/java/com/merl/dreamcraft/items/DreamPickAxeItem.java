package com.merl.dreamcraft.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;


public class DreamPickAxeItem extends PickaxeItem {
    public DreamPickAxeItem(Tier tier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(tier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }



    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState blockState, BlockPos blockPos, LivingEntity livingEntity) {
        if (!level.isClientSide && blockState.getDestroySpeed(level, blockPos) != 0.0F) {
            itemStack.hurtAndBreak(1, livingEntity, (p_40992_) -> { p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);});


            HitResult pick = livingEntity.pick(20D, 1F, false);
            Direction direction = ((BlockHitResult) pick).getDirection();


            BlockPos blockup = blockPos.relative(Direction.UP);
            BlockPos blockdown = blockPos.relative(Direction.DOWN);
            BlockPos blockeast = blockPos.relative(Direction.EAST);
            BlockPos blockwest = blockPos.relative(Direction.WEST);
            BlockPos blocknorth = blockPos.relative(Direction.NORTH);
            BlockPos blocksouth = blockPos.relative(Direction.SOUTH);


            BlockPos[] mineBlockPosArr = switch (direction){
                case NORTH, SOUTH -> new BlockPos[]{blockPos, blockup, blockdown, blockeast, blockwest, blockup.east(), blockdown.east(), blockup.west(), blockdown.west()};
                case WEST, EAST -> new BlockPos[]{blockPos, blockup, blockdown, blocknorth, blocksouth, blockup.north(), blockdown.north(), blockup.south(), blockdown.south()};
                case UP, DOWN -> new BlockPos[]{blockPos, blockeast, blockwest, blocknorth, blocksouth, blocknorth.east(), blocksouth.east(), blocknorth.west(), blocksouth.west()};
            };
            for(BlockPos mineBlockPos : mineBlockPosArr) {

                if (!canDestroy(level.getBlockState(mineBlockPos), level, mineBlockPos)) {
                    continue;
                }
                if (level.getBlockState(mineBlockPos).is(BlockTags.MINEABLE_WITH_PICKAXE)) {
                    level.destroyBlock(mineBlockPos, true, livingEntity);
                    if (mineBlockPos != blockPos){
                        itemStack.setDamageValue(itemStack.getDamageValue() + 1);
                    }
                }
            }


        }
        return true;
    }

    public boolean canDestroy(BlockState blockState, Level level, BlockPos mineBlockPos){
        if(blockState.getDestroySpeed(level, mineBlockPos) <= 0){
            return false;
        }
        return level.getBlockEntity(mineBlockPos) == null;
    }


}
