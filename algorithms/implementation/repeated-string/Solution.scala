object Solution extends App {
  val it = io.Source.stdin.getLines
  val s = it.next.trim
  val n = it.next.trim.toLong
  var asInS = 0
  for(c <- s)
    if(c == 'a') asInS += 1
  val div = n / s.length
  val mod = (n % s.length).toInt
  var modAs = 0
  for(c <- s.take(mod))
    if(c == 'a') modAs += 1
  val totalAs = asInS * div + modAs

  println(totalAs)
}
