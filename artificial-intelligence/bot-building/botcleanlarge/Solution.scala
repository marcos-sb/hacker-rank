
import collection.mutable
import scala.annotation.tailrec

object Solution {

  var dirtList = null.asInstanceOf[mutable.ListBuffer[Pos]]

  object Pos {
    def fromArray(arr:Array[Int]) = {
      new Pos(arr(0),arr(1))
    }
    def isValid(p:Pos,mat:Array[Array[Char]]) = {
      p.x >= 0 && p.x < mat.length && p.y >= 0 && p.y < mat(p.x).length
    }
    def isDirt(p:Pos,mat:Array[Array[Char]]) = mat(p.x)(p.y) == 'd'
  }
  case class Pos(x:Int,y:Int) {
    def up = new Pos(x-1,y)
    def down = new Pos(x+1,y)
    def left = new Pos(x,y-1)
    def right = new Pos(x,y+1)
    def neibs() = {
      up :: down :: left :: right :: List[Pos]()
    }
  }

  import Pos._

  def bfs(pos:Pos,mat:Array[Array[Char]]) = {
    val posList = mutable.ListBuffer[Pos]()
    val opened = mutable.Set[Pos](pos)

    def go(q:mutable.Queue[Pos]):mutable.ListBuffer[Pos] = {
      if(q.nonEmpty) {
        val _pos = q.dequeue
        val newVisits =
          _pos.neibs().filter(isValid(_,mat)).filterNot(opened.contains)
        opened ++= newVisits
        if(isDirt(_pos,mat)) posList += _pos
        q enqueue (newVisits : _*)
        go(q)
      } else posList
    }
    go(mutable.Queue[Pos](pos))
  }

  def nextMove(pos:Pos, board:Array[Array[Char]]): Pos = {
    val nextPos = dirtList.head

    if(board(pos.x)(pos.y) == 'd') {
      dirtList -= pos
      println("CLEAN")
      board(pos.x)(pos.y) = '-'
      return pos
    }
    nextPos.x - pos.x match {
      case d if d < 0 => println("UP"); return pos.up
      case d if d > 0 => println("DOWN"); return pos.down
      case 0 =>
    }
    nextPos.y - pos.y match {
      case d if d < 0 => println("LEFT"); pos.left
      case d if d > 0 => println("RIGHT"); pos.right
      case 0 =>
        dirtList -= nextPos
        println("CLEAN")
        board(pos.x)(pos.y) = '-'
        pos
    }
  }

  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val ipos = fromArray(it.next.split(" ").map(_.toInt))
    val Array(n,m) = it.next.split(" ").map(_.toInt)
    val mat = Array.ofDim[Array[Char]](n)
    for(i <- mat.indices) {
      mat(i) = it.next.trim().toCharArray
    }
    dirtList = bfs(ipos,mat)
    // @tailrec
    // def go(pos:Pos, l:mutable.ListBuffer[Pos]):Unit = {
    //   if(l.nonEmpty)
    //     go(nextMove(pos,mat), l)
    // }
    // go(ipos,dirtList)
    nextMove(ipos,mat)
    println()
  }
}
