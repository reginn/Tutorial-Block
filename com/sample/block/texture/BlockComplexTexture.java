package com.sample.block.texture;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockComplexTexture extends Block {

	/*
	 * 四方(東西南北)のテクスチャ.
	 * クライアントのみなのでSideOnlyアノテーションの付与が必要.
	 */
	@SideOnly(Side.CLIENT)
	private Icon sidedIcon;

	/*
	 * コンストラクタはブロックIDとMaterialをスーパークラスのコンストラクタに渡すだけ.
	 */
	public BlockComplexTexture(int blockID, Material material) {
		super(blockID, material);
	}

	/*
	 * テクスチャを読み込むメソッド. 基本的にはアイテムの場合と同じ.
	 * super.registerIcons()はsetTextureNameで指定したファイルを読み込むのに必要.
	 * iconRegister.registerIconは四方のテクスチャを読み込むのに利用.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		super.registerIcons(iconRegister);
		this.sidedIcon = iconRegister.registerIcon("log_oak");
	}

	/*
	 * 面によって利用するアイコンを変更するメソッド.
	 * 引数のsideはブロックの上下東西南北(0~5の整数), metaはブロックのメタデータ.
	 * 上下東西南北を0~5で表すのはわかりづらいので, ここではForgeDirectionで定義されるEnum定数を利用している.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		/*
		 * 描画する面が上下の場合, 丸石のテクスチャに, 四方の場合原木のテクスチャにしている.
		 */
		if (side == ForgeDirection.UP.ordinal() || side == ForgeDirection.DOWN.ordinal()) {
			return this.blockIcon;
		}
		return this.sidedIcon;
	}


}
