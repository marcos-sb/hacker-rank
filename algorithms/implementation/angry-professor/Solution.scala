object Solution {

    def main(args: Array[String]) {
        val it = io.Source.stdin.getLines
        val t = it.next.toInt
        val cancel = for(_ <- 1 to t) yield {
            val k = it.next.split(" ")(1).toInt
            val beforeCount = it.next.split(" ").map(_.toInt).filter(_ <= 0).length
            beforeCount < k
        }
        cancel.map({case true => "YES" case false => "NO"}).foreach(println)
    }
}
