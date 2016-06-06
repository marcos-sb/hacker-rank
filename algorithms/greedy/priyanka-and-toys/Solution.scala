object Solution {

    def main(args: Array[String]) {
        val it = io.Source.stdin.getLines
        val n = it.next.toInt
        val ws = it.next.split(' ').map(_.toInt).sorted

        def fetchfbf(i:Int, d:Int, cost: Int):Int = (i,d) match {
            case (_i,_d) if(_i+_d >= n) => cost
            case (_i,_d) if(ws(_i+_d) <= ws(i) + 4) => fetchfbf(_i,_d+1,cost)
            case _ => fetchfbf(i+d,1,cost+1)
        }

        println(fetchfbf(0,1,1))
    }
}
