
import scala.collection.mutable

object Solution {

  private def open(pos:(Int,Int), mat:Array[String], visited:mutable.Set[(Int,Int)]) = {
    val sz = mat.length
    val ups = (for(i <- pos._1 -1 to 0 by -1)
      yield (i,pos._2)).takeWhile(el => mat(el._1)(el._2) != 'X')
    val downs = (for(i <- pos._1 +1 until sz)
      yield (i,pos._2)).takeWhile(el => mat(el._1)(el._2) != 'X')
    val lefts = (for(i <- pos._2 -1 to 0 by -1)
      yield (pos._1,i)).takeWhile(el => mat(el._1)(el._2) != 'X')
    val rights = (for(i <- pos._2 +1 until sz)
      yield (pos._1,i)).takeWhile(el => mat(el._1)(el._2) != 'X')

    val newPoss = (ups ++ downs ++ lefts ++ rights).filterNot(visited.contains)
    newPoss.foreach(visited += _)
    newPoss
  }

  private def findShortest(src:(Int,Int), dest:(Int,Int), mat:Array[String]):Int = {
    // dfs -> open all positions in a straight line in all four directions
    // and queue them
    val sz = mat.length
    val visited = mutable.Set[(Int,Int)](src)
    val dfsQ = Array.fill(2)(mutable.Queue[(Int,Int)]())
    var steps = 0
    dfsQ(0).enqueue(src)
    while(steps < sz*sz) {
      while (dfsQ(steps % 2).nonEmpty) {
        val currPos = dfsQ(steps % 2).dequeue()
        if (currPos == dest) return steps
        open(currPos, mat, visited).foreach(dfsQ((steps + 1) % 2).enqueue(_))
      }
      steps += 1
    }
    -1
  }

  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val n = it.next.toInt
    val mat = Array.ofDim[String](n)
    for(i <- 0 until n) {
      mat(i) = it.next.trim
    }
    val Array(a,b,c,d) = it.next.split(" ").map(_.toInt)

    println(findShortest((a,b), (c,d), mat))
  }
}
