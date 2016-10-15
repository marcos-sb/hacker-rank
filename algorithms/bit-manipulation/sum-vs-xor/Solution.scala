object Solution extends App {
  val it = io.Source.stdin.getLines
  val n = it.next.trim.toLong
  var zeroes = 0l
  var _n = n
  while(_n != 0) {
    zeroes += (if((_n & 1) == 0) 1 else 0)
    _n >>>= 1
  }
  println(math.pow(2,zeroes).toLong)
}
