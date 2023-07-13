package com.merl.dreamcraft.items;


import com.merl.dreamcraft.registry.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SunItem extends Item {

    public SunItem(Item.Properties pProperties) {
        super(pProperties);
    }
 /*

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.GENERIC_BURN, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            SunProjectile sunProjectile = new SunProjectile(pLevel, pPlayer);
            sunProjectile.setItem(new ItemStack(ModItems.SUN.get()));
            sunProjectile.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(sunProjectile);
        }


        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

     */
}
