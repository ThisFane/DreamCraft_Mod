package com.merl.dreamcraft.items;


import com.merl.dreamcraft.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AntiTraderStick extends Item {
    public AntiTraderStick(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, Level level, Entity entity, int slot, boolean selected) {

        AABB areaOfEffect = AABB.ofSize(entity.getOnPos().getCenter(), 100, 100, 100 );
        List<LivingEntity> nearByEntities = level.getEntitiesOfClass(LivingEntity.class, areaOfEffect);
        
        
        for (LivingEntity nearByEntity : nearByEntities) {
            if(nearByEntity.getType() == EntityType.WANDERING_TRADER) {
                nearByEntity.kill();
            }
        }


        super.inventoryTick(itemStack, level, entity, slot, selected);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide){
            BlockPos positionClicked = pContext.getClickedPos();
            BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below());
            spawnFoundParticles(pContext, positionClicked, blockState);
            }
        
        return InteractionResult.SUCCESS;
        
    }
    
    private void spawnFoundParticles(UseOnContext pContext, BlockPos positionClicked, BlockState blockState) {
        for(int i = 0; i < 200; i++) {
            ServerLevel level = (ServerLevel) pContext.getLevel();
            
            level.sendParticles(ModParticles.TEST_PARTICLES.get(),
                    positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d, 1000,
                    Math.cos(i * 18) * 0.15d, 0.15d, Math.sin(i * 18) * 0.15d, 0.1);
        }
    }


}
