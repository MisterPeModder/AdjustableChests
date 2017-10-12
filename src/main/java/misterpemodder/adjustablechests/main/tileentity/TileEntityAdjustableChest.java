package misterpemodder.adjustablechests.main.tileentity;

import misterpemodder.hc.main.tileentity.TileEntityCustomChest;
import misterpemodder.hc.main.utils.StringUtils;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class TileEntityAdjustableChest extends TileEntityCustomChest {

	@Override
	public int getInventorySize() {
		return 27;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentString(TextFormatting.getTextWithoutFormattingCodes(StringUtils.translate("tile.adjustableChest.name")));
	}

}
