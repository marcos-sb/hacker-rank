object Solution {

  private def findPrincess(mat: Array[String]):(Int,Int) = {
    for(i <- 0 until mat.length) {
      for(j <- 0 until mat.length) {
        if(mat(i)(j) == 'p') return (i,j)
      }
    }
    (-1,-1)
  }

  def rescue(n:Int,grid:Array[String])={
    val p = findPrincess(grid)
    val m = (n / 2, n / 2)
    val p_m = (p._1 - m._1, p._2 - m._2)
    val first = p_m._1 match {
      case 0 => ""
      case v if v > 0 => "DOWN " * v
      case v if v < 0 => "UP " * -v
    }
    val snd = p_m._2 match {
      case 0 => ""
      case v if v > 0 => "RIGHT " * v
      case v if v < 0 => "LEFT " * -v
    }
    (first + snd)
  }

  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val n = it.next.toInt
    val mat = Array.ofDim[String](n)
    for(i <- 0 until n) mat(i) = it.next.trim()
    println(rescue(n,mat).split(" ").mkString("\n"))
  }
}
