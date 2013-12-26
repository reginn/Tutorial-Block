Tutorial-Block
==============

開発環境
* Minecraft 1.6.4
* Minecraft Forge #964
* IntelliJ IDEA 12.6

Eclipse+Forge#953以下向け:

src/main/java/comフォルダ以下をsrc/minecraft/にコピー.

src/main/resources/assetsフォルダをbin/minecraft/にコピー.

Eclipse上で実行する場合, assetsフォルダはeclipse/minecraft/bin/assets/にコピー.


IDEA+ForgeGradle向け:

root/srcに上書きするか, githubからclone→モジュール化しない→setting.gradleのincludeにディレクトリ名を追加

チュートリアル内容
==================

com.sample.block.basic

* ブロック追加の基本

com.sample.block.texture

* バニラのテクスチャを利用したブロックの追加
* 独自のテクスチャを利用したブロックの追加
* 色乗算を利用したブロックの追加
* 複数のテクスチャを利用したブロックの追加

com.sample.block.metadata

* 方向持ちブロックの追加
* 色違いブロックの追加
