package misterpemodder.adjustablechests.main.client.gui.tabs;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;

import misterpemodder.adjustablechests.main.ACRefs;
import misterpemodder.adjustablechests.main.inventory.ContainerAdjustableChest;
import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.api.block.ILockable;
import misterpemodder.hc.api.item.IItemLock;
import misterpemodder.hc.main.client.gui.GuiContainerBase;
import misterpemodder.hc.main.client.gui.tabs.TabBase;
import misterpemodder.hc.main.inventory.slot.IHidableSlot;
import misterpemodder.hc.main.inventory.slot.SlotDisableable;
import misterpemodder.hc.main.utils.StringUtils;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLockIconButton;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TabACSecurity extends TabBase<ContainerAdjustableChest, TileEntityAdjustableChest> {

	public static final int LOCK_BUTTON_ID = 10;
	
	public static final String ID = ACRefs.MOD_ID + ".security";
	
	public TabACSecurity() {
		super(TabPos.TOP_LEFT);
	}
	
	@Override
	public String getTabID() {
		return ID;
	}
	
	@Override
	public void initButtons(int x, int y) {
		GuiLockIconButton lb = new GuiLockIconButton(LOCK_BUTTON_ID, x+26, y+16);
		lb.setLocked(getTileEntity().isLocked());
		buttons.add(lb);
	}
	
	public void updateButtons() {
		for(GuiButton b : buttons) {
			if(b.id == LOCK_BUTTON_ID && b instanceof GuiLockIconButton) {
				ItemStack s = guiContainer.container.getTileEntity().getLockItemHandler().getStackInSlot(0);
				b.enabled = !(s.isEmpty() || (s.getItem() instanceof IItemLock && ((IItemLock)s.getItem()).isBroken(s)));
				
			}
		}
	}
	
	@Override
	public void onButtonClicked(GuiButton button) {
		if(button.id == LOCK_BUTTON_ID && button instanceof GuiLockIconButton) {
			GuiLockIconButton b = (GuiLockIconButton) button;
			NBTTagCompound data = new NBTTagCompound();
			data.setBoolean("locked", !b.isLocked());
			b.setLocked(!b.isLocked());
			TabBase.sendButtonPacket(getTabID(), LOCK_BUTTON_ID, guiContainer.mc.world, guiContainer.container.getTileEntity().getPos(), data);
		}
	}

	@Override
	public String getUnlocalizedName() {
		return "gui.tab.ac.security.name";
	}

	@Override
	public ItemStack getItemStack() {
		return new ItemStack(Blocks.STRUCTURE_VOID);
	}

	@Override
	public TabTexture getTabTexture() {
		return new TabTexture(ACRefs.TAB_LOCATION, new Point(96, 28), new Point(64, 28), new ResourceLocation(ACRefs.MOD_ID, "textures/gui/container/security.png"), new Dimension(212, 100));
	}
	
	@Override
	public TabTexture getDisabledTabTexture() {
		return new TabTexture(ACRefs.TAB_LOCATION, new Point(96, 56), new Point(64, 56), new ResourceLocation(ACRefs.MOD_ID, "textures/gui/container/security.png"), new Dimension(212, 100));
	}

	@Override
	public boolean shouldDisplaySlot(IHidableSlot slot) {
		TileEntity te = guiContainer.container.getTileEntity();
		if(te instanceof ILockable && slot instanceof SlotDisableable) {
			return ((SlotDisableable)slot).getItemHandler() == ((ILockable)te).getLockItemHandler();
		}
		return false;
	}
	
	
	public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		if(getTileEntity().getLockItemHandler().getStackInSlot(0).isEmpty()) {
			guiContainer.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(ACRefs.MOD_ID, "textures/items/empty_lock_slot.png"));
			Gui.drawModalRectWithCustomSizedTexture(guiContainer.getGuiLeft() + 8, guiContainer.getGuiTop() + 18, 0, 0, 16, 16, 16, 16);
		}
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		if(guiContainer.isPointInRegion(8, 18, 16, 16, mouseX, mouseY)) {
			GuiContainerBase.addHoveringText(Arrays.asList(StringUtils.translate("gui.slot.ac.lock.name"), StringUtils.translate("gui.slot.ac.lock.desc")), 250);
	    }
	}

}
