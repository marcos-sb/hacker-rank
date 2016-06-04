object Solution {

  def lin(p:(Int,Int), dim:(Int,Int)) = {
    p._1 * dim._2 + p._2
  }

  def minDist(p:(Int,Int), dim:(Int,Int)) = {
    List(p._1,p._2,dim._1 - p._1 - 1,dim._2 - p._2 - 1).min
  }

  def distToOrigin(p:(Int,Int), dim:(Int,Int), pathLens:Array[(Int,Int,Int)]) = {
    val pathOrigin = minDist(p,dim) //which path falls p in
    val pathDiagPoint = (dim._1 - pathOrigin -1, dim._2 - pathOrigin - 1)
    if(p._1 == pathOrigin && p._2 != pathOrigin ||
        p._2 == pathDiagPoint._2) // point above the diagonal
      (pathLens(pathOrigin)._1 - (p._1 + p._2 - 2*pathOrigin), pathOrigin)
    else
      (p._1 + p._2 - 2*pathOrigin, pathOrigin)
  }

  def newPos(r:Int, p:(Int,Int), dim:(Int,Int), pathLens:Array[(Int,Int,Int)]) = {
    val (currPos,pathIndex) = distToOrigin(p,dim,pathLens)
    val modR = r % pathLens(pathIndex)._1
    val finalPos = (currPos + modR) % pathLens(pathIndex)._1
    if(finalPos < pathLens(pathIndex)._1 / 2) {
      if(finalPos - pathLens(pathIndex)._2 + 1 > 0)
        (pathIndex + pathLens(pathIndex)._2 - 1, pathIndex + finalPos - pathLens(pathIndex)._2 + 1)
      else (pathIndex + finalPos, pathIndex)
    } else {
      if(finalPos - pathLens(pathIndex)._1 / 2 < pathLens(pathIndex)._2)
        (pathIndex + pathLens(pathIndex)._2 - (finalPos - pathLens(pathIndex)._1 / 2 + 1), dim._2 - pathIndex - 1)
      else (pathIndex, pathIndex + pathLens(pathIndex)._1 - finalPos)
    }
  }

  def main(args:Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val Array(m,n,r) = it.next.split(" ").map(_.toInt)
    val mat = Array.ofDim[Array[Int]](m)
    for(i <- 0 until m) {
      mat(i) = it.next.split(" ").map(_.toInt)
    }

    val (smallDim, bigDim) = if(m <= n) (m,n) else (n,m)
    val pathLens = Array.ofDim[(Int,Int,Int)](smallDim / 2)
    var (sd,bd) = (smallDim,bigDim)
    for(i <- pathLens.indices) {
      if(m <= n)
        pathLens(i) = (2*sd + 2*bd - 4,sd,bd)
      else pathLens(i) = (2*sd + 2*bd - 4,bd,sd)
      sd -= 2
      bd -= 2
    }
    val res = Array.ofDim[Int](m,n)
    for(i <- res.indices; j <- res(0).indices) {
      val (newI,newJ) = newPos(r, (i,j), (m,n), pathLens)
      res(newI)(newJ) = mat(i)(j)
    }
    println(res.map(_.mkString(" ")).mkString("\n"))
  }
}
