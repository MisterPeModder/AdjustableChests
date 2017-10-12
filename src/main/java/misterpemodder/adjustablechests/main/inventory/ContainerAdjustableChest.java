package misterpemodder.adjustablechests.main.inventory;

import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.main.capabilty.item.ItemHandlerPart;
import misterpemodder.hc.main.inventory.ContainerBase;
import misterpemodder.hc.main.inventory.slot.SlotDisableable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class ContainerAdjustableChest extends ContainerBase<TileEntityAdjustableChest> {
	
	/*
	 * SLOTS:
	 * 
	 * Player Inventory 9-35 .. 0 - 26
	 * Player Hotbar	0-8 ... 27 - 35
	 * Player Armor     0-3 ... 36 - 39
	 * Offhand          0-0 ... 40 - 40
	 * Lock Slot        0-0 ... 41 - 41
	 * Adjustable Chest 0-35 .. 42 - 77
	 * Crafing result   0-0 ... 78 - 78
	 * Crafing matrix   0-8 ... 79 - 87
	 * Baubles          0-6 ... 88 - 96
	 */
	
	protected final ItemHandlerPart inventory;

	public ContainerAdjustableChest(TileEntityAdjustableChest te, InventoryPlayer playerInv) {
		super(te, playerInv, 100);
		this.inventory = new ItemHandlerPart(te.getInventory(), 36);
	}
	
	@Override
	protected void setTeSlots(TileEntityAdjustableChest te) {
		ItemStackHandler h = te.getInventory();
		int index;
		
		for (int y = 0; y < 4; ++y) {
            for (int x = 0; x < 9; ++x) {
            	index = x + y * 9;
            	this.addSlotToContainer(new SlotDisableable(h, index, 26 + x * 18, 18 + y * 18, false, index < te.getInventorySize()));
            }
        }
	}
	
	@Override
	protected void setLockSlot(boolean enabled) {
		super.setLockSlot(true);
	}
	
	@Override
	protected void setCraftingSlots(boolean enabled) {
		super.setCraftingSlots(true);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            //Adjustable chest slots
            if (index >= 42 && index < 77 && !this.mergeItemStack(itemstack1, 0, 40, false))
            	return ItemStack.EMPTY;
            
            //player inv
            else if(index < 41 || (index >= 88 && index < 96)) {
            	Slot lockSlot = this.inventorySlots.get(41);
            	if (lockSlot.isItemValid(itemstack1) && lockSlot.getStack().isEmpty() && !this.mergeItemStack(itemstack1, 41, 42, false))
                    return ItemStack.EMPTY;
            	if(!mergeItemStackMainInv(itemstack1))
            		return ItemStack.EMPTY;
            }
            //lock slot
            else if(index == 41) {
            	if (!this.mergeItemStack(itemstack1, 0, 40, false)) {
                	return ItemStack.EMPTY;
            	}
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            }
            else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
	
	@Override
	protected boolean mergeItemStackMainInv(ItemStack stack) {
		return ItemHandlerHelper.insertItemStacked(this.te.getInventory(), stack, false).isEmpty();
	}

}
