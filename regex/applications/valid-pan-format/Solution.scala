object Solution {

    def main(args: Array[String]) {
        val panReg = """[A-Z]{5}\d{4}[A-Z]""".r

        val it:Iterator[String] = scala.io.Source.stdin.getLines
        val n:Int = it.next.toInt

        val res = for(s <- it) yield {
            s match {
                case panReg(_*) => "YES"
                case _ => "NO"
            }
        }
        res.foreach(println)
    }
}
