package misterpemodder.adjustablechests.main.client.gui;

import misterpemodder.adjustablechests.main.inventory.ContainerAdjustableChest;
import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.main.utils.GuiHelper.IGuiElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public enum EnumGuiElements implements IGuiElement {
	
	ADJUSTABLE_CHEST {
		@Override
		public Container getServerGuiElement(EntityPlayer player, World world, int x, int y, int z) {
			return new ContainerAdjustableChest((TileEntityAdjustableChest)world.getTileEntity(new BlockPos(x, y, z)), player.inventory);
		}
		@Override
		public GuiScreen getClientGuiElement(EntityPlayer player, World world, int x, int y, int z) {
			return new GuiContainerAdjustableChest(player.inventory, (TileEntityAdjustableChest)world.getTileEntity(new BlockPos(x, y, z)));
		}
	},
	;

}
