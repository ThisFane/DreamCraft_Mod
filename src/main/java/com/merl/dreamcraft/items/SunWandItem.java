package com.merl.dreamcraft.items;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;


public class SunWandItem extends Item {
    public SunWandItem(Properties pProperties) {
        super(pProperties);
    }

    private boolean staffFlight = false;
    float speed = 1;




    public void inventoryTick(ItemStack pStack, Level pLevel, Entity entity, int pSlotId, boolean pIsSelected) {



    }


    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level pLevel, List<Component> components, TooltipFlag flag) {
        components.add(Component.literal("A"));
        if(Screen.hasShiftDown()){
            components.add(Component.literal("B"));
            components.add(Component.literal("C"));
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




        return InteractionResultHolder.success(itemstack);

    }



    public static int Durability(){
        return 128;
    }



    public void spawnPaticles(Level pLevel, Player pPlayer, InteractionHand pHand) {
        Vec3 vec3 = pPlayer.getViewVector(1).multiply(new Vec3(1.5,1.5,1.5));
        Random random = new Random();


        float f7 = pPlayer.getYRot();
        float f = pPlayer.getXRot();
        float f1 = -Mth.sin(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
        float f2 = -Mth.sin(f * ((float) Math.PI / 180F));
        float f3 = Mth.cos(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));


        for (int j = 0; j < 100; ++j) {
            pLevel.addParticle(ParticleTypes.FLAME, pPlayer.getX() /*+ vec3.x*/, pPlayer.getY()+1.5, pPlayer.getZ() /*+ vec3.z*/, (double) f1 + random.nextDouble(-0.5,0.5), (double) f2 + random.nextDouble(-0.5,0.5), (double) f3+ random.nextDouble(-0.5,0.5));
        }
    }




}