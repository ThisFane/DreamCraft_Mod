package com.merl.dreamcraft.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;


public class DreamEffect extends MobEffect {
    public DreamEffect(MobEffectCategory mobEffectCategory, int color){super(mobEffectCategory, color);}


    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier){

        if(livingEntity.getType() == EntityType.PLAYER){

        }

        /*
        if (livingEntity.isSleeping()){
            if (livingEntity.getLevel().dimension().equals(Level.OVERWORLD)){
                BlockPos pos = livingEntity.getOnPos();
                BlockState blockState = livingEntity.getBlockStateOn();
                ResourceKey<Level> resourcekey = livingEntity.getLevel().dimension() == Level.END ? Level.OVERWORLD : Level.END;
                ServerLevel serverlevel = ((ServerLevel) livingEntity.getLevel()).getServer().getLevel(resourcekey);
                if (serverlevel == null) {
                    return;
                }
                livingEntity.dismountTo(livingEntity.position().x,livingEntity.position().z,livingEntity.position().y);
                livingEntity.changeDimension(serverlevel);
                }

        }*/
        super.applyEffectTick(livingEntity, amplifier);
    }


    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }



}
