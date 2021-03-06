[PiLangXに追加実装した機能]

[発展演習22  発展演習14, 15での追加機能の追加]
実装した演算子の仕様はTinyPiSXのものと同じであるため, 以下を参照.
  TinyPiSX/doc/README.TXT
  
--------------------------------------------------------------

[発展演習23  ローカル変数の自動初期化]
ローカル変数として宣言された変数に初期値としてあらかじめ0を代入する.

これは宣言した際に変数の値を保存する場所として
各変数に割り振られるメモリの番地に変数宣言時に0をいれることで実現している.

テストプログラム
  PiLangX/test/231.pix    代入をしない変数を扱うプログラム
  
  --------------------------------------------------------------
  
  [発展演習24  while文を抜けるbreak文の実装]
while文から強制的に抜ける文である.
while文の中および　while文の中にあるif文に書くことができる.
while文の中のif文に書いた場合, break文が実行されるとそのif文を含むwhile文から抜け出す.
break文以降でwhile文中に書かれた処理は行われない.

インタプリタでは
  returnで値を返すときに用いるReturnValueクラスを継承したBreakValueクラスを実装し,
  break文が呼ばれた際にReturnValueクラスのオブジェクトを戻り値として返す代わりに
  BreakValueクラスのオブジェクトを返し, 返ってきたオブジェクトがBreakValueクラスのオブジェクトであれば
  break文以降の処理を行わないようにしている.

コンパイラでは
  while文を抜け出す際に用いるLabelをwhile文中の処理を行う際に覚えておき,
  break文が呼ばれた場合, そのLabelへ飛ぶことでwhile文から抜ける処理を実現している.

テストプログラム
  PiLangX/test/241.pix    while文中でbreak文を用いるプログラム
  PiLangX/test/242.pix    while文中のif文でbreak文を用いるプログラム
  
  