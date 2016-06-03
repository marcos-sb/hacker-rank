
import scala.collection.mutable

object Solution {

  def main(args: Array[String]):Unit = {
    val pos = Console.readLine
    val board = new Array[String](5)
    for (i <- 0 until 5)
      board.update(i, Console.readLine)
    for(i <- 0 until 5;
      j <- 0 until board(i).length
        if board(i)(j) == 'd'
      ) {dirtPositions += new Pos(i,j)}

    nextMove(pos, board)
  }

  private var invalidate = true
  private val dirtPositions = mutable.Set[Pos]()
  private var lastPos: PosInfo = _

  case class Pos(x:Int, y:Int)
  case class PosInfo(x:Int, y:Int, dist:Int)
  object PosInfoOrder extends Ordering[PosInfo] {
    override def compare(a:PosInfo, b:PosInfo) = {
      a.dist - b.dist
    }
  }

  private def dist(cpos:(Int,Int), pos:Pos) = {
    math.abs(cpos._1 - pos.x) + math.abs(cpos._2 - pos.y)
  }

  def minDistToCurrentPos(cpos:(Int,Int),
    board:Array[String]): PosInfo = {
      var cdist = Int.MaxValue
      var _cpos: Pos = null.asInstanceOf[Pos]
      dirtPositions.foreach(pos =>
        if(dist(cpos,pos) < cdist) {
          cdist = dist(cpos,pos)
          _cpos = pos
        }
      )
    new PosInfo(_cpos.x, _cpos.y, cdist)
  }

  def nextMove(pos:String, board:Array[String]): Unit = {
    val Array(x,y) = pos.split(" ").map(_.toInt)
    if(invalidate) {
      invalidate = false
      lastPos = minDistToCurrentPos((x,y),board)
    }
    val mpos = lastPos

    def go():String = {
      (mpos.x - x) match {
        case d if d < 0 => return "UP"
        case d if d > 0 => return "DOWN"
        case 0 =>
      }
      (mpos.y - y) match {
        case d if d < 0 => "LEFT"
        case d if d > 0 => "RIGHT"
        case 0 => {
          invalidate = true
          dirtPositions -= new Pos(x,y)
          "CLEAN"
        }
      }
    }
    println(go())
  }
}
