package com.sample.block.texture;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "BlockTexture",
	name  = "BlockTexture",
	version = "0.0.0"
)
public class SampleBlockTextureCore {

	public static Block blockUsesVanillaTexture;
	public static Block blockUsesCustomTexture;
	public static Block blockUsesColorMutiplier;
	public static Block blockUsesComplexTexture;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		/*
		 * バニラのテクスチャを利用する場合.
		 * アイテムの場合と同様に, setTextureNameでテクスチャの名前を指定する.
		 * ブロックの場合, minecraft.jar内のassets/minecraft/textures/blocksを参照する.
		 * 拡張子(.png)は不要な点に注意.
		 */
		blockUsesVanillaTexture = (new Block(4001, Material.rock))
				.setUnlocalizedName("blockUsesVanillaTexture")
				.setTextureName("log_oak")
				.setCreativeTab(CreativeTabs.tabBlock);

		/*
		 * 独自のテクスチャを利用する場合.
		 * アイテムの場合と同様に, setTextureNameでdomain:テクスチャ名で指定する.
		 * domainはbin/minecraft/assets/domain/textures/のようにassets以下のフォルダを指定するもの.
		 * サンプルの場合, 画像ファイルはbin/minecraft/assets/custom/textures/blocks/cross.pngが参照される.
		 * eclipseでの実行の場合, eclipse/minecraft/bin/assets/custom/textures/blocks/cross.pngが参照される.
		 * 拡張子(.png)は不要な点に注意
		 */
		blockUsesCustomTexture = (new Block(4002, Material.rock))
				.setUnlocalizedName("blockUsesCustomTexture")
				.setTextureName("block:cross")
				.setCreativeTab(CreativeTabs.tabBlock);

		/*
		 * 基本は今までどおり, BlockクラスではなくBlockクラスを継承したBlockColorMutiplierクラスからインスタンスを生成する.
		 */
		blockUsesColorMutiplier = (new BlockColorMultiplier(4003, Material.rock))
				.setUnlocalizedName("blockUsesColorMultiplier")
				.setTextureName("cobblestone")
				.setCreativeTab(CreativeTabs.tabBlock);

		/*
		 * 基本はいままでどおり, BlockクラスではなくBlockクラスを継承したBlockComplexTextureクラスからインスタンスを生成する.
		 * 今回はsetTextureNameで指定したテクスチャをブロックの上下に, BlockComplexTexture内で追加したテクスチャを四方に設定している.
		 */
		blockUsesComplexTexture = (new BlockComplexTexture(4004, Material.rock))
				.setUnlocalizedName("blockUsesComplexTexture")
				.setTextureName("cobblestone")
				.setCreativeTab(CreativeTabs.tabBlock);

		GameRegistry.registerBlock(blockUsesVanillaTexture, "blockUsesVanillaTexture");
		GameRegistry.registerBlock(blockUsesCustomTexture,  "blockUsesCustomTexture");
		GameRegistry.registerBlock(blockUsesColorMutiplier, "blockUsesColorMultiplier");
		GameRegistry.registerBlock(blockUsesComplexTexture, "blockUsesComplexTexture;");

		LanguageRegistry.addName(blockUsesVanillaTexture, "Sample Block Uses Vanilla Texture");
		LanguageRegistry.addName(blockUsesCustomTexture,  "Sample Block Uses Custom Texture");
		LanguageRegistry.addName(blockUsesColorMutiplier, "Sample Block Uses Color Multipler");
		LanguageRegistry.addName(blockUsesComplexTexture, "Sample Block Uses Complex Texture");
	}
}
