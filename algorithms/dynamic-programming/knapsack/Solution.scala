import collection.mutable

object Solution extends App {
  val it = io.Source.stdin.getLines
  val t = it.next.trim.toInt
  def optimize(arr:Array[Int],max:Int):Int = {
    val cache = mutable.Map[(Int,Int),Int]()
    def go(pos:Int,sum:Int): Int = {
      val ps = (pos,sum)
      if(sum > max) return 0
      if(sum == max) return sum
      if(!cache.contains(ps)) {
        var max = Int.MinValue
        for(i <- arr.indices) {
          val newMax = go(i,sum+arr(i))
          if(newMax == 0) max = math.max(max,sum)
          else max = math.max(max,go(i,sum+arr(i)))
        }
        cache += ps -> max
      }
      cache(ps)
    }
    go(0,0)
  }
  for(_ <- 0 until t) {
    val Array(_,max) = it.next.split(" ").map(_.toInt)
    val arr = it.next.split(" ").map(_.toInt)
    println(optimize(arr,max))
  }
}
