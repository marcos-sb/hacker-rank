import collection.mutable

object Solution {

  object Pos {
    val WALL = '%'
    val FOOD = '.'
    def valid(pos:Pos,mat:Seq[String]) = {
      pos.x >= 0 && pos.y >= 0 && pos.x < mat.length && pos.y < mat(pos.x).length && mat(pos.x)(pos.y) != WALL
    }
    def food(pos:Pos, mat:Seq[String]) = {
      mat(pos.x)(pos.y) == FOOD
    }
  }

  sealed class Pos(val x:Int, val y:Int, val from:Option[Pos]) {
    def left = new Pos(x,y-1,Some(this))
    def right = new Pos(x,y+1,Some(this))
    def up = new Pos(x-1,y,Some(this))
    def down = new Pos(x+1,y,Some(this))
    def visitNeighbors = List(up,left,right,down)
    override def hashCode() = {
      var result = 17
      result = 31 * result + x
      result = 31 * result + y
      result
    }
    override def equals(o: Any) = o match {
      case that:Pos => this.x == that.x && this.y == that.y
      case _ => false
    }
    override def toString = s"$x $y"
  }

  def fromArray(arr:Array[Int]) = {
    //arr.length shouldEqual 2
    new Pos(arr(0),arr(1),None)
  }

  import Pos._

  def calcMovsTo(spos:Pos,pos:Pos,visited:Set[Pos],movs: List[Pos]):List[Pos] =
    if(spos == pos) spos :: movs
    else calcMovsTo(spos,pos.from.get,visited,pos :: movs)

  def bfs(spos:Pos, mat:Seq[String],q:mutable.Queue[Pos],
    visited: mutable.Set[Pos], opened:mutable.Queue[Pos]
  ):(mutable.Queue[Pos],List[Pos]) = {
    q enqueue spos
    visited += spos
    while(q.nonEmpty) {
      val pos = q.dequeue
      opened enqueue pos
      if(food(pos,mat)) return (opened,calcMovsTo(spos,pos,visited.toSet, List[Pos]()))
      val visitNeighbors =
        pos.visitNeighbors.filter(valid(_,mat)).filterNot(visited.contains)
      visited ++= visitNeighbors
      q enqueue (visitNeighbors : _*)
    }
    (opened,List[Pos]())
  }

  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val iniPos = fromArray(it.next.split(" ").map(_.toInt))
    val _ = fromArray(it.next.split(" ").map(_.toInt))
    val Array(rows,_) = it.next.split(" ").map(_.toInt)
    val mat = for(_ <- 0 until rows) yield it.next.trim
    val (op,path) =
      bfs(iniPos,mat,mutable.Queue[Pos](),mutable.Set[Pos](),mutable.Queue[Pos]())
    println(op.length)
    println(op.mkString("\n"))
    println(path.length-1)
    println(path.mkString("\n"))
  }
}
