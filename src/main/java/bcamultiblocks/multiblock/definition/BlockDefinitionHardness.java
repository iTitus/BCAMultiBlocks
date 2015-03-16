package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockDefinitionHardness extends BlockDefinition {

	private final int minHardness;

	public BlockDefinitionHardness(int minHardness) {
		this.minHardness = minHardness;
	}

	@Override
	public boolean matches(World world, int x, int y, int z, Block block, int meta) {
		return block.getBlockHardness(world, x, y, z) >= minHardness;
	}
}
