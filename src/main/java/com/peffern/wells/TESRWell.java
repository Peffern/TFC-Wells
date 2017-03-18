package com.peffern.wells;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

public class TESRWell extends TileEntitySpecialRenderer
{

	private ItemStack brick = new ItemStack(TFCWells.wellRope,1);
	private EntityItem item = null;
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) 
	{
		GL11.glPushMatrix();
		TEWell well = (TEWell)te;
		if(well.wellState == WellState.EMPTY_DOWN || well.wellState == WellState.FULL_DOWN)
			item = new EntityItem(well.getWorldObj(), x, y, z, brick);
		else if(well.wellState != WellState.READY)
			item = new EntityItem(well.getWorldObj(), x, y, z, well.item);
		else
			item = null;
		
		if(item != null)
		{
			item.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glTranslatef((float)x+0.5f,(float)y+0.0625f,(float)z+0.5f);
			GL11.glScalef(2, 2, 2);
			for(int i = 0; i < 4; i++)
			{
				RenderManager.instance.renderEntityWithPosYaw(item, 0.0D, 0.0D, 0.25D, 0.0F, 0.0F);
				GL11.glRotatef(90, 0, 1, 0);
			}
			RenderItem.renderInFrame = false;
		}
		GL11.glPopMatrix();
		
	}

}
 