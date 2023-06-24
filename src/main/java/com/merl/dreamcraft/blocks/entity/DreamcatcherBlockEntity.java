package com.merl.dreamcraft.blocks.entity;


import com.merl.dreamcraft.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.EntityGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static net.minecraft.commands.arguments.EntityArgument.getEntities;
import static net.minecraft.world.level.block.BedBlock.OCCUPIED;


public class DreamcatcherBlockEntity extends BlockEntity {


    private static List<LivingEntity> entityMem = new ArrayList<>();
    private static boolean DayReset = true;

    public DreamcatcherBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.DREAMCADREAMCATCHER_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, DreamcatcherBlockEntity entity) {
        if(level.isClientSide()) {
            return;
        }

        //System.out.println(level.getDayTime());
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

    public static void timeCheck(Level level) {
        //DayReset = level.isDay() || DayReset;
        if(level.isDay()){
            entityMem.clear();
        }
    }


    public static void spawnSand(BlockPos blockPos, Level level){
        if(level.getBlockState(blockPos.below()).is(BlockTags.BEDS)) {
            BlockState bed = level.getBlockState(blockPos.below());
            Player nearestplayer = level.getNearestPlayer(TargetingConditions.forNonCombat(), blockPos.below().getX(), blockPos.below().getY(), blockPos.below().getZ());
            BlockEntity bedBlockEntity = level.getBlockEntity(blockPos.below());
            List<LivingEntity> nearByEntities = level.getEntitiesOfClass(LivingEntity.class, bedBlockEntity.getRenderBoundingBox().move(0,0.5,0));



            for(int x = 0; x < nearByEntities.size(); x++){
                if(nearByEntities.get(x).isSleeping()){
                    if(!entityMem.contains(nearByEntities.get(x))){
                        ItemEntity item = new ItemEntity(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.DREAMSAND.get()));
                        level.addFreshEntity(item);
                        entityMem.add(nearByEntities.get(x));
                    }
                }
            }
        }
    }
}
