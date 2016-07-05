import util.Sorting

object Solution {
  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val _ = it.next.toInt
    val arr = it.next.split(" ").map(_.toInt).zipWithIndex
    Sorting.quickSort(arr)
    var min = Int.MaxValue
    for(i <- arr.indices.dropRight(1)) {
      val x0 = arr(i)
      val x1 = arr(i+1)
      if(x0._1 == x1._1)
        min = math.min(math.abs(x0._2 - x1._2), min)
    }
    if(min == Int.MaxValue) println("-1")
    else println(min)
  }
}
