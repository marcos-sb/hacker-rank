object Solution extends App {
  val it = io.Source.stdin.getLines
  val n = it.next.toInt
  for(_ <- 0 until n) {
    val s = it.next.trim()
    val dic = Array.ofDim[Boolean]('z' - 'a' + 1)
    var cost = 0
    for(c <- s) {
      if(!dic(c-'a')) {
        dic(c-'a') = true
        cost += 1
      }
    }
    println(cost)
  }
}
