package bcamultiblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import bcamultiblocks.tile.TileMultiBlock;

public abstract class BlockMultiBlock extends Block implements ITileEntityProvider {

	public BlockMultiBlock(Material material) {
		super(material);
	}

	@Override
	public abstract TileEntity createNewTileEntity(World world, int meta);

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		return world.isRemote || getTile(world, x, y, z).onBlockActivated(player);
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		if (world.isRemote)
			return;
		getTile(world, x, y, z).onBlockClicked(player);
	}

	public TileMultiBlock getTile(IBlockAccess world, int x, int y, int z) {
		return (TileMultiBlock) world.getTileEntity(x, y, z);
	}

	public <T> T getTile(IBlockAccess world, int x, int y, int z, Class<T> clazz) {
		TileMultiBlock tile = getTile(world, x, y, z);
		return (T) tile;
	}

	@Override
	public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
		return false;
	}
}
