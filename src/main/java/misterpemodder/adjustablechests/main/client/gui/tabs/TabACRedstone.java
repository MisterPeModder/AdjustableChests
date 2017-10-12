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

public class TabACRedstone extends TabBase<ContainerAdjustableChest, TileEntityAdjustableChest> {
	
	public static final String ID = ACRefs.MOD_ID + ".redstone";

	public TabACRedstone() {
		super(TabPos.TOP_RIGHT);
	}

	@Override
	public String getTabID() {
		return ID;
	}

	@Override
	public String getUnlocalizedName() {
		return "gui.tab.ac.redstone.name";
	}

	@Override
	public ItemStack getItemStack() {
		return new ItemStack(Items.REDSTONE);
	}

	@Override
	protected TabTexture getTabTexture() {
		return new TabTexture(ACRefs.TAB_LOCATION, new Point(0, 0), new Point(0, 0), new ResourceLocation(ACRefs.MOD_ID, "textures/gui/container/redstone.png"), new Dimension(212, 100));
	}
	
	@Override
	protected TabTexture getDisabledTabTexture() {
		return new TabTexture(ACRefs.TAB_LOCATION, new Point(0, 28), new Point(0, 28), new ResourceLocation(ACRefs.MOD_ID, "textures/gui/container/redstone.png"), new Dimension(212, 100));
	}

	@Override
	public boolean shouldDisplaySlot(IHidableSlot slot) {
		return false;
	}

}
