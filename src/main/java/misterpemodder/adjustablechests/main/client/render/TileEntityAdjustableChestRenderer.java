package misterpemodder.adjustablechests.main.client.render;

import misterpemodder.adjustablechests.main.ACRefs;
import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.main.client.render.TileEntityCustomChestRenderer;
import net.minecraft.util.ResourceLocation;

public class TileEntityAdjustableChestRenderer extends TileEntityCustomChestRenderer<TileEntityAdjustableChest>{

	private static final ResourceLocation TEXTURE = new ResourceLocation(ACRefs.MOD_ID, "textures/entity/adjustable_chest.png");
	
	@Override
	protected ResourceLocation getTexture() {
		return TEXTURE;
	}

}
