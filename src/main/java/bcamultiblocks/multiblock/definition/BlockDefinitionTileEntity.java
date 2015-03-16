package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import bcamultiblocks.util.BlockUtils;

public abstract class BlockDefinitionTileEntity<T extends TileEntity> extends BlockDefinition {

	private final Class<T> tileEntityClass;

	public BlockDefinitionTileEntity(Class<T> tileEntityClass) {
		this.tileEntityClass = tileEntityClass;
	}

	@Override
	protected boolean matches(World world, int x, int y, int z, Block block, int meta) {
		return matches(world, x, y, z, block, meta, BlockUtils.getTileEntity(world, x, y, z, tileEntityClass));
	}

	protected abstract boolean matches(World world, int x, int y, int z, Block block, int meta, T tile);

}
