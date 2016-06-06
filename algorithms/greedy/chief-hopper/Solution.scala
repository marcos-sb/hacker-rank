object Solution {
  def main(args: Array[String]):Unit = {
    def halfCeil(n:Int):Int = {
      val halfN = n / 2
      if(n % 2 == 0) halfN
      else halfN + 1
    }
      val it = io.Source.stdin.getLines
    val n: Int = it.next.toInt
    val arr: Array[Int] = it.next.split(" ").map(_.toInt)
    var best = halfCeil(arr(n-1))
    for (i <- n-2 to 0 by -1) {
      if(arr(i) > best) best += halfCeil(arr(i) - best)
      else best -= (best - arr(i)) / 2
    }
    println(best)
  }
}
