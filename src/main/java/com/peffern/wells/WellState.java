package com.peffern.wells;

/**
 * Enum for specific states of well TileEntities
 * @author peffern
 *
 */
public enum WellState 
{
	/** well ready to receive items */
	READY(0),
	/** well received an item */
	LOADED(1),
	/** Well is lowered and empty */
	EMPTY_DOWN(2),
	/** well is lowered and full of water */
	FULL_DOWN(2),
	/** well is raised and empty */
	EMPTY_UP(1),
	/** well is raised and full of water */
	FULL_UP(3);
	
	/** metadata value for BlockWell textures */
	private int meta;
	
	/** constructs the enums with meta values */
	private WellState(int blockMeta)
	{
		meta = blockMeta;
	}
	
	/** Gets the block metadata state from a state enum */
	public int getBlockMeta()
	{
		return meta;
	}
}
