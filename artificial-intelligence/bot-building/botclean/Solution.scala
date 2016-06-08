
import scala.collection.mutable

object Solution {

  private val dirtPositions = mutable.Set[Pos]()
  private var bestPerm: List[Pos] = _

  private def dist(a:Pos, b:Pos):Int = {
    math.abs(a.x - b.x) + math.abs(a.y - b.y)
  }

  def tsp(pos:String,dp:Set[Pos]) = {
    val Array(x,y) = pos.split(" ").map(_.toInt)
    val initPos = new Pos(x,y)
    def go(it:Iterator[List[Pos]],best:List[Pos],bestLen:Int):List[Pos] =
      if(it.hasNext) {
        val perm = it.next
        var sum = 0
        for(i <- perm.indices.drop(1)) {
          sum += dist(perm(i-1),perm(i))
        }
        val totalDist = dist(perm.head,initPos) + sum
        if(totalDist < bestLen)
          go(it,perm,totalDist)
        else go(it,best,bestLen)
      } else best
    go(dp.toList.permutations, List(), Int.MaxValue)
  }

  def main(args: Array[String]):Unit = {
    val pos = Console.readLine
    val board = new Array[String](5)
    for (i <- 0 until 5)
      board.update(i, Console.readLine)
    for(i <- 0 until 5;
      j <- 0 until board(i).length
        if board(i)(j) == 'd'
      ) {dirtPositions += new Pos(i,j)}

    bestPerm = tsp(pos,dirtPositions.toSet)
    nextMove(pos, board)
  }

  case class Pos(x:Int, y:Int)

  def nextMove(pos:String, board:Array[String]): Unit = {
    val Array(x,y) = pos.split(" ").map(_.toInt)
    val initPos = new Pos(x,y)
    val nextPos = bestPerm.head

    def go():String = {
      nextPos.x - initPos.x match {
        case d if d < 0 => return "UP"
        case d if d > 0 => return "DOWN"
        case 0 =>
      }
      nextPos.y - initPos.y match {
        case d if d < 0 => "LEFT"
        case d if d > 0 => "RIGHT"
        case 0 =>
          bestPerm = bestPerm.tail
          "CLEAN"

      }
    }
    println(go())
  }
}
