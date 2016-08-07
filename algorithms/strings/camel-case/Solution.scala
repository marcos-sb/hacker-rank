object Solution extends App {
  val s = io.Source.stdin.getLines.next.trim
  var n = 1
  for(c <- s) {
    if(c.isUpper) n += 1
  }
  println(n)
}
