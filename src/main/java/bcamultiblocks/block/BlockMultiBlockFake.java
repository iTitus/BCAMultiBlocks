package bcamultiblocks.block;

import bcamultiblocks.tile.TileMultiBlockFake;
import bcamultiblocks.util.BlockUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
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
