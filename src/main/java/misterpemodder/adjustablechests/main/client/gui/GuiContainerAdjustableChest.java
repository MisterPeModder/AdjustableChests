package misterpemodder.adjustablechests.main.client.gui;

import java.util.ArrayList;
import java.util.List;

import misterpemodder.adjustablechests.main.client.gui.tabs.TabACRedstone;
import misterpemodder.adjustablechests.main.client.gui.tabs.TabACSecurity;
import misterpemodder.adjustablechests.main.client.gui.tabs.TabMainAdjustableChest;
import misterpemodder.adjustablechests.main.client.gui.tabs.TabUpgrades;
import misterpemodder.adjustablechests.main.inventory.ContainerAdjustableChest;
import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.main.client.gui.GuiContainerBase;
import misterpemodder.hc.main.client.gui.tabs.TabArmorInventory;
import misterpemodder.hc.main.client.gui.tabs.TabBase;
import misterpemodder.hc.main.client.gui.tabs.TabPlayerInventory;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiContainerAdjustableChest extends GuiContainerBase<ContainerAdjustableChest, TileEntityAdjustableChest>{

	public GuiContainerAdjustableChest(InventoryPlayer playerInv, TileEntityAdjustableChest te) {
		super(new ContainerAdjustableChest(te, playerInv));
	}

	@Override
	public List<TabBase<ContainerAdjustableChest, TileEntityAdjustableChest>> registerTabs() {
		List<TabBase<ContainerAdjustableChest, TileEntityAdjustableChest>> list = new ArrayList<>();
		list.add(new TabMainAdjustableChest());
		list.add(new TabACRedstone().setEnabled(false));
		list.add(new TabUpgrades());
		list.add(new TabACSecurity());
		
		list.add(new TabPlayerInventory<ContainerAdjustableChest, TileEntityAdjustableChest>());
		list.add(new TabArmorInventory<ContainerAdjustableChest, TileEntityAdjustableChest>());
		return list;
	}

}
