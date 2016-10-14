object Solution extends App {
  val it = io.Source.stdin.getLines
  val _ = it.next.trim.toInt
  val colors = it.next.split(" ").map(_.toInt)
  val byColor = Array.ofDim[Int](101)
  for(c <- colors)
    byColor(c) += 1
  var pairs = 0
  for(c <- byColor)
    pairs += c / 2
  println(pairs)
}
