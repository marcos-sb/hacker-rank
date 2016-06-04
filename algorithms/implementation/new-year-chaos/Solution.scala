
object Solution {

  def mergecount(arr: Array[Int], lo: Int, hi: Int):Int = {
    val filtered = (for(i <- arr.indices) yield {
      arr(i) - 1 - i
    }).count(_ > 2)
    if(filtered > 0) return -1

    val tmp = arr.clone
    var invs = 0

    def goMerge(_lo:Int, _mid:Int, _hi:Int) = {
      var i = _lo
      var j = _mid+1
      for(k <- _lo to _hi) {
        if(i > _mid) {
          tmp(k) = arr(j)
          j += 1
        } else if(j > _hi) {
          tmp(k) = arr(i)
          i += 1
        } else if(arr(i) <= arr(j)) {
          tmp(k) = arr(i)
          i += 1
        } else {
          tmp(k) = arr(j)
          j += 1
          invs += _mid - i + 1
        }
      }
      for(i <- _lo to _hi) arr(i) = tmp(i)
      invs
    }

    def goSort(_lo: Int, _hi: Int): Int = {
      if(_lo >= _hi) invs
      else {
        val mid = _lo + (_hi - _lo)/2
        goSort(_lo, mid)
        goSort(mid+1,_hi)
        goMerge(_lo, mid, _hi)
        invs
      }
    }

    goSort(0, arr.length - 1)
  }

  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val t = it.next.toInt
    for(_ <- 0 until t) {
      it.next.toInt
      val ids = it.next.split(" ").map(_.toInt)
      println(mergecount(ids, 0, ids.length - 1) match {
        case -1 => "Too chaotic"
        case x => x
      })
    }
  }

}
