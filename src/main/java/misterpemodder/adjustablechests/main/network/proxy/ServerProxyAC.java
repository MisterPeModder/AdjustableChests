package misterpemodder.adjustablechests.main.network.proxy;

import misterpemodder.adjustablechests.main.AdjustableChests;
import misterpemodder.hc.main.network.proxy.ICommonProxy;
import misterpemodder.hc.main.utils.GuiHelper;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ServerProxyAC implements ICommonProxy {

	@Override
	public void preInit() {}

	@Override
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(AdjustableChests.instance, new GuiHelper());
	}

	@Override
	public void postInit() {}

}
