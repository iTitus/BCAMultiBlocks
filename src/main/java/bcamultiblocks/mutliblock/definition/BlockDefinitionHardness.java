package bcamultiblocks.mutliblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockDefinitionHardness extends BlockDefinition {

	private int hardness;

	public BlockDefinitionHardness(int minHardness) {
		this.hardness = minHardness;
	}

	@Override
	public boolean matches(Block block, int meta, World world, int x, int y, int z) {
		return block.getBlockHardness(world, x, y, z) >= hardness;
	}
}
