object Solution {

  def main(args:Array[String]) = {
    val it:Iterator[String] = scala.io.Source.stdin.getLines
    val n:Int = it.next.toInt
    val hrRE = "(?i).*hackerrank.*".r

    val res:Iterator[Int] = for(s <- it) yield {
      s match {
        case hrRE(_*) => 1
        case _ => 0
      }
    }
    println(res.sum)
  }
}
