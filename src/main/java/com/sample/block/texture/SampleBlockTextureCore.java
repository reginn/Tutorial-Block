package com.sample.block.texture;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = SampleBlockTextureCore.MODID, version = SampleBlockTextureCore.VERSION)
public class SampleBlockTextureCore
{
	public static final String MODID = "BlockTexture";
	public static final String VERSION = "0.0.0";

	public static Block blockUsesVanillaTexture;
	public static Block blockUsesCustomTexture;
	public static Block blockUsesColorMultiplier;
	public static Block blockUsesComplexTexture;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * バニラのテクスチャを利用する場合.
		 * アイテムの場合と同様に, setTextureNameでテクスチャの名前を指定する.
		 * ブロックの場合, minecraft.jar内のassets/minecraft/textures/blocksを参照する.
		 * 拡張子(.png)は不要な点に注意.
		 */
		blockUsesVanillaTexture = (new BlockTexture(Material.field_151576_e))
				.func_149663_c("blockUsesVanillaTexture")
				.func_149658_d("log_oak")
				.func_149647_a(CreativeTabs.tabBlock);

		/*
		 * 独自のテクスチャを利用する場合.
		 * アイテムの場合と同様に, setTextureNameでdomain:テクスチャ名で指定する.
		 * domainはbin/minecraft/assets/domain/textures/のようにassets以下のフォルダを指定するもの.
		 * サンプルの場合, 画像ファイルはbin/minecraft/assets/custom/textures/blocks/cross.pngが参照される.
		 * eclipseでの実行の場合, eclipse/minecraft/bin/assets/custom/textures/blocks/cross.pngが参照される.
		 * 拡張子(.png)は不要な点に注意
		 */
		blockUsesCustomTexture = (new BlockTexture(Material.field_151576_e))
				.func_149663_c("blockUsesCustomTexture")
				.func_149658_d("texture:cross")
				.func_149647_a(CreativeTabs.tabBlock);

		/*
		 * 基本は今までどおり, BlockクラスではなくBlockクラスを継承したBlockColorMultiplierクラスからインスタンスを生成する.
		 */
		blockUsesColorMultiplier = (new BlockColorMultiplier(Material.field_151576_e))
				.func_149663_c("blockUsesColorMultiplier")
				.func_149658_d("cobblestone")
				.func_149647_a(CreativeTabs.tabBlock);

		/*
		 * 基本はいままでどおり, BlockクラスではなくBlockクラスを継承したBlockComplexTextureクラスからインスタンスを生成する.
		 * 今回はsetTextureNameで指定したテクスチャをブロックの上下に, BlockComplexTexture内で追加したテクスチャを四方に設定している.
		 */
		blockUsesComplexTexture = (new BlockComplexTexture(Material.field_151576_e))
				.func_149663_c("blockUsesComplexTexture")
				.func_149658_d("cobblestone")
				.func_149647_a(CreativeTabs.tabBlock);

		GameRegistry.registerBlock(blockUsesVanillaTexture, "blockUsesVanillaTexture");
		GameRegistry.registerBlock(blockUsesCustomTexture,  "blockUsesCustomTexture");
		GameRegistry.registerBlock(blockUsesColorMultiplier, "blockUsesColorMultiplier");
		GameRegistry.registerBlock(blockUsesComplexTexture, "blockUsesComplexTexture;");

		/*
		 * langファイルによるローカライズのみになったため不要
		 *
		 * LanguageRegistry.addName(blockUsesVanillaTexture, "Sample Block Uses Vanilla Texture");
		 * LanguageRegistry.addName(blockUsesCustomTexture,  "Sample Block Uses Custom Texture");
		 * LanguageRegistry.addName(blockUsesColorMultiplier, "Sample Block Uses Color Multiplier");
		 * LanguageRegistry.addName(blockUsesComplexTexture, "Sample Block Uses Complex Texture");
		 */
	}
}
