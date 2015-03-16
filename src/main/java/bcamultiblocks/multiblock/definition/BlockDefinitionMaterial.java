package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockDefinitionMaterial extends BlockDefinition {

	private final Material material;

	public BlockDefinitionMaterial(Material material) {
		this.material = material;
	}

	@Override
	protected boolean matches(World world, int x, int y, int z, Block block, int meta) {
		return material == block.getMaterial();
	}

}
