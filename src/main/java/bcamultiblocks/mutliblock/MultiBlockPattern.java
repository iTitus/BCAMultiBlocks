package bcamultiblocks.mutliblock;

import java.util.HashMap;

import bcamultiblocks.mutliblock.definition.BlockDefinition;

public class MultiBlockPattern {

	public char[][][] pattern; //Y X Z
	public HashMap<Character, BlockDefinition> blockDefinitions;

	protected MultiBlockPattern(char[][][] pattern, HashMap<Character, BlockDefinition> blockDefinitions) {
		this.pattern = pattern;
		this.blockDefinitions = blockDefinitions;
	}
}
