package bcamultiblocks.multiblock.definition;

public abstract class BlockDefinitionCombined extends BlockDefinition {

	protected final BlockDefinition[] blockDefinitions;

	public BlockDefinitionCombined(BlockDefinition... blockDefinitions) {
		if (blockDefinitions == null)
			throw new NullPointerException("BlockDefinitions must not be null");
		this.blockDefinitions = blockDefinitions;
	}

}
