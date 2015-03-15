package bcamultiblocks.util;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUtils {

    public static Block getBlock(World world, int x, int y, int z) {
        return world.getBlock(x, y, z);
    }

    public static TileEntity getTileEntityFast(World world, int x, int y, int z) {
        if (world != null && world.blockExists(x, y, z))
            return world.getChunkFromChunkCoords(x, z).getTileEntityUnsafe(x >> 4, y, z >> 4);
        return null;
    }

    public static <T extends TileEntity> T getTileEntityFast(World world, int x, int y, int z, Class<T> tileEntityClass) {
        TileEntity tile = getTileEntityFast(world, x, y, z);
        if (tile != null && tileEntityClass.isInstance(tile))
            return tileEntityClass.cast(tileEntityClass);
        return null;
    }

    public static TileEntity getTileEntity(IBlockAccess world, int x, int y, int z) {
        if (world != null)
            return world.getTileEntity(x, y, z);
        return null;
    }

    public static <T extends TileEntity> T getTileEntity(IBlockAccess world, int x, int y, int z, Class<T> tileEntityClass) {
        TileEntity tile = getTileEntity(world, x, y, z);
        if (tile != null && tileEntityClass.isInstance(tile))
            return tileEntityClass.cast(tileEntityClass);
        return null;
    }

}
