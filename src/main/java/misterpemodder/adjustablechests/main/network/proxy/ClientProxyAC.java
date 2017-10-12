package misterpemodder.adjustablechests.main.network.proxy;

import misterpemodder.adjustablechests.main.AdjustableChests;
import misterpemodder.adjustablechests.main.client.render.TileEntityAdjustableChestRenderer;
import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.main.network.proxy.ICommonProxy;
import misterpemodder.hc.main.utils.GuiHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxyAC implements ICommonProxy {

	@Override
	public void preInit() {}

	@Override
	public void init() {		
		NetworkRegistry.INSTANCE.registerGuiHandler(AdjustableChests.instance, new GuiHelper());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAdjustableChest.class, new TileEntityAdjustableChestRenderer());
	}

	@Override
	public void postInit() {}

}
