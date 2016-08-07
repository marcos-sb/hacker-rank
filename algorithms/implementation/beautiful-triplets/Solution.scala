object Solution extends App {
  val it = io.Source.stdin.getLines
  val Array(n,d) = it.next.split(" ").map(_.toInt)
  val arr = it.next.split(" ").map(_.toInt)
  val s = Set[Int](arr : _*)
  var count = 0
  for(i <- arr) {
    if(s.contains(i + d) && s.contains(i + 2*d)) count += 1
  }
  println(count)
}
