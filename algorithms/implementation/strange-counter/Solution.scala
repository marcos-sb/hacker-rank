object Solution extends App {
  val it = io.Source.stdin.getLines
  val t = it.next.toLong
  var i = 1L
  var d = 3L
  while(i <= t) {
    i += d
    d *= 2
  }
  d /= 2
  i -= d
  println(d - (t - i))
}
