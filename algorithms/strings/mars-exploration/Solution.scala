object Solution extends App {
  val it = io.Source.stdin.getLines
  val s = it.next.trim
  var diffs = 0
  for(i <- 0 until s.length - 2 by 3) {
    if(s(i) != 'S') diffs += 1
    if(s(i+1) != 'O') diffs += 1
    if(s(i+2) != 'S') diffs += 1
  }
  println(diffs)
}
