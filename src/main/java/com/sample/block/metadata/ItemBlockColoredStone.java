package com.sample.block.metadata;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockColoredStone extends ItemBlockWithMetadata
{
	public ItemBlockColoredStone(Block block)
	{
		super(block, block);
	}

	/*
	 * メタデータごとの内部名(unlocalized name)を設定する.
	 * 今回は4つ追加するので, 単純にメタデータを末尾に追加するだけ. すなわち内部名は以下のようになる.
	 * tile.blockColoredStone.0
	 * tile.blockColoredStone.1
	 * tile.blockColoredStone.2
	 * tile.blockColoredStone.3
	 */
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return super.getUnlocalizedName() + "." + itemStack.getItemDamage();
	}

}
