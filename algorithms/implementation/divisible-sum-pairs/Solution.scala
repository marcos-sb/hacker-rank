
object Solution {
  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val Array(n,k) = it.next.split(" ").map(_.toInt)
    val arr = it.next.trim.split(" ").map(_.toInt)
    val psarr =
      for(i <- 0 until arr.length - 1;
        j <- i+1 until arr.length) yield (arr(i),arr(j))
    val counts = psarr.count {
      case (x,y) => (x+y) % k == 0
      case _ => false
    }
    println(counts)
  }
}
