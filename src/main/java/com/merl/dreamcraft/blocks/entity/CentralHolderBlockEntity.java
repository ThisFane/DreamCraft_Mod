package com.merl.dreamcraft.blocks.entity;

import com.merl.dreamcraft.registry.ModBlockEntity;
import com.merl.dreamcraft.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;

public class CentralHolderBlockEntity extends BlockEntity implements Container {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()){
                level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(),3);
            }
        }
    };
    
    private static final int INPUTSLOT = 0;
    
    private LazyOptional<IItemHandler> itemHandlerLazyOptional = LazyOptional.empty();
    
    protected final ContainerData containerData;
    private int craftingProgress = 0;
    private int maxCraftingProgress = 100;
    
    public CentralHolderBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntity.CENTRAL_HOLDER_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.containerData = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> CentralHolderBlockEntity.this.craftingProgress;
                    case 1 -> CentralHolderBlockEntity.this.maxCraftingProgress;
                    default -> 0;
                };
            }
    
            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0 -> CentralHolderBlockEntity.this.craftingProgress = pValue;
                    case 1 -> CentralHolderBlockEntity.this.maxCraftingProgress = pValue;
                };
            }
    
            @Override
            public int getCount() {
                return 2;
            }
        };
    }
    
    public ItemStack getRenderStack(){
        return itemStackHandler.getStackInSlot(INPUTSLOT);
    }
    
    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }
        
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    
    
    
    @Override
    public void onLoad() {
        super.onLoad();
        itemHandlerLazyOptional = LazyOptional.of(() -> itemStackHandler);
    }
    
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandlerLazyOptional.invalidate();
    }
    
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("c_holder_inventory",itemStackHandler.serializeNBT());
        super.saveAdditional(pTag);
    }
    
    @Override
    public void load(CompoundTag pTag) {
        itemStackHandler.deserializeNBT(pTag.getCompound("c_holder_inventory"));
        super.load(pTag);
    }
    
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
    
        if (itemStackHandler.getStackInSlot(INPUTSLOT).is(ModBlocks.SUN_BLOCK.get().asItem())) {
            pullEntities(pLevel, pPos);
        }
    
        countHolderInArea(pLevel, pPos, pState);
        
    }
    
    
    @Override
    public int getContainerSize() {
        return 64;
    }
    
    @Override
    public boolean isEmpty() {
        return itemStackHandler.getStackInSlot(INPUTSLOT).isEmpty();
    }
    
    @Override
    public ItemStack getItem(int pSlot) {
        return itemStackHandler.getStackInSlot(INPUTSLOT);
    }
    
    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return itemStackHandler.extractItem(INPUTSLOT, 1, false);
    }
    
    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return null;
    }
    
    @Override
    public void setItem(int pSlot, ItemStack itemStack) {
        this.itemStackHandler.setStackInSlot(INPUTSLOT, itemStack);
    }
    
    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }
    
    @Override
    public void clearContent() {
    
    }
    
    public void pullEntities(Level pLevel,BlockPos pPos){
        AABB areaOfEffect = AABB.ofSize(pPos.getCenter(), 15, 10, 15 );
        List<LivingEntity> nearByEntities = pLevel.getEntitiesOfClass(LivingEntity.class, areaOfEffect);
    
        for (LivingEntity nearByEntity : nearByEntities) {
            Vec3 pullPoint = nearByEntity.getPosition(2).lerp(pPos.getCenter().subtract(0,1,0),1);
            Vec3 pullLocation = pullPoint.subtract(nearByEntity.getPosition(1));
           
            
            nearByEntity.addDeltaMovement(pullLocation.scale(0.5));
        }
    
    }
    
    public void countHolderInArea(Level pLevel,BlockPos pPos, BlockState pState){
        AABB countArea = new AABB(pPos).deflate(16);
 
    
    }
}