object Solution extends App {
  val it = io.Source.stdin.getLines
  val n = it.next.trim.toInt
  val arr = Array.ofDim[Int](n)
  for(i <- 0 until n)
    arr(i) = it.next.trim.toInt
  val lrmax = Array.ofDim[Int](n)
  val rlmax = Array.ofDim[Int](n)
  val max = Array.ofDim[Long](n)

  lrmax(0) = 1
  for(i <- arr.indices.drop(1))
    if(arr(i) > arr(i-1))
      lrmax(i) = lrmax(i-1) + 1
    else
      lrmax(i) = 1

  rlmax(arr.length - 1) = 1
  for(i <- arr.indices.reverse.drop(1))
    if(arr(i) > arr(i+1))
      rlmax(i) = rlmax(i+1) + 1
    else
      rlmax(i) = 1

  for(i <- arr.indices)
    max(i) = math.max(lrmax(i),rlmax(i))

  println(max.sum)
}
