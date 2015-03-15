package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockDefinitionAll extends BlockDefinition {

	@Override
	public boolean matches(World world, int x, int y, int z, Block block, int meta) {
		return true;
	}
}
