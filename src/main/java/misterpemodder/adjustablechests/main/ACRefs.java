package misterpemodder.adjustablechests.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public final class ACRefs {
	
	public static final String MOD_ID = "adjustablechests";
	public static final String MOD_NAME = "Adjustable Chests";
	
	public static final String CLIENT_PROXY_CLASS = "misterpemodder.adjustablechests.main.network.proxy.ClientProxyAC";
	public static final String SERVER_PROXY_CLASS = "misterpemodder.adjustablechests.main.network.proxy.ServerProxyAC";
	
	public static final String MOD_VERSION = "1.0.0";
	public static final String ACCEPTED_HC_VERSIONS = "[1.1.0,)";
	public static final String ACCEPTED_MC_VERSIONS = "[1.11.2]";
	public static final String UPDATE_JSON = "https://raw.githubusercontent.com/MisterPeModder44/AdjustableChests/HEAD/update.json";
	
	public static final CreativeTabs CREATIVE_TAB = new ACTab(MOD_ID);
	
	public static final ResourceLocation TAB_LOCATION = new ResourceLocation(MOD_ID, "textures/gui/container/tabs.png");
	
}
