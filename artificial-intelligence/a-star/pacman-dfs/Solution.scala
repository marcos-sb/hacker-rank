
import collection.{immutable,mutable}

object Solution {

  object Position {
    def fromArray(arr:Array[Int]) = {
      //assert(arr.length == 2)
      new Position(arr(0),arr(1))
    }

    def isValid(mat:Array[String], pos:Position) = {
      if(pos.x > 0 && pos.x < mat.length &&
          pos.y > 0 && pos.y < mat(0).length &&
          mat(pos.x)(pos.y) != '%')
        true
      else false
    }

    def visitNeighbors(pos:Position) = {
      //up left right down
      pos.down :: pos.right :: pos.left :: pos.up :: List[Position]()
    }
  }

  case class Position(x:Int,y:Int) {
    def left = new Position(x,y-1)
    def right = new Position(x,y+1)
    def up = new Position(x-1,y)
    def down = new Position(x+1,y)
    override def toString = s"$x $y"
  }

  def dfs(mat:Array[String], pos:Position, dst: Position) = {

    var found = false
    import Position._

    def go(pos_ :Position,visited:mutable.Set[Position],
      opened:mutable.ListBuffer[Position], path:immutable.Queue[Position]
    ): (mutable.ListBuffer[Position], immutable.Queue[Position]) = {
      if(pos_ == dst) {
        found = true
        (opened += dst, path)
      } else {
        opened += pos_
        var pa = immutable.Queue[Position]()
        val newVisits = visitNeighbors(pos_).filter(isValid(mat,_))
          .filterNot(visited.contains)
        newVisits.foreach(visited += _)
        newVisits.toStream.takeWhile(_ => !found).foreach { neigh =>
            pa = go(neigh,visited,opened,path enqueue neigh)._2
          }
        (opened,pa)
      }
    }
    go(pos, mutable.Set(pos),
      mutable.ListBuffer[Position](), immutable.Queue[Position](pos))
  }

  def main(args:Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    import Position._
    val src = fromArray(it.next.split(" ").map(_.toInt))
    val dst = fromArray(it.next.split(" ").map(_.toInt))
    val Array(n,m) = it.next.split(" ").map(_.toInt)
    val mat = Array.ofDim[String](n)
    for(i <- mat.indices) {
      mat(i) = it.next.trim()
    }
    val (v,dfsPath) = dfs(mat, src, dst)
    println(v.length)
    println(v.mkString("\n"))
    println(dfsPath.length - 1)
    println(dfsPath.mkString("\n"))
  }
}
