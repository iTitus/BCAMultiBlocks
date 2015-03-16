package bcamultiblocks.multiblock.definition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

/**
 * Copyright (c) 2014-2015, AEnterprise
 * http://buildcraftadditions.wordpress.com/
 * Buildcraft Additions is distributed under the terms of GNU GPL v3.0
 * Please check the contents of the license located in
 * http://buildcraftadditions.wordpress.com/wiki/licensing-stuff/
 */
public class BlockDefinitionExact extends BlockDefinition {

	private final Block block;
	private final int meta;

	public BlockDefinitionExact(Block block, int meta) {
		this.block = block;
		this.meta = meta;
	}

	@Override
	protected boolean matches(World world, int x, int y, int z, Block block, int meta) {
		return this.block == block && this.meta == meta;
	}
}
