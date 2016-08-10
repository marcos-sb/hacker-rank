object Solution extends App {
  val it = io.Source.stdin.getLines
  val n = it.next.toInt
  val clouds = it.next.split(" ").map(_.toInt)
  def go(_n: Int, jumps:Int):Int = {
    if(_n < 0 || clouds(_n) == 1) return n
    if(_n == 0) return jumps
    math.min(go(_n - 1, jumps + 1),go(_n - 2, jumps + 1))
  }
  println(go(n-1,0))
}
