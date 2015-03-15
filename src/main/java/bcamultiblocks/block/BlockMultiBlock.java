package bcamultiblocks.block;

import bcamultiblocks.tile.TileMultiBlock;
import bcamultiblocks.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class BlockMultiBlock extends BlockContainer {

    public BlockMultiBlock(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileMultiBlock tile = getTile(world, x, y, z);
            if (tile != null)
                tile.onBlockActivated(player, ForgeDirection.getOrientation(side), hitX, hitY, hitZ);
        }
        return true;
    }

    @Override
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
        if (!world.isRemote) {
            TileMultiBlock tile = getTile(world, x, y, z);
            if (tile != null)
                tile.onBlockClicked(player);
        }
    }

    public TileMultiBlock getTile(IBlockAccess world, int x, int y, int z) {
        return BlockUtils.getTileEntity(world, x, y, z, TileMultiBlock.class);
    }

    @Override
    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
        return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        TileMultiBlock tile = getTile(world, x, y, z);
        if (tile != null)
            tile.breakBlock();
        world.removeTileEntity(x, y, z);
    }

    @Override
    public boolean onBlockEventReceived(World world, int x, int y, int z, int eventID, int eventParameter) {
        TileMultiBlock tile = getTile(world, x, y, z);
        return tile != null && tile.receiveClientEvent(eventID, eventParameter);
    }
}
