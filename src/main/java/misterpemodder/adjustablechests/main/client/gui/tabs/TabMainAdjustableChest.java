package misterpemodder.adjustablechests.main.client.gui.tabs;

import misterpemodder.adjustablechests.main.ACRefs;
import misterpemodder.adjustablechests.main.inventory.ContainerAdjustableChest;
import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.main.client.gui.tabs.TabMain;
import net.minecraft.util.ResourceLocation;

public class TabMainAdjustableChest extends TabMain<ContainerAdjustableChest, TileEntityAdjustableChest> {
	
	public static final String ID = ACRefs.MOD_ID + ".main.aChest";

	@Override
	public String getTabID() {
		return ID;
	}

	@Override
	public TabTexture getTabTexture() {
		return new TabTexture(new ResourceLocation(ACRefs.MOD_ID, "textures/gui/container/adjustable_chest_main.png"));
	}
	
	//TODO Remove if not needed.
	protected int getTitleX() {
		return 8;
	}
	
	protected int getTitleY() {
		return 6;
	}

}
