import collection.mutable

object Solution extends App {
  val it = io.Source.stdin.getLines
  val t = it.next.toInt
  for(_ <- 0 until t) {
    val Array(n,k) = it.next.split(" ").map(_.toInt)
    val nums = mutable.BitSet(1 to n : _*)

    def go():Option[Array[Int]] = {
      val resArr = Array.ofDim[Int](n)
      for(i <- resArr.indices)
        if(nums.contains(i+1 - k)) {
          nums -= i+1 - k
          resArr(i) = i+1 - k
        } else if(nums.contains(i+1 + k)) {
          nums -= i+1 + k
          resArr(i) = i+1 + k
        } else return None
      Some(resArr)
    }

    val res = go()
    if(res.nonEmpty) println(res.get.mkString(" "))
    else println("-1")
  }
}
