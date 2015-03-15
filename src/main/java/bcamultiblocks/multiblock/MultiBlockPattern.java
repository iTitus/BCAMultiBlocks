package bcamultiblocks.multiblock;

import bcamultiblocks.multiblock.definition.BlockDefinition;
import net.minecraft.world.World;

import java.util.Map;

public class MultiBlockPattern {

    /**
     * Y X Z
     */
    private final char[][][] pattern;
    private final Map<Character, BlockDefinition> blockDefinitions;
    private final int sizeX, sizeY, sizeZ;

    protected MultiBlockPattern(char[][][] pattern, Map<Character, BlockDefinition> blockDefinitions, int sizeX, int sizeY, int sizeZ) {
        if (pattern == null)
            throw new NullPointerException("Pattern must not be null");
        this.pattern = pattern;

        if (blockDefinitions == null)
            throw new NullPointerException("BlockDefinitions must not be null");
        this.blockDefinitions = blockDefinitions;

        if (sizeY != pattern.length)
            throw new IllegalArgumentException("The given y size must match the pattern array");
        for (int y = 0; y < sizeY; y++) {
            if (sizeX != pattern[y].length)
                throw new IllegalArgumentException("The given x size must match the pattern array");
            for (int x = 0; x < sizeX; x++)
                if (sizeZ != pattern[y][x].length)
                    throw new IllegalArgumentException("The given z size must match the pattern array");
        }
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;

        for (int y = 0; y < sizeY; y++)
            for (int x = 0; x < sizeX; x++)
                for (int z = 0; z < sizeZ; z++)
                    if (blockDefinitions.get(pattern[y][x][z]) == null)
                        throw new IllegalArgumentException("The BlockDefinition map must assign a valid BlockDefinition for each used character");
    }

    public BlockDefinition getBlockDefinition(int xOffset, int yOffset, int zOffset) {
        if (!isInMultiBlock(xOffset, yOffset, zOffset))
            throw new IndexOutOfBoundsException("The given coordinates are out of bounds");
        return blockDefinitions.get(pattern[yOffset][xOffset][zOffset]);
    }

    public boolean isInMultiBlock(int xOffset, int yOffset, int zOffset) {
        return xOffset >= 0 && yOffset >= 0 && zOffset >= 0 && xOffset < sizeZ && yOffset < sizeY && zOffset < sizeZ;
    }

    public boolean isValidMultiBlock(World world, int x, int y, int z) {
        for (int yy = 0; yy < sizeY; yy++)
            for (int xx = 0; xx < sizeX; xx++)
                for (int zz = 0; zz < sizeZ; zz++)
                    if (!getBlockDefinition(xx, yy, zz).isBlockValid(world, xx + x, yy + y, zz + z))
                        return false;
        return true;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getSizeZ() {
        return sizeZ;
    }

}
