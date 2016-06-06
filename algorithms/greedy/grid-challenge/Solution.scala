object Solution {

    def main(args: Array[String]) {
        val it = scala.io.Source.stdin.getLines
        val t = it.next.toInt
        for(_ <- 1 to t) {
            val n = it.next.toInt
            val l = for(_ <- 1 to n) yield it.next.trim.sorted

            def check(i:Int, j:Int):Boolean = (i,j) match {
                case (_i,_j) if(_i < n-1 && j < n && l(i)(j) <= l(i+1)(j)) => check(i,j+1)
                case (_i,_j) if(_i == n-1) => true
                case (_i,_j) if(_j == n) => check(i+1, 0)
                case _ => false
            }

            println(check(0,0) match {case true => "YES" case false => "NO"})

        }
    }
}
