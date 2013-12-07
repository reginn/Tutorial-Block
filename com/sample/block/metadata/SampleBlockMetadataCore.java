package com.sample.block.metadata;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid   = "BlockMetadata",
	name    = "BlockMetadata",
	version = "0.0.0"
)
public class SampleBlockMetadataCore {

	/*
	 * 東西南北の方向を持つ(かまどのような)ブロックの追加
	 * メタデータを利用した色違いブロックの追加
	 */
	public static Block blockDummyFurnace;
	public static Block blockColoredStone;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		/*
		 * Blockクラスを継承したBlockDummyFurnaceクラスからインスタンスを生成する.
		 * setTextureNameはやらない. 理由はBlockDummyFurnaceクラスを参照のこと.
		 */
		blockDummyFurnace = (new BlockDummyFurnace(4005, Material.rock))
				.setUnlocalizedName("blockDummyFurnace")
				.setCreativeTab(CreativeTabs.tabBlock);

		GameRegistry.registerBlock(blockDummyFurnace, "blockDummyFurnace");
		LanguageRegistry.addName(blockDummyFurnace, "Dummy Furnace");


		/*
		 * Blockクラスを継承したBlockColoredStoneクラスからインスタンスを生成する.
		 * 今回はメタデータを使って1つのブロックIDで4種類の黒, 赤, 青, 緑色の石を追加する.
		 */
		blockColoredStone = (new BlockColoredStone(4006, Material.rock))
				.setUnlocalizedName("blockColoredStone")
				.setTextureName("stone")
				.setCreativeTab(CreativeTabs.tabBlock);

		/*
		 * メタデータを使って1つのブロックIDで複数のブロックを扱う時は, registerBlockの第二引数にItemBlockないしItemBlockWithMetadataを継承したクラスを渡す.
		 */
		GameRegistry.registerBlock(blockColoredStone, ItemBlockColoredStone.class, "blockColoredStone");

		/*
		 * メタデータを使って1つのブロックIDで複数のブロックを扱う時は以下のように名前を登録する.
		 * もしくはunlocalized nameを使って以下のようにする.
		 * LanguageRegistry.instance().addStringLocalization("tile.blockColoredStone.0.name", "Black Colored Stone");
		 * LanguageRegistry.instance().addStringLocalization("tile.blockColoredStone.1.name", "Red Colored Stone");
		 * LanguageRegistry.instance().addStringLocalization("tile.blockColoredStone.2.name", "Green Colored Stone");
		 * LanguageRegistry.instance().addStringLocalization("tile.blockColoredStone.3.name", "Blue Colored Stone");
		 */
		LanguageRegistry.addName(new ItemStack(blockColoredStone, 1, 0), "Black Colored Stone");
		LanguageRegistry.addName(new ItemStack(blockColoredStone, 1, 1), "Red Colored Stone");
		LanguageRegistry.addName(new ItemStack(blockColoredStone, 1, 2), "Green Colored Stone");
		LanguageRegistry.addName(new ItemStack(blockColoredStone, 1, 3), "Blue Colored Stone");
	}
}
