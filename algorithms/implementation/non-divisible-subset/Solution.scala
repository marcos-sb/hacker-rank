
object Solution {
  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val Array(n,k) = it.next.split(" ").map(_.toInt)
    val arr = it.next.trim.split(" ").map(_.toInt)
    val mods = arr.groupBy(_n => _n % k).mapValues(_.length)
    var count = 0
    if(k == 1) count = 1
    else {
      if(k % 2 != 0) {
        for(i <- 1 to k/2) {
          count += math.max(mods.getOrElse(i,0),mods.getOrElse(k-i,0))
        }
      } else {
        for(i <- 1 until k/2)
          count += math.max(mods.getOrElse(i,0),mods.getOrElse(k-i,0))
        if(mods(k/2) > 0)
          count += 1
      }
      if(mods.getOrElse(0,0) > 0) count += 1
    }
    println(count)
  }
}
