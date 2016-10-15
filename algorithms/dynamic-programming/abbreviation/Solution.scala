object Solution extends App {
  val it = io.Source.stdin.getLines
  val q = it.next.toInt
  def go(ia:Int,ib:Int,_a:String,_b:String):Boolean = {
    if(ib == _b.length) {
      for(i <- ia until _a.length)
        if(_a(i).isUpper) return false
      return true
    }
    if(ia >= _a.length) return false
    val cau = _a(ia).toUpper
    if(cau != _b(ib))
      _a(ia).isLower && go(ia+1,ib,_a,_b)
    else
      go(ia+1,ib+1,_a,_b) || go(ia+1,ib,_a,_b)
  }
  for(_ <- 0 until q) {
    val a = it.next.trim
    val b = it.next.trim
    if(go(0,0,a,b)) println("YES")
    else println("NO")
  }
}
