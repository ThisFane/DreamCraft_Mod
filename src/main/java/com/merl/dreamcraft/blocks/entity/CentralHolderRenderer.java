package com.merl.dreamcraft.blocks.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class CentralHolderRenderer implements BlockEntityRenderer<CentralHolderBlockEntity> {
    
    public List<Item> blockLikeList = List.of(Blocks.BREWING_STAND.asItem(), Blocks.REPEATER.asItem(), Blocks.HOPPER.asItem(), Blocks.CAULDRON.asItem(), Blocks.BELL.asItem(),Blocks.CANDLE.asItem(),Blocks.DRIPSTONE_BLOCK.asItem(),Blocks.AMETHYST_CLUSTER.asItem(),Blocks.JUNGLE_SAPLING.asItem());
    
    public CentralHolderRenderer(BlockEntityRendererProvider.Context context){
    
    }
    
    @Override
    public void render(CentralHolderBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = pBlockEntity.getRenderStack();
    
       
        if (itemStack.getItem() instanceof BlockItem && !(blockLikeList.contains(itemStack.getItem()))){
            pPoseStack.pushPose();
            pPoseStack.translate(0.5f, 0.85f, 0.5f);
            pPoseStack.scale(0.9f, 0.9f, 0.9f);
            
        }
        
        if(blockLikeList.contains(itemStack.getItem())){
            pPoseStack.pushPose();
            pPoseStack.translate(0.5f, 0.65f, 0.5f);
            pPoseStack.scale(0.6f, 1.0f, 0.6f);
            pPoseStack.mulPose(Axis.XP.rotationDegrees(270));
        }
        
        if (!(itemStack.getItem() instanceof BlockItem)){
            pPoseStack.pushPose();
            pPoseStack.translate(0.5f, 0.65f, 0.5f);
            pPoseStack.scale(0.6f, 1.0f, 0.6f);
            pPoseStack.mulPose(Axis.XP.rotationDegrees(270));
        }
        
     
        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pBlockEntity.getLevel(), 1); pPoseStack.popPose();
    }
    
    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
    
}
