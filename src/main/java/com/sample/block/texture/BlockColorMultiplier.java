package com.sample.block.texture;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockColorMultiplier extends Block {

	/*
	 * コンストラクタはブロックIDとMaterialをスーパークラスのコンストラクタに渡すだけ
	 */
	public BlockColorMultiplier(int blockID, Material material) {
		super(blockID, material);
	}

	/*
	 * インベントリ内での色乗算用のメソッド. RGBのカラーコードを返す.
	 * 0xFFFFFFとして返せるが, マイクラ内の仕様は0xRRBBGGである点に注意.
	 * 引数がメタデータの値なので, 今回は利用していないが, メタデータに対応してカラーコードを変えることも可能.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int meta) {
		return 0xEE1111;
	}

	/*
	 * ワールドに設置されたブロックの色乗算用のメソッド. RGBのカラーコードを返す.
	 * 引数のIBlockAccessはWorldクラスのインタフェース. よってiBlockAccess.getBlockMetadata(x,y,z)でメタデータがとれる.
	 * 引数の(x, y, z)はブロックが設置されている座標. 特定の座標のときのみ別のカラーコードを返すことも可能.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess iBlockAccess, int x, int y, int z) {
		return 0xEE1111;
	}
}
