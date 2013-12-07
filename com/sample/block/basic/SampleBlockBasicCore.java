package com.sample.block.basic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid   = "BlockBasic",
	name    = "BlockBasic",
	version = "0.0.0"
)
public class SampleBlockBasicCore {

	public static Block blockBasic;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * 無機能ブロックのインスタンスを生成する.
		 * Blockの引数は(ブロックID, Material).
		 * Materialはブロックに素材の特性を与えるためのもの. 木製ならwood, 岩石ならrockなどにする.
		 * 今回はrockにしている.
		 * クリエイティブタブのBlockタブに追加している.
		 */
		blockBasic = (new Block(4000, Material.rock))
				.setUnlocalizedName("blockBasic")
				.setCreativeTab(CreativeTabs.tabBlock);

		LanguageRegistry.addName(blockBasic, "Sample Block Basic");

		/*
		 * ブロックの追加はアイテムと異なり, 以下のメソッドで登録する必要がある.
		 * registerBlockの引数は(ブロックのインスタンス, そのブロックの名前)である.
		 */
		GameRegistry.registerBlock(blockBasic, "blockBasic");
	}
}
