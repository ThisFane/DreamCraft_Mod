package com.merl.dreamcraft.entity;

import com.merl.dreamcraft.items.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SunProjectile extends ThrowableItemProjectile {
    public SunProjectile(EntityType<? extends Snowball> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

     private int lifetime = 0;


    @Override
    protected @NotNull Item getDefaultItem() {
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

        setNoGravity(true);
        mobGravity(level());

        //System.out.println("tick");
        if(getDeltaMovement().x <= 0.1 && getDeltaMovement().y <= 0.1 && getDeltaMovement().z <= 0.1 ){
            setDeltaMovement(0,0,0);




        }else {
            setDeltaMovement(getDeltaMovement().multiply(0.9, 0.9, 0.9));
        }

        super.tick();
    }


    public void mobGravity(Level level){
        AABB areaOfEffect = getBoundingBoxForCulling().expandTowards(1000,1000,1000);
        List<LivingEntity> nearByEntities = level.getEntitiesOfClass(LivingEntity.class, areaOfEffect);

        for (LivingEntity nearByEntity : nearByEntities) {
            if(!nearByEntity.getUUID().equals(this.getUUID())) {
                if(!(nearByEntity.getType() == EntityType.SNOWBALL)) {
                    nearByEntity.addDeltaMovement(new Vec3(0, 0, 1));
                }
            }
        }

    }




}
