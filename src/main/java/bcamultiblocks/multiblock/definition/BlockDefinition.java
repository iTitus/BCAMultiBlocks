package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public abstract class BlockDefinition {

	public boolean isBlockValid(World world, int x, int y, int z) {
		return matches(world, x, y, z, world.getBlock(x, y, z), world.getBlockMetadata(x, y, z));
	}

	protected abstract boolean matches(World world, int x, int y, int z, Block block, int meta);

}
