package com.merl.dreamcraft.blocks.entity;


import com.merl.dreamcraft.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

import static net.minecraft.world.level.block.BedBlock.OCCUPIED;


public class DreamcatcherBlockEntity extends BlockEntity {

    private static boolean DayReset = true;

    public DreamcatcherBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.DREAMCADREAMCATCHER_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, DreamcatcherBlockEntity entity) {
        if(level.isClientSide()) {
            return;
        }

        System.out.println(level.getDayTime());
        spawnSand(blockPos, level);
        timeCheck(level);

    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
    }

    public static void timeCheck(Level level){
        if(level.isDay()){
        DayReset = true;
        }
    }


    public static void spawnSand(BlockPos blockPos, Level level){
        if(level.getBlockState(blockPos.below()).is(BlockTags.BEDS)) {
            BlockState bed = level.getBlockState(blockPos.below());
            Player nearestplayer = level.getNearestPlayer(TargetingConditions.forNonCombat(), blockPos.below().getX(), blockPos.below().getY(), blockPos.below().getZ());
            BlockEntity bedEntity = level.getBlockEntity(blockPos.below());



            if(DayReset){
                if (bed.getValue(OCCUPIED)) {
                    ItemEntity item = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.DREAMSAND.get()));
                    level.addFreshEntity(item);
                    DayReset = false;
                }
            }
        }
    }
}
