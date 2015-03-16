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
public class BlockDefinitionExact extends BlockDefinitionBlock {

	private final int meta;

	public BlockDefinitionExact(Block block) {
		this(block, 0);
	}

	public BlockDefinitionExact(Block block, int meta) {
		super(block);
		this.meta = meta;
	}

	@Override
	protected boolean matches(World world, int x, int y, int z, Block block, int meta) {
		return super.matches(world, x, y, z, block, meta) && this.meta == meta;
	}

}
