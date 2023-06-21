package com.merl.dreamcraft.items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class DreamstoneItem extends Item {
    int timer = 0;

    public DreamstoneItem(Properties p_41383_) {
        super(p_41383_);
    }



    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {

        if (timer < 0){
            moveplayer(pEntity);
            timer = 10;
        }else {
            timer--;
        }


    }



    public void moveplayer(Entity pEntity){
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();

        Vec3 movment = new Vec3(r1.nextFloat(-0.5F, 0.5F), 0,r2.nextFloat(-0.5F, 0.5F));
        System.out.println(r1.nextFloat(0.0F, 0.5F));
        pEntity.addDeltaMovement(movment);
    }


}
