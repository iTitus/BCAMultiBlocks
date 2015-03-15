package bcamultiblocks.block;

import bcamultiblocks.tile.TileMultiBlockFake;
import bcamultiblocks.util.BlockUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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
        return getOriginalBlock(world, x, y, z).addDestroyEffects(world, x, y, z, meta, effectRenderer);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean addHitEffects(World world, MovingObjectPosition mop, EffectRenderer effectRenderer) {
        return getOriginalBlock(world, mop.blockX, mop.blockY, mop.blockZ).addHitEffects(world, mop, effectRenderer);
    }

    @Override
    public float getBlockHardness(World world, int x, int y, int z) {
        return getOriginalBlock(world, x, y, z).getBlockHardness(world, x, y, z);
    }

    @Override
    public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
        return getOriginalBlock(world, x, y, z).getExplosionResistance(entity, world, x, y, z, explosionX, explosionY, explosionZ);
    }

    @Override
    public int damageDropped(int meta) {
        return meta;
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
        return getOriginalBlock(world, x, y, z).canConnectRedstone(world, x, y, z, side);
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int i) {
        return getOriginalBlock(world, x, y, z).isProvidingStrongPower(world, x, y, z, i);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int i) {
        return getOriginalBlock(world, x, y, z).isProvidingWeakPower(world, x, y, z, i);
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return getOriginalBlock(world, x, y, z).getLightValue(world, x, y, z);
    }

    public Block getOriginalBlock(IBlockAccess world, int x, int y, int z) {
        TileMultiBlockFake tile = BlockUtils.getTileEntity(world, x, y, z, TileMultiBlockFake.class);
        if (tile != null)
            return Block.getBlockFromName(tile.getOriginalName());
        return Blocks.air;
    }

    public int getOriginalMeta(IBlockAccess world, int x, int y, int z) {
        TileMultiBlockFake tile = BlockUtils.getTileEntity(world, x, y, z, TileMultiBlockFake.class);
        if (tile != null)
            return tile.getOriginalMeta();
        return 0;
    }
}
