package misterpemodder.adjustablechests.main.block;

import misterpemodder.adjustablechests.main.ACRefs;
import misterpemodder.hc.main.blocks.IHexianBlock;
import misterpemodder.hc.main.blocks.properties.IHexianBlockList;
import misterpemodder.hc.main.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ACRefs.MOD_ID)
public class ModBlocks {
	
	public static enum TheBlocks implements IHexianBlockList {
		CHEST(new BlockAdjustableChest()),
		;
		private IHexianBlock block;
		
		@Override
		public Block getBlock() {
			return (Block)this.block;
		}
		
		@Override
		public IHexianBlock getHexianBlock() {
			return this.block;
		}
		
		TheBlocks(IHexianBlock block) {
			this.block = block;
		}
		
	}
	
	@SubscribeEvent
	public static void registerBlocksEvent(RegistryEvent.Register<Block> event) {
		RegistryHelper.registerBlocks(TheBlocks.values(), event.getRegistry());
	}
	
}