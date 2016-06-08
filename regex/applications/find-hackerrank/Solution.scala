
object Solution {

    def main(args: Array[String]) {
        val start = "^hackerrank.*".r
        val end = ".*hackerrank$".r
        val startend = "^(hackerrank|hackerrank.*hackerrank)$".r

        val it:Iterator[String] = scala.io.Source.stdin.getLines
        val n:Int = it.next.toInt

        val res =
        for(s <- it) yield {
            s match {
                case startend(_*) => s"0"
                case start(_*) => s"1"
                case end(_*) => s"2"
                case _ => s"-1"
            }
        }
        res.foreach(println)
    }
}
