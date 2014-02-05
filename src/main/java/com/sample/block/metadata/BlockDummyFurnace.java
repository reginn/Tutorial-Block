package com.sample.block.metadata;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockDummyFurnace extends Block
{
	/*
	 * 正面, 側面, 上下それぞれのテクスチャ
	 * 今回は可読性のためにBlockクラスのフィールドであるblockIconは利用しない.
	 * クライアントのみなのでSideOnlyアノテーションが必要.
	 */
	@SideOnly(Side.CLIENT)
	IIcon frontIcon;

	@SideOnly(Side.CLIENT)
	IIcon sideIcon;

	@SideOnly(Side.CLIENT)
	IIcon topIcon;

	/*
	 * コンストラクタ, Materialをスーパークラスのコンストラクタに渡すだけ.
	 */
	public BlockDummyFurnace(Material material)
	{
		super(material);
	}

	/*
	 * アイテムの場合と同様にテクスチャを読み込むメソッド.
	 * 今回はバニラのかまどのテクスチャをそのまま利用する.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.frontIcon = iconRegister.registerIcon("furnace_front_off");
		this.sideIcon  = iconRegister.registerIcon("furnace_side");
		this.topIcon   = iconRegister.registerIcon("furnace_top");
	}

	/*
	 * ワールドに設置されたブロックのテクスチャを返すメソッド.
	 * 引数のsideはブロックの面(0~5), 上下の場合はtopIconを返し,
	 * sideとブロックのメタデータが等しい場合frontIconを, それ以外はsideIconを返す.
	 * ここで取得するメタデータは後述のonBlockPlacedByメソッドで設定する.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess iBlockAccess, int x, int y, int z, int side)
	{
		/*
		 * ForgeDirectionのEnum定数を利用しているが, 可読性に拘らなければ以下のようにしてもよい.
		 * if (side == 0 || side == 1)
		 */
		if (side == ForgeDirection.UP.ordinal() || side == ForgeDirection.DOWN.ordinal())
		{
			return this.topIcon;
		}
		int meta = iBlockAccess.getBlockMetadata(x, y, z);
		/*
		 * 三項演算子, 以下と同等
		 * if (side == meta) {
		 *     return this.frontIcon;
		 * } else {
		 *     return this.sideIcon;
		 * }
		 */
		return side == meta ? this.frontIcon : this.sideIcon;
	}

	/*
	 * インベントリでのテクスチャを返すメソッド.
	 * インベントリでは向きが固定なので, 特定の面(ForgeDirection.SOUTH)のみfrontIconを返している.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		/*
		 * if (side == 0 || side == 1)と等価
		 */
		if (side == ForgeDirection.UP.ordinal() || side == ForgeDirection.DOWN.ordinal())
		{
			return this.topIcon;
		}
		/*
		 * if (side == 3) {
		 *     return this.frontIcon;
		 * } else {
		 *     return this.sideIcon;
		 * }
		 * と等価
		 */
		return side == ForgeDirection.SOUTH.ordinal() ? this.frontIcon : this.sideIcon;
	}

	/*
	 * (大抵の場合は)プレイヤーがブロックを設置したときに呼ばれるメソッド.
	 * 引数は(world, x, y, z, EntityLiving(大抵はプレイヤー), プレイヤーが設置したときに手に持ってるItemStack).
	 * プレイヤーが持っているItemStackをworld内の座標(x, y, z)に設置したときに呼ばれる.
	 */
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
	{
		/*
		 * プレイヤーの向いている方向(東西南北)を求める.
		 * やっていることは単純で, プレイヤーの向いている体の向きを東西南北(0~3)に変換しているだけ.
		 */
		int playerDir = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		/*
		 * プレイヤーの向きとブロックの向きを対応させる配列.
		 * バニラのかまどのソースコードと対比させた場合
		 * プレイヤーの向き : 0 1 2 3
		 *    かまどの向き: 2 5 3 4
		 * 上記の方法ではわかりにくいので, ForgeDirectionを使って向きを見やすくしている.
		 */
		ForgeDirection[] blockDir = {ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH, ForgeDirection.WEST};

		/*
		 * プレイヤーの向きと対応するブロックの向きをメタデータとして設定する.
		 * このときブロックの向き=メタデータなので, 先述のgetBlockTextureでは面とメタデータが一致する場合にfrontIconを返すようにしている.
		 */
		world.setBlockMetadataWithNotify(x, y, z, blockDir[playerDir].ordinal(), 2);
	}
}
