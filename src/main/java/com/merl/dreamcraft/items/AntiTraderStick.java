package com.merl.dreamcraft.items;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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



}
