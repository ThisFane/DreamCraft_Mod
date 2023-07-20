package com.merl.dreamcraft.blocks.entity;

import com.merl.dreamcraft.particle.ModParticles;
import com.merl.dreamcraft.registry.ModBlockEntity;
import com.merl.dreamcraft.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HolderBlockEntity extends BlockEntity implements Container {
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
        itemHandlerLazyOptional = LazyOptional.of(() -> itemStackHandler);
        super.onLoad();
    }
    
    @Override
    public void invalidateCaps() {
        itemHandlerLazyOptional.invalidate();
        super.invalidateCaps();
    }
    
    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("holder_inventory",itemStackHandler.serializeNBT());
        super.saveAdditional(pTag);
    }
    
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemStackHandler.deserializeNBT(pTag.getCompound("holder_inventory"));
    }
    
    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
      
        if (itemStackHandler.getStackInSlot(INPUTSLOT).is(ModBlocks.SUN_BLOCK.get().asItem())) {
            pullEntities(pLevel, pPos);
            if (!level.isClientSide()){
                spawnFoundParticles((ServerLevel) level, pPos, pState);
            }
        }
        
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
        setChanged();
        return itemStackHandler.getStackInSlot(INPUTSLOT);
    }
    
    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        setChanged();
        return itemStackHandler.extractItem(INPUTSLOT, 1, false);
    }
    
    
    @Override
    public @NotNull ItemStack removeItemNoUpdate(int pSlot) {
        return this.removeItem(pSlot, 1);
    }
    
    @Override
    public void setItem(int pSlot, ItemStack itemStack) {
        this.itemStackHandler.setStackInSlot(INPUTSLOT, itemStack);
        setChanged();
    }
    
    @Override
    public boolean stillValid(Player pPlayer) {
        return Container.stillValidBlockEntity(this, pPlayer);
    }
    
    @Override
    public void clearContent() {
        this.itemHandlerLazyOptional.invalidate();
    }
    
    @Override
    public void setChanged() {
        super.setChanged();
    }
    
    public void pullEntities(Level pLevel, BlockPos pPos){
        AABB areaOfEffect = AABB.ofSize(pPos.getCenter(), 15, 10, 15 );
        List<LivingEntity> nearByEntities = pLevel.getEntitiesOfClass(LivingEntity.class, areaOfEffect);
    
        for (LivingEntity nearByEntity : nearByEntities) {
            Vec3 pullPoint = nearByEntity.getPosition(2).lerp(pPos.getCenter().subtract(0,1,0),1);
            Vec3 pullLocation = pullPoint.subtract(nearByEntity.getPosition(1));
           
            
            nearByEntity.addDeltaMovement(pullLocation.scale(0.5));
        }
    
    }
    
    
    private void spawnFoundParticles(ServerLevel level, BlockPos blockPos, BlockState blockState) {
            level.sendParticles(ModParticles.TEST_PARTICLES.get(),
                    blockPos.getX() + 0.5d, blockPos.getY() + 1, blockPos.getZ() + 0.5d, 20,
                    Math.cos(18) * 0.15d, 0.15d, Math.sin(18) * 0.15d, 0.1);
        
    }
    
    
}