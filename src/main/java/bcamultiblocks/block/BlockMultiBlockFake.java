package bcamultiblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import bcamultiblocks.tile.TileMultiBlockFake;

//TODO: Add needed methods
public class BlockMultiBlockFake extends BlockMultiBlock {

	public BlockMultiBlockFake(Material material) {
		super(material);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileMultiBlockFake();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
		return getOriginalBlock(world, x, y, z).getIcon(world, x, y, z, side);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
		Block block = getOriginalBlock(world, x, y, z);
		return block == null ? super.addDestroyEffects(world, x, y, z, meta, effectRenderer) : block.addDestroyEffects(world, x, y, z, meta, effectRenderer);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean addHitEffects(World world, MovingObjectPosition mop, EffectRenderer effectRenderer) {
		Block block = getOriginalBlock(world, mop.blockX, mop.blockY, mop.blockZ);
		return block == null ? super.addHitEffects(world, mop, effectRenderer) : block.addHitEffects(world, mop, effectRenderer);
	}

	@Override
	public float getBlockHardness(World world, int x, int y, int z) {
		Block block = getOriginalBlock(world, x, y, z);
		return block == null ? super.getBlockHardness(world, x, y, z) : block.getBlockHardness(world, x, y, z);
	}

	@Override
	public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		Block block = getOriginalBlock(world, x, y, z);
		return block == null ? super.getExplosionResistance(entity, world, x, y, z, explosionX, explosionY, explosionZ) : block.getExplosionResistance(entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		Block block = getOriginalBlock(world, x, y, z);
		return block == null ? super.canConnectRedstone(world, x, y, z, side) : block.canConnectRedstone(world, x, y, z, side);
	}

	@Override
	public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int i) {
		Block block = getOriginalBlock(world, x, y, z);
		return block == null ? super.isProvidingStrongPower(world, x, y, z, i) : block.isProvidingStrongPower(world, x, y, z, i);
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int i) {
		Block block = getOriginalBlock(world, x, y, z);
		return block == null ? super.isProvidingWeakPower(world, x, y, z, i) : block.isProvidingWeakPower(world, x, y, z, i);
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		Block block = getOriginalBlock(world, x, y, z);
		return block == null ? super.getLightValue(world, x, y, z) : block.getLightValue(world, x, y, z);
	}

	public Block getOriginalBlock(IBlockAccess world, int x, int y, int z) {
		TileMultiBlockFake tile = getTile(world, x, y, z, TileMultiBlockFake.class);
		return Block.getBlockFromName(tile.getOriginalName());
	}

	public int getOriginalMeta(IBlockAccess world, int x, int y, int z) {
		TileMultiBlockFake tile = getTile(world, x, y, z, TileMultiBlockFake.class);
		return tile.getOriginalMeta();
	}
}
