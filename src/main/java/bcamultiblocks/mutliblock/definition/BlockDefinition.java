package bcamultiblocks.mutliblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public abstract class BlockDefinition {

	public boolean isBlockValid(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);

		if (!block.isBlockNormalCube()) //TODO: figure out some other things that shouldn't be allowed in MultiBlocks.
			return false;

		return matches(block, meta, world, x, y, z);
	}

	protected abstract boolean matches(Block block, int meta, World world, int x, int y, int z);
}
