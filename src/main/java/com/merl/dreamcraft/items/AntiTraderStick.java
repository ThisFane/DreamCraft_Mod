package com.merl.dreamcraft.items;


import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class AntiTraderStick extends Item {
    public AntiTraderStick(Properties pProperties) {
        super(pProperties);
    }

    Vec3 target = new Vec3(0,0,0);

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slot, boolean selected) {
        AABB areaOfEffect = AABB.ofSize(entity.getOnPos().getCenter(), 100, 100, 100 );
        List<LivingEntity> nearByEntities = level.getEntitiesOfClass(LivingEntity.class, areaOfEffect);
        for (LivingEntity nearByEntity : nearByEntities) {
            if(nearByEntity.getType() == EntityType.WANDERING_TRADER) {
                target = new Vec3(nearByEntity.getBlockX(), nearByEntity.getBlockY(), nearByEntity.getBlockZ());
                nearByEntity.kill();
            }
        }


        super.inventoryTick(itemStack, level, entity, slot, selected);
    }


}
