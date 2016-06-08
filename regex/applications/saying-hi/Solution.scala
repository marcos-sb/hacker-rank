object Solution {

    def main(args: Array[String]) {
        val it = scala.io.Source.stdin.getLines
        val n = it.next.toInt
        val regex = """(?i)^hi\s(?!d).*""".r

        val res = it.filter {
            case regex(_*) => true
            case _ => false
        }
        res.foreach(println)
    }
}
