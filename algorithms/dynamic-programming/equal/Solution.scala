object Solution extends App {
  val it = io.Source.stdin.getLines
  val t = it.next.trim.toInt
  for(_ <- 0 until t) {
    val _ = it.next
    val arr = it.next.split(" ").map(_.toInt)
    val min = arr.min
    val mins = Array(min,min-1,min-2).filter(_ >= 0)
    var minTotalOps = Int.MaxValue
    for(m <- mins) {
      var totalOps = 0
      for(n <- arr) {
        val diff = n - m
        val div5 = diff / 5
        val diff5 = diff - div5 * 5
        val div2 = diff5 / 2
        val diff2 = diff5 - div2 * 2
        val div1 = diff2
        totalOps += div5 + div2 + div1
      }
      minTotalOps = math.min(minTotalOps,totalOps)
    }
    println(minTotalOps)
  }
}
