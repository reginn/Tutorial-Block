package com.sample.block.basic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/*
 * Blockのコンストラクタがprotectedになっているので,
 * 初期化用の単純なクラスを作る.
 */
public class BlockBasic extends Block {
	public BlockBasic(Material material) {
		super(material);
	}
}
