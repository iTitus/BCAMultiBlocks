package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockDefinitionAir extends BlockDefinition {

	@Override
	public boolean matches(World world, int x, int y, int z, Block block, int meta) {
		return block.isAir(world, x, y, z);
	}
}
