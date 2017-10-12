package misterpemodder.adjustablechests.main.client.gui.tabs;

import java.awt.Dimension;
import java.awt.Point;

import misterpemodder.adjustablechests.main.ACRefs;
import misterpemodder.adjustablechests.main.inventory.ContainerAdjustableChest;
import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.main.client.gui.tabs.TabBase;
import misterpemodder.hc.main.inventory.slot.IHidableSlot;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TabUpgrades extends TabBase<ContainerAdjustableChest, TileEntityAdjustableChest> {
	
	public static final String ID = ACRefs.MOD_ID + ".upgrades";

	public TabUpgrades() {
		super(TabPos.TOP_LEFT);
	}
	
	@Override
	public String getTabID() {
		return ID;
	}

	@Override
	public String getUnlocalizedName() {
		return "gui.tab.ac.upgrades.name";
	}

	@Override
	//TODO Display upgrade base instead
	public ItemStack getItemStack() {
		return new ItemStack(Items.DIAMOND);
	}

	@Override
	public TabTexture getTabTexture() {
		return new TabTexture(ACRefs.TAB_LOCATION, new Point(96, 0), new Point(64, 0), new ResourceLocation(ACRefs.MOD_ID, "textures/gui/container/upgrades.png"), new Dimension(212, 100));
	}

	@Override
	//TODO Add slots
	public boolean shouldDisplaySlot(IHidableSlot slot) {
		return false;
	}

}
