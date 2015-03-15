package bcamultiblocks.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileMultiBlock extends TileEntity {

    public boolean onBlockActivated(EntityPlayer player, ForgeDirection side, float hitX, float hitY, float hitZ) {
        return false;
    }

    public boolean onBlockClicked(EntityPlayer player) {
        return false;
    }

    public void breakBlock() {
    }
}
