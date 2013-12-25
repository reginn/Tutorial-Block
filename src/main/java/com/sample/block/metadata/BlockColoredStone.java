package com.sample.block.metadata;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockColoredStone extends Block {

	/*
	 * カラーコード, それぞれ黒, 赤, 青, 緑
	 */
	private final int[] color = {0x000000, 0xFF0000, 0x00FF00, 0x0000FF};

	public BlockColoredStone(int blockID, Material material) {
		super(blockID, material);
	}

	/*
	 * メタデータの違いによるブロックの追加はgetSubBlocksで行う.
	 * 基本的にメタデータごとのItemStackのインスタンスを生成して引数のlistに追加すればいい.
	 */
    @SuppressWarnings("unchecked")
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockID, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < 4; ++i) {
			list.add(new ItemStack(blockID, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int meta) {
		return this.color[meta];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess iBlockAccess, int x, int y, int z) {
		int meta = iBlockAccess.getBlockMetadata(x, y, z);

		return this.color[meta];
	}


}
