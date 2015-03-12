package bcamultiblocks.mutliblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockDefinitionAir extends BlockDefinition {

	@Override
	public boolean matches(Block block, int meta, World world, int x, int y, int z) {
		return block.isAir(world, x, y, z);
	}
}
