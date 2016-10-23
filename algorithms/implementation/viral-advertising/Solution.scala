object Solution extends App {
  val it = io.Source.stdin.getLines
  var n = 5
  val m = it.next.trim.toInt
  var likes = 0
  for(i <- 0 until m) {
    likes += n / 2
    n += (n / 2) * 3
  }
  println(likes)
}
