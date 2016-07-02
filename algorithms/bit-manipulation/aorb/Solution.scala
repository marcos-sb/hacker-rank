
import collection.immutable.Stream

object Solution {

  private val hexToBinStr =
    (for(hex <- ('0' to '9') ++ ('A' to 'F')) yield
      (hex,padString(Integer.parseInt(hex.toString,16).toBinaryString, 4))).toMap

  private val binStrToHex =
    (for(i <- 0 until 16) yield
      (padString(i.toBinaryString,4),i.toHexString.toUpperCase.head)).toMap

  private def padString(s:String,padSz:Int) = {
    if(s.length >= padSz) s
    else "0" * (padSz - s.length) + s
  }

  private def changeABRed(a:String,b:String,
      c:String,k:Int,changes:Int):(Int,String,String) = {
    val sbc = c.toCharArray
    val sbb = b.toCharArray
    val sba = a.toCharArray
    var _changes = changes
    for(i <- 0 until a.length) { //reduce A
      if(_changes == k)
        return (_changes, sba.mkString, sbb.mkString)
      (a(i),b(i),c(i)) match {
        case ('1','0','1') if _changes + 2 <= k =>
          sba(i) = '0'
          sbb(i) = '1'
          _changes += 2
        case ('1','1','1') =>
          sba(i) = '0'
          _changes += 1
        case _ =>
      }
    }
    (_changes, sba.mkString, sbb.mkString)
  }

  private def changeAB(a:String,b:String,c:String,k:Int,changes:Int)
    :(Int,String,String) = {
    val sbc = c.toCharArray
    val sbb = b.toCharArray
    val sba = a.toCharArray
    var _changes = changes
    for(i <- 0 until a.length) { //required changes
      if(_changes > k)
        return (_changes, sba.mkString, sbb.mkString)
      (a(i),b(i),c(i)) match {
        case ('0','0','0') =>
        case ('0','0','1') =>
          sbb(i) = '1'
          _changes += 1
        case ('0','1','0') =>
          sbb(i) = '0'
          _changes += 1
        case ('0','1','1') =>
        case ('1','0','0') =>
          sba(i) = '0'
          _changes += 1
        case ('1','0','1') => //*******
        case ('1','1','0') =>
          sba(i) = '0'
          sbb(i) = '0'
          _changes += 2
        case ('1','1','1') => //*******
        case _ =>
      }
    }
    (_changes,sba.mkString,sbb.mkString)
  }

  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val q = it.next.trim.toInt
    for(_ <- 0 until q) {
      val k = it.next.trim.toInt
      val a = it.next.trim
      val b = it.next.trim
      val c = it.next.trim
      val longest = math.max(math.max(a.length,b.length),c.length)
      val pa = padString(a,longest).toCharArray
      val pb = padString(b,longest).toCharArray
      val pc = padString(c,longest).toCharArray
      var changes = 0
      Stream.range(0, longest).takeWhile(_ => changes <= k)
        .foreach { i =>
          val ba = hexToBinStr(pa(i))
          val bb = hexToBinStr(pb(i))
          val bc = hexToBinStr(pc(i))
          val (totalChanges,ra,rb) = changeAB(ba,bb,bc,k,changes)
          changes = totalChanges
          pa(i) = binStrToHex(ra)
          pb(i) = binStrToHex(rb)
      }
      if(changes > k) println("-1")
      else {
        Stream.range(0, longest).takeWhile(_ => changes < k)
          .foreach { i =>
            val ba = hexToBinStr(pa(i))
            val bb = hexToBinStr(pb(i))
            val bc = hexToBinStr(pc(i))
            val (totalChanges,ra,rb) = changeABRed(ba,bb,bc,k,changes)
            changes = totalChanges
            pa(i) = binStrToHex(ra)
            pb(i) = binStrToHex(rb)
        }
        println(pa.mkString.replaceFirst("^0+(?!$)",""))
        println(pb.mkString)
      }
    }
  }
}
