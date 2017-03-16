package com.peffern.wells;

import com.bioxx.tfc.api.TFCItems;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Wells addon for TFC.
 * Adds a well block that can be placed over a hole and will accumulate water.
 * Rightclick with a bucket to attach it.
 * Rightclick again to lower, and again to raise. if the well had water, it will fill the bucket.
 * @author peffern
 *
 */
@Mod(modid = TFCWells.MODID, name = TFCWells.MODNAME, version = TFCWells.VERSION, dependencies = "required-after:" + "terrafirmacraft" + ";")
public class TFCWells 
{
	/** Mod instance Singleton */
	@Instance(TFCWells.MODID)
	public static TFCWells instance;

	/** Mod ID String */
	public static final String MODID = "tfcwells";
	
	/** Mod Name */
	public static final String MODNAME = "TFC Wells";
	
	/** Mod Version */
	public static final String VERSION = "1.0";
	
	/** The Well Block*/
	public static Block well;
	
	/**
	 * Mod setup and item registration
	 * @param e initialization event
	 */
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		//setup blocks
		well = new BlockWell().setBlockName("Well").setHardness(10);
		
		//registration
		GameRegistry.registerTileEntity(TEWell.class, "Well");
		GameRegistry.registerBlock(well, ItemBlockWell.class, "Well");
		
		//crafting
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(well,1), "ABA","CDC","AEA",'A',"plankWood",'B',"itemSaw",'C',"ingotIron",'D',TFCItems.rope, 'E', TFCItems.woodenBucketEmpty));

		FMLCommonHandler.instance().bus().register(new com.peffern.wells.CraftingHandler());

	}
	
	
	
	
}
