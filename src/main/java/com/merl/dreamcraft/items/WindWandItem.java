package com.merl.dreamcraft.items;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;


public class WindWandItem extends Item {
    public WindWandItem(Properties pProperties) {
        super(pProperties);
    }

    private boolean staffFlight = false;
    float speed = 1;




    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotId, boolean isSelected) {

        float f7 = entity.getYRot();
        float f = entity.getXRot();
        float f1 = -Mth.sin(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
        float f2 = -Mth.sin(f * ((float) Math.PI / 180F));
        float f3 = Mth.cos(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));


        if(entity.onGround()){
            staffFlight = false;
        }

        if(staffFlight) {
            entity.fallDistance = 0F;
        }


    }


    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List<Component> components, TooltipFlag flag) {
        components.add(Component.literal("A soft breeze is leaking from this strange object"));
        if(Screen.hasShiftDown()){
            components.add(Component.literal("This wand channels the wind to let you fly."));
            components.add(Component.literal("It also protects from fall damage"));
        }else{
            components.add(Component.literal("Press SHIFT for more infos"));
        }
        super.appendHoverText(stack, pLevel, components, flag);
    }

    //This code shoots you like a TridentItem on use
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.getCooldowns().addCooldown(this,5);

        spawnPaticles(pLevel, pPlayer, pHand);

        if(Durability() - itemstack.getDamageValue() >= 2) {
            itemstack.hurtAndBreak(1, pPlayer, (playerentity) -> {
                playerentity.broadcastBreakEvent(pHand);
            });


            float f7 = pPlayer.getYRot();
            float f = pPlayer.getXRot();
            float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
            float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
            float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * ((float)Math.PI / 180F));
            float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
            float f5 = 3.0F * ((1.0F + (float)1) / 4.0F);
            f1 *= f5 / f4;
            f2 *= f5 / f4;
            f3 *= f5 / f4;
            pPlayer.push((double)f1 * 2 /* * bonus_speed(itemstack)*/ , (double)f2* 2 /* * bonus_speed(itemstack)*/, (double)f3 * 2 /* * bonus_speed(itemstack)*/);
            //pPlayer.startAutoSpinAttack(20);
            if (pPlayer.onGround()) {
                float f6 = 1.1999999F;
                pPlayer.move(MoverType.SELF, new Vec3(0.0D, (double)1.1999999F, 0.0D));

            }

        }
        staffFlight = true;
        return InteractionResultHolder.success(itemstack);

    }

/*
    public float bonus_speed(ItemStack itemStack){

        switch(getEnchantmentLevel(itemStack, ModEnchantments.WINDSPEED.get())) {
            case 1:
                speed = 1.5F;
                break;
            case 2:
                speed = 2F;
                break;
            case 3:
                speed = 2.5F;
                break;
        }
        return speed;
    }

*/

    public static int Durability(){
        return 128;
    }



    public void spawnPaticles(Level pLevel, Player pPlayer, InteractionHand pHand) {
        Vec3 vec3 = pPlayer.getViewVector(1).normalize();
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Random random = new Random();

        float f7 = pPlayer.getYRot();
        float f = pPlayer.getXRot();
        float f1 = -Mth.sin(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
        float f2 = -Mth.sin(f * ((float) Math.PI / 180F));
        float f3 = Mth.cos(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));


        for (int j = 0; j < 20; ++j) {
            pLevel.addParticle(ParticleTypes.SONIC_BOOM, pPlayer.getX(), pPlayer.getY()+1.5, pPlayer.getZ(), (double) f1, (double) f2, (double) f3);
        }
    }

}