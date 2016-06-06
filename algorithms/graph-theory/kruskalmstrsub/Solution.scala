
import scala.collection.mutable.PriorityQueue
import scala.language.implicitConversions

object Solution {

  class UnionFind(val sz: Int) {
    private val _arr = (0 until sz).toArray
    private var _count = sz
    def find(p:Int):Int = {
      if(p == arr(p)) p
      else {
        arr(p) = arr(arr(p))
        find(arr(p))
      }
    }

    def union(p:Int, q:Int):Boolean = {
      val pid = find(p)
      val qid = find(q)

      if(pid != qid) {
        arr(qid) = pid
        _count -= 1
        true
      } else false
    }
    def count = _count
    def arr = _arr
  }

  case class Edge(src:Int,dst:Int,w:Int)
  object EdgeOrdering extends Ordering[Edge] {
    override def compare(a:Edge, b:Edge) = {
      if(a.w == b.w) (a.src + a.dst + a.w) compare (b.src + b.dst + b.w)
      else a.w compare b.w
    }
  }
  implicit def arrayToEdge(x:Array[Int]): Edge = new Edge(x(0)-1,x(1)-1,x(2))

  def main(args:Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val Array(n,m) = it.next.split(" ").map(_.toInt)
    val edges = PriorityQueue[Edge]()(EdgeOrdering.reverse)
    val vertices = new UnionFind(n)
    for(i <- 0 until m) {
      edges enqueue (it.next.split(" ").map(_.toInt))
    }
    def kruskal(totalWt:Int):Int = {
      if(vertices.count == 1) totalWt
      else {
        val edge = edges.dequeue

        if(vertices.union(edge.src, edge.dst))
          kruskal(totalWt + edge.w)
        else
          kruskal(totalWt)
      }
    }

    println(kruskal(0))
  }
}
