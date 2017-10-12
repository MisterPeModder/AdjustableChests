package misterpemodder.adjustablechests.main.block;

import javax.annotation.Nullable;

import misterpemodder.adjustablechests.main.ACRefs;
import misterpemodder.adjustablechests.main.client.gui.EnumGuiElements;
import misterpemodder.adjustablechests.main.tileentity.TileEntityAdjustableChest;
import misterpemodder.hc.main.blocks.BlockCustomChest;
import misterpemodder.hc.main.blocks.properties.IBlockNames;
import misterpemodder.hc.main.blocks.properties.IBlockValues;
import misterpemodder.hc.main.utils.GuiHelper.IGuiElement;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAdjustableChest extends BlockCustomChest<TileEntityAdjustableChest> {
	
	private static final IBlockNames NAMES = new IBlockNames() {
		public String getUnlocalizedName() {
			return "adjustableChest";
		}
	
		public String getRegistryName() {
			return "adjustable_chest";
		}
	};
	
	static final IBlockValues VALUES = new IBlockValues() {
		public SoundType getSoundType(IBlockState state) {
			return SoundType.WOOD;
		}
		public Material getMaterial(@Nullable IBlockState state) {
			return Material.WOOD;
		}
		public MapColor getMapColor(@Nullable IBlockState state) {
			return MapColor.GRAY;
		}
		public float getHardness(IBlockState state) {
			return 50.0F;
		}
		@Override
		public float getResistance(IBlockState state) {
			return 0.0F;
		}
		@Override
		public int getHarvestLevel(IBlockState state) {
			return 2;
		}
		@Override
		public int getLightOpacity(IBlockState state) {
			return 3;
		}
		@Override
		public boolean isFullCube(IBlockState state) {
			return false;
		}
		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}
	};

	public BlockAdjustableChest() {
		super(NAMES, VALUES, ACRefs.CREATIVE_TAB);
	}

	@Override
	public Class<TileEntityAdjustableChest> getTileEntityClass() {
		return TileEntityAdjustableChest.class;
	}

	@Override
	protected IGuiElement getGuiElements() {
		return EnumGuiElements.ADJUSTABLE_CHEST;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityAdjustableChest();
	}

}
