package misterpemodder.adjustablechests.main.client;

import misterpemodder.adjustablechests.main.ACRefs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ACRefs.MOD_ID)
public final class ModSounds {
	
	public static final SoundEvent ADJUSTABLE_CHEST_OPEN = new SoundEvent(new ResourceLocation(ACRefs.MOD_ID, "chest/achestopen"));
	public static final SoundEvent ADJUSTABLE_CHEST_CLOSE = new SoundEvent(new ResourceLocation(ACRefs.MOD_ID, "chest/achestclose"));
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<SoundEvent> event) {
	    event.getRegistry().register(ADJUSTABLE_CHEST_OPEN);
	    event.getRegistry().register(ADJUSTABLE_CHEST_CLOSE);
	}

}
