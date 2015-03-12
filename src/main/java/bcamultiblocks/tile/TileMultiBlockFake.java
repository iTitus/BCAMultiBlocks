package bcamultiblocks.tile;

import net.minecraft.nbt.NBTTagCompound;

public class TileMultiBlockFake extends TileMultiBlock {

	private String originalName;
	private int originalMeta;

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setString("BlockName", originalName);
		compound.setByte("BlockMeta", (byte) originalMeta);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		originalName = compound.getString("BlockName");
		originalMeta = compound.getByte("BlockMeta");
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public int getOriginalMeta() {
		return originalMeta;
	}

	public void setOriginalMeta(int originalMeta) {
		this.originalMeta = originalMeta;
	}
}
