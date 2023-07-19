package com.merl.dreamcraft.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class WaterWandItem extends Item {
    public WaterWandItem(Properties pProperties) {
        super(pProperties);
    }

    private boolean staffFlight = false;
    float speed = 1;




    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotId, boolean isSelected) {




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
    
    }


    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.getCooldowns().addCooldown(this,5);
        
        
     
    
        if(Durability() - itemstack.getDamageValue() >= 2) {
            itemstack.hurtAndBreak(1, pPlayer, (playerentity) -> {
                playerentity.broadcastBreakEvent(pHand);
            });
    
    
        }
        return InteractionResultHolder.success(itemstack);
        
    }



    public static int Durability(){
        return 128;
    }

    

}