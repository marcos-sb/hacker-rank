object Solution {

    def main(args: Array[String]) {
        val it = scala.io.Source.stdin.getLines
        val n = it.next.toInt
        val arr = new Array[Int](n);

        val values = it.next.split(" ").map(_.toInt)
        for(i <- n-1 to 0 by -1) {
           print(values(i) + " ")
        }
    }
}
