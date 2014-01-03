package com.sample.block.metadata;

import com.sample.block.basic.SampleBlockBasicCore;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid   = SampleBlockMetadataCore.MODID, version = SampleBlockMetadataCore.VERSION)
public class SampleBlockMetadataCore
{
	public static final String MODID   = "BlockMetadata";
	public static final String VERSION = "0.0.0";

	/*
	 * 東西南北の方向を持つ(かまどのような)ブロックの追加
	 * メタデータを利用した色違いブロックの追加
	 */
	public static Block blockDummyFurnace;
	public static Block blockColoredStone;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * Blockクラスを継承したBlockDummyFurnaceクラスからインスタンスを生成する.
		 * setTextureNameはやらない. 理由はBlockDummyFurnaceクラスを参照のこと.
		 */
		blockDummyFurnace = (new BlockDummyFurnace(Material.field_151576_e))
				.func_149663_c("blockDummyFurnace")
				.func_149647_a(CreativeTabs.tabBlock);

		GameRegistry.registerBlock(blockDummyFurnace, "blockDummyFurnace");

		/*
		 * langファイルによるローカライズのみになったため不要
		 *
		 * LanguageRegistry.addName(blockDummyFurnace, "Dummy Furnace");
		 */

		/*
		 * Blockクラスを継承したBlockColoredStoneクラスからインスタンスを生成する.
		 * 今回はメタデータを使って1つのブロックIDで4種類の黒, 赤, 青, 緑色の石を追加する.
		 */
		blockColoredStone = (new BlockColoredStone(Material.field_151576_e))
				.func_149663_c("blockColoredStone")
				.func_149658_d("stone")
				.func_149647_a(CreativeTabs.tabBlock);

		/*
		 * メタデータを使って1つのブロックIDで複数のブロックを扱う時は, registerBlockの第二引数にItemBlockないしItemBlockWithMetadataを継承したクラスを渡す.
		 */
		GameRegistry.registerBlock(blockColoredStone, ItemBlockColoredStone.class, "blockColoredStone");

		/*
		 * メタデータを使って1つのブロックIDで複数のブロックを扱う時は以下のように名前を登録する.
		 * もしくはunlocalized nameを使って以下のようにする.
		 *
		 * langファイルによるローカライズのみになったため不要
		 *
		 * LanguageRegistry.instance().addStringLocalization("tile.blockColoredStone.0.name", "Black Colored Stone");
		 * LanguageRegistry.instance().addStringLocalization("tile.blockColoredStone.1.name", "Red Colored Stone");
		 * LanguageRegistry.instance().addStringLocalization("tile.blockColoredStone.2.name", "Green Colored Stone");
		 * LanguageRegistry.instance().addStringLocalization("tile.blockColoredStone.3.name", "Blue Colored Stone");
		 *
		 * LanguageRegistry.addName(new ItemStack(blockColoredStone, 1, 0), "Black Colored Stone");
		 * LanguageRegistry.addName(new ItemStack(blockColoredStone, 1, 1), "Red Colored Stone");
		 * LanguageRegistry.addName(new ItemStack(blockColoredStone, 1, 2), "Green Colored Stone");
		 * LanguageRegistry.addName(new ItemStack(blockColoredStone, 1, 3), "Blue Colored Stone");
		 */
	}
}
