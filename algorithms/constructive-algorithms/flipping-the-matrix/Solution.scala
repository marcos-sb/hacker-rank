object Solution extends App {

  val it = io.Source.stdin.getLines
  val q = it.next.trim.toInt

  for(_ <- 0 until q) {
    val n = it.next.trim.toInt
    val mat = Array.ofDim[Int](2*n,2*n)
    val matSol = Array.ofDim[Int](n,n)

    for(i <- 0 until 2*n) {
      mat(i) = it.next.split(" ").map(_.toInt)
    }
    for(i <- 0 until mat.length/2; j <- 0 until mat.length/2) {
      val max = Array(mat(i)(j),mat(i)(mat.length-1-j),
        mat(mat.length-1-i)(mat.length-1-j),mat(mat.length-1-i)(j)).max
        matSol(i)(j) = max
    }

    var sumN = 0
    for(i <- matSol.indices; j <- matSol.indices) {
      sumN += matSol(j)(i)
    }
    println(sumN)
  }
}
