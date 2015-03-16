package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockDefinitionBlock extends BlockDefinition {

	protected final Block block;

	public BlockDefinitionBlock(Block block) {
		this.block = block;
	}

	@Override
	protected boolean matches(World world, int x, int y, int z, Block block, int meta) {
		return this.block == block;
	}
	
}
