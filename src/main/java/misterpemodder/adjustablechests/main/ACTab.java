package misterpemodder.adjustablechests.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ACTab extends CreativeTabs {

	public ACTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Blocks.CHEST);
	}
	
}
