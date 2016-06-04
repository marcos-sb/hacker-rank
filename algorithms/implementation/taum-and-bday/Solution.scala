object Solution {

    def main(args: Array[String]) {
        val it = io.Source.stdin.getLines
        val t = it.next.toInt
        val minUnits = for(_ <- 1 to t) yield {
            val b_w = it.next.split(" ").map(_.toLong)
            val x_y_z = it.next.split(" ").map(_.toLong)
            val xFromy:Long = x_y_z(1) + x_y_z(2)
            val yFromx:Long = x_y_z(0) + x_y_z(2)
            val best_x:Long = math.min(x_y_z(0),xFromy)
            val best_y:Long = math.min(x_y_z(1),yFromx)
            b_w(0) * best_x + b_w(1) * best_y
        }
        minUnits.foreach(println)
    }
}
