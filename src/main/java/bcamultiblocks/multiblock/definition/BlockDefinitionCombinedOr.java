package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockDefinitionCombinedOr extends BlockDefinitionCombined {

	public BlockDefinitionCombinedOr(BlockDefinition... blockDefinitions) {
		super(blockDefinitions);
	}

	@Override
	protected boolean matches(World world, int x, int y, int z, Block block, int meta) {
		for (BlockDefinition blockDefinition : blockDefinitions)
			if (blockDefinition.matches(world, x, y, z, block, meta))
				return true;
		return false;
	}

}
