import scala.collection.mutable

object Solution {

  private val distance = 6

  private def minReach(adj: Array[Array[Boolean]], s: Int, n: Int): Array[Int] = {
    val indices = 0 until n
    def go(q: mutable.Queue[Int], dist: Array[Int], visited: Array[Boolean], iter: Int): Array[Int] = {
      val src = q.dequeue
      if (q.isEmpty) dist.map { case -1 => -1; case n_ => n_ * distance }
      else {
        if(src < 0) {
          q.enqueue(-1)
          go(q,dist,visited,iter + 1)
        }
        else {
          val adjs = adj(src)
          for (edgeTo <- indices.filter(to => adjs(to) && !visited(to))) {
            dist(edgeTo) = iter
            q.enqueue(edgeTo)
            visited(edgeTo) = true
          }
          go(q, dist, visited, iter)
        }
      }
    }
    val visited = Array.fill[Boolean](n)(false)
    visited(s) = true
    go(mutable.Queue[Int](s,-1), Array.fill[Int](n)(-1), visited, 1)
  }

  def main(args: Array[String]) = {
    val distance = 6
    val it = scala.io.Source.stdin.getLines
    val t = it.next.toInt
    var i = 0
    while (i < t) {
      var j = 0
      val Array(n, m) = it.next.split(" ").map(_.toInt)
      val adj = Array.fill[Boolean](n, n)(false)
      while (j < m) {
        val Array(v, w) = it.next.split(" ").map(_.toInt - 1)
        adj(v)(w) = true
        adj(w)(v) = true
        j += 1
      }
      val s = it.next.trim.toInt - 1
      val dists = minReach(adj,s,n)
      println(dists.indices.filterNot(_ == s).map(dists(_)).mkString(" "))
      i += 1
    }
  }
}
