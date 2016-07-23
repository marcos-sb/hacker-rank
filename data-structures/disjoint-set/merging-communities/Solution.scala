import scala.annotation.tailrec

object Solution {
  sealed class UnionFind (sz:Int) {
    private val uf = Array.range(0,sz)
    private val ufSz = Array.fill[Int](sz)(1)
    def union(i:Int, j:Int) = {
      val idi = find(i)
      val idj = find(j)
      if(idi != idj) {
        uf(idi) = idj
        ufSz(idi) += ufSz(idj)
        ufSz(idj) = ufSz(idi)
      }

    }
    @tailrec
    final def find(i:Int):Int = {
      if(uf(i) == i) {
        i
      }
      else {
        uf(i) = uf(uf(i))
        find(uf(i))
      }
    }
    def size(i:Int) = ufSz(find(i))
  }

  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val Array(p,_) = it.next.split(" ").map(_.toInt)
    val uf = new UnionFind(p)
    for(l <- it) l.split(" ") match {
      case Array("Q",a) => println(uf.size(a.toInt - 1))
      case Array("M",a,b) => uf.union(a.toInt - 1,b.toInt - 1)
    }
  }
}
