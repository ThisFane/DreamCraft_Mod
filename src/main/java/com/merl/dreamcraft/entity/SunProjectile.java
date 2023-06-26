package com.merl.dreamcraft.entity;

import com.merl.dreamcraft.items.ModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SunProjectile extends ThrowableItemProjectile {
    public SunProjectile(EntityType<? extends Snowball> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

     private int lifetime = 0;


    @Override
    protected Item getDefaultItem() {
        return ModItems.SUN.get().asItem();
    }



    public SunProjectile(Level pLevel, LivingEntity pShooter) {
        super(EntityType.SNOWBALL, pShooter, pLevel);
    }

    public SunProjectile(Level pLevel, double pX, double pY, double pZ) {
        super(EntityType.SNOWBALL, pX, pY, pZ, pLevel);
    }


    @Override
    public void tick() {

        if(150 < lifetime){
            this.kill();
        }else {
            lifetime++;
        }


        System.out.println("tick");
        if(getDeltaMovement().x <= 0.4 && getDeltaMovement().y <= 0.4 && getDeltaMovement().z <= 0.4 ){
            setDeltaMovement(0,0,0);
            setNoGravity(true);



        }else {
            setDeltaMovement(getDeltaMovement().multiply(0.9, 0.9, 0.9));
        }

        super.tick();
    }







}
