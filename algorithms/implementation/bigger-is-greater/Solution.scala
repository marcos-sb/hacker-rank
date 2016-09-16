object Solution extends App {
  val it = io.Source.stdin.getLines
  val t = it.next.trim.toInt
  for(_ <- 0 until t) {
    val s = it.next.toCharArray
    var i = s.length-1
    while(i > 0 && s(i-1) >= s(i)) i -= 1
    val spos = math.max(i-1,0)
    val charToSurpass = s(spos)
    var newMax = Int.MaxValue
    var newMaxPos = -1
    for(j <- s.indices.drop(spos)) {
      if(s(j) > charToSurpass && s(j) < newMax) {
        newMax = s(j)
        newMaxPos = j
      }
    }
    if(newMaxPos == -1) println("no answer")
    else {
      val suffix = s.subSequence(spos,newMaxPos).toString + s.subSequence(newMaxPos + 1,s.length)
      val sb = new StringBuilder(s.subSequence(0,spos).toString)
      sb.append(s(newMaxPos))
      sb.append(suffix.sorted)
      println(sb.toString)
    }
  }
}
