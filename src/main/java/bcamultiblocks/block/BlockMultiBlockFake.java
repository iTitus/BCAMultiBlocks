package bcamultiblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import bcamultiblocks.tile.TileMultiBlockFake;

public class BlockMultiBlockFake extends BlockMultiBlock {

	public BlockMultiBlockFake(Material material) {
		super(material);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileMultiBlockFake();
	}

	public Block getOriginalBlock(World world, int x, int y, int z) {
		TileMultiBlockFake tile = getTile(world, x, y, z, TileMultiBlockFake.class);
		return Block.getBlockFromName(tile.getOriginalName());
	}

	public int getOriginalMeta(World world, int x, int y, int z) {
		TileMultiBlockFake tile = getTile(world, x, y, z, TileMultiBlockFake.class);
		return tile.getOriginMeta();
	}
}
