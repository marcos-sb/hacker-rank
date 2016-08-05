object Solution {
  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val Array(n,d) = it.next.split(" ").map(_.toInt)
    val arr = it.next.split(" ").map(_.toInt)
    val indx = Array.ofDim[Int](n)
    var k = d % n
    for(i <- 0 until n - d % n) {
      indx(i) = arr(k)
      k = (k + 1) % n
    }
    k = 0
    for(i <- n - d % n until n) {
      indx(i) = arr(k)
      k += 1
    }
    println(indx.mkString(" "))
  }
}
