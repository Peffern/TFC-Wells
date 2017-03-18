package com.peffern.wells;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerTileEntities()
	{
		ClientRegistry.registerTileEntity(TEWell.class, "well", new TESRWell());
	}
}
