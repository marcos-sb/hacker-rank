object Solution {
  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val t = it.next.trim.toInt
    for(_ <- 0 until t) {
      val Array(n,m,s) = it.next.trim.split(" ").map(_.toInt)
      val prisonerId = (s + m - 2) % n + 1
      println(prisonerId)
    }
  }
}
