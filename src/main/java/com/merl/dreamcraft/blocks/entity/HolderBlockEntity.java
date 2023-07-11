package com.merl.dreamcraft.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class HolderBlockEntity extends BlockEntity implements Container {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    
    private static final int INPUTSLOT = 0;
    
    private LazyOptional<IItemHandler> itemHandlerLazyOptional = LazyOptional.empty();
    
    protected final ContainerData containerData;
    private int craftingProgress = 0;
    private int maxCraftingProgress = 100;
    
    public HolderBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntity.HOLDER_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.containerData = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex){
                    case 0 -> HolderBlockEntity.this.craftingProgress;
                    case 1 -> HolderBlockEntity.this.maxCraftingProgress;
                    default -> 0;
                };
            }
    
            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex){
                    case 0 -> HolderBlockEntity.this.craftingProgress = pValue;
                    case 1 -> HolderBlockEntity.this.maxCraftingProgress = pValue;
                };
            }
    
            @Override
            public int getCount() {
                return 2;
            }
        };
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
        pTag.put("holder_inventory",itemStackHandler.serializeNBT());
        super.saveAdditional(pTag);
    }
    
    @Override
    public void load(CompoundTag pTag) {
        itemStackHandler.deserializeNBT(pTag.getCompound("holder_inventory"));
        super.load(pTag);
    }
    
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        
        System.out.println(itemStackHandler.getStackInSlot(INPUTSLOT));
    }
    
    
    @Override
    public int getContainerSize() {
        return 64;
    }
    
    @Override
    public boolean isEmpty() {
        return this.itemStackHandler.getStackInSlot(INPUTSLOT).isEmpty();
    }
    
    @Override
    public ItemStack getItem(int pSlot) {
        return this.itemStackHandler.getStackInSlot(INPUTSLOT);
    }
    
    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return this.itemStackHandler.extractItem(INPUTSLOT, 1, false);
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
}