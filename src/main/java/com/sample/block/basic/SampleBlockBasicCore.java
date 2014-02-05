package com.sample.block.basic;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = SampleBlockBasicCore.MODID, version = SampleBlockBasicCore.VERSION)
public class SampleBlockBasicCore
{
	public static final String MODID   = "BlockBasic";
	public static final String VERSION = "0.0.0";

	public static Block blockBasic;

	/*
	 * Blockなどの登録はpreInitで行うことになった.
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * 無機能ブロックのインスタンスを生成する.
		 * Blockの引数は(ブロックID, Material).
		 * Materialはブロックに素材の特性を与えるためのもの. 木製ならwood, 岩石ならrockなどにする.
		 * 今回はrockにしている.
		 * クリエイティブタブのBlockタブに追加している.
		 */
		blockBasic = (new BlockBasic(Material.rock))
				.setBlockName("blockBasic")
				.setCreativeTab(CreativeTabs.tabBlock);

		/*
		 * ブロックの追加はアイテムと異なり, 以下のメソッドで登録する必要がある.
		 * registerBlockの引数は(ブロックのインスタンス, そのブロックの名前)である.
		 * 1.7からはこのメソッドで登録すれば自動でIDを割り当てるようになった.
		 * もし1.6以前のワールドからの互換性を考慮するならGameData.blockRegistry.add()メソッドを使うべきである.
		 */
		GameRegistry.registerBlock(blockBasic, "blockBasic");

		/*
		 * ブロックの名前はlangファイルで行うようになった.
		 * assets/basic/lang/en_US.langを参照のこと.
		 * LanguageRegistry.addName(blockBasic, "Sample Block Basic");
		 */
	}
}
