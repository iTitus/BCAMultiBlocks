package bcamultiblocks.mutliblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockDefinitionAll extends BlockDefinition {

	@Override
	public boolean matches(Block block, int meta, World world, int x, int y, int z) {
		return true;
	}
}
