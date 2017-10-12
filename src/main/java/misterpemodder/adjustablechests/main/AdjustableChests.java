/*
=======================================================================
=*------------------------*==/-----------------\===/--------------\====
=|                        |==|                 |===|               \===
=|         *----*         |==|                 |===|     /---------/===
=|         |    |         |==|     /-----\     |===|     |=============
=*---------|    |---------*==|     |=====|     |===|     |=============
=|         |    |         |==|     |=====|     |===|     |=============
=|         *----*         |==|     \-----/     |===|     |=============
=|                        |==|                 |===|     |=============
=|                        |==|                 |===|     |=============
=|                        |==|     /-----\     |===|     \---------\===
=|                        |==|     |=====|     |===|               /===
=*------------------------*==\-----/=====\-----/===\--------------/====
=======================================================================
*/

package misterpemodder.adjustablechests.main;
import misterpemodder.adjustablechests.main.client.gui.EnumGuiElements;
import misterpemodder.adjustablechests.main.inventory.ContainerAdjustableChest;
import misterpemodder.hc.main.AbstractMod;
import misterpemodder.hc.main.HexianCore;
import misterpemodder.hc.main.compat.craftingtweaks.CraftingTweaksCompat;
import misterpemodder.hc.main.network.HexianNetworkWrapper;
import misterpemodder.hc.main.network.packet.IPacketHandler;
import misterpemodder.hc.main.network.packet.PacketHandler;
import misterpemodder.hc.main.network.proxy.ICommonProxy;
import misterpemodder.hc.main.utils.GuiHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(
		modid = ACRefs.MOD_ID,
		name = ACRefs.MOD_NAME,
		version = ACRefs.MOD_VERSION,
		acceptedMinecraftVersions = ACRefs.ACCEPTED_MC_VERSIONS,
		dependencies = "required-after:hc@" + ACRefs.ACCEPTED_HC_VERSIONS,
		updateJSON = ACRefs.UPDATE_JSON
	)
public class AdjustableChests extends AbstractMod {
	
	@Instance(ACRefs.MOD_ID)
	public static AdjustableChests instance;

	@SidedProxy(modId = ACRefs.MOD_ID, clientSide = ACRefs.CLIENT_PROXY_CLASS, serverSide = ACRefs.SERVER_PROXY_CLASS)
	public static ICommonProxy proxy;
	
	public static final IPacketHandler PACKET_HANDLER = new PacketHandler() {
		@Override
		protected SimpleNetworkWrapper getNetworkWrapper() {
			return HexianCore.instance.getNetworkWrapper();
		}
	};
	
	@Override
	public ICommonProxy getProxy() {
		return AdjustableChests.proxy;
	}
	
	public IPacketHandler getPacketHandler() {
		return PACKET_HANDLER;
	}

	@Override
	protected HexianNetworkWrapper createNetworkWrapper() {
		return new HexianNetworkWrapper(ACRefs.MOD_ID);
	}
	
	@Mod.EventHandler
	public void preInitialization(FMLPreInitializationEvent event) {
		
		CraftingTweaksCompat.registerContainer(ContainerAdjustableChest.class, 79);
		super.preInitialization(event);
	}

	@Mod.EventHandler
	public void initialization(FMLInitializationEvent event) {
		super.initialization(event);
		GuiHelper.registerGuiElements(instance, EnumGuiElements.values());
	}

	@Mod.EventHandler
	public void postInitialization(FMLPostInitializationEvent event) {
		super.postInitialization(event);
	}

}
