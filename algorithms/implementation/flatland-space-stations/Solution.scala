object Solution extends App {
  val it = io.Source.stdin.getLines
  val Array(n,m) = it.next.split(" ").map(_.toInt)
  val sstations = it.next.split(" ").map(_.toInt).sorted
  var maxDist = 0
  for(i <- sstations.indices.drop(1))
    maxDist = math.max(maxDist,math.abs(sstations(i-1) - sstations(i))/2)
  maxDist = math.max(maxDist,math.abs(sstations.head - 0))
  maxDist = math.max(maxDist,math.abs(sstations.last - (n-1)))
  println(maxDist)
}
