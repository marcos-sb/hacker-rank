
import scala.collection.mutable.PriorityQueue

object Solution {

  case class Edge(src:Int, dst:Int, wt:Int) {
    def swap() = new Edge(dst,src,wt)
  }
  object EdgeOrdering extends Ordering[Edge] {
    override def compare(a:Edge, b:Edge) = b.wt compare a.wt
  }

  def arrayToEdge(arr:Array[Int]): Edge = new Edge(arr(0)-1,arr(1)-1,arr(2))

  def main(args:Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val Array(n,m) = it.next.split(" ").map(_.toInt)
    val adj = Array.fill[List[Edge]](n)(List())
    val pq = PriorityQueue[Edge]()(EdgeOrdering)
    val visited = Array.ofDim[Boolean](n)
    for(_ <- 0 until m) {
      val edge = arrayToEdge(it.next.split(" ").map(_.toInt)) //0:src,1:dst,2:wt
      adj(edge.src) = edge :: adj(edge.src)
      adj(edge.dst) = edge.swap() :: adj(edge.dst)
    }
    val stNode = it.next.toInt - 1

    visited(stNode) = true
    pq.enqueue(adj(stNode) : _*)

    def prim(currWt:Int, visiCount:Int):Int = {
      if(visiCount >= n) currWt
      else {
        val minEdge = pq.dequeue
        if(!visited(minEdge.dst)) {
          visited(minEdge.dst) = true
          pq.enqueue(adj(minEdge.dst) : _*)
          prim(currWt + minEdge.wt, visiCount + 1)
        } else prim(currWt, visiCount)
      }
    }

    println(prim(0, 1))
  }
}
