package com.merl.dreamcraft.blocks;

import com.merl.dreamcraft.blocks.entity.CentralHolderBlockEntity;
import com.merl.dreamcraft.registry.ModBlockEntity;
import com.merl.dreamcraft.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CentralHolderBlock extends BaseEntityBlock {
    public CentralHolderBlock(Properties pProperties) {
        super(pProperties);
        
    }
    
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 13, 16);
    private static final int INPUTSLOT = 0;
    
    
    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    
    
    // Entity
    
    
    
    
    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof CentralHolderBlockEntity) {
                ((CentralHolderBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }
    
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity holder = pLevel.getBlockEntity(pPos);
        
        if(!pPlayer.isHolding(ModBlocks.HOLDER.get().asItem()) && !pPlayer.isHolding(ModBlocks.CENTRAL_HOLDER.get().asItem())){
            if (holder instanceof CentralHolderBlockEntity centralHolderBlockEntity){
                if (centralHolderBlockEntity.isEmpty()) {
                    addItem(pLevel, pPos, pPlayer, centralHolderBlockEntity, pPlayer.getItemInHand(pHand));
                }else{
                    removeItem(pLevel,pPlayer,centralHolderBlockEntity);
                }
            }
        }
        
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }
    
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CentralHolderBlockEntity(pPos, pState);
    }


    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
       if (pLevel.isClientSide){
           return null;
       }
       
        return createTickerHelper(pBlockEntityType, ModBlockEntity.CENTRAL_HOLDER_BLOCK_ENTITY.get(), (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1,pPos,pState1));
    }
    
    public static void addItem(Level pLevel, BlockPos pPos, Player pPlayer,CentralHolderBlockEntity pBlockEntity, ItemStack itemStack){
            pBlockEntity.setItem(INPUTSLOT, itemStack.split(1));
    }
    
    public static void removeItem(Level pLevel,Player pPlayer, CentralHolderBlockEntity pBlockEntity){
            ItemStack itemStack = pBlockEntity.removeItem(INPUTSLOT, 1);
            if (pPlayer.getInventory().add(itemStack)){
                pPlayer.drop(itemStack, false);
        }
    }
    
    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        
        super.tick(pState, pLevel, pPos, pRandom);
    }
}
