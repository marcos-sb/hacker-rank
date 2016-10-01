object Solution extends App {
  val it = io.Source.stdin.getLines
  val Array(_,k) = it.next.split(" ").map(_.toInt)
  var i = -1
  val sumNoK = it.next.split(" ").map(_.toInt)
    .filter(el => {i += 1; i != k}).sum / 2
  val b = it.next.toInt
  val diff = b - sumNoK
  if(diff > 0) println(diff)
  else println("Bon Appetit")
}
