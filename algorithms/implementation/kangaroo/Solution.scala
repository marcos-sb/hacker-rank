import util.Sorting

object Solution {
  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val Array(x1,v1,x2,v2) = it.next.split(" ").map(_.toDouble)
    val n = (x1 - x2) / (v2 - v1)
    if(n.isWhole && n > 0) println("YES")
    else println("NO")
  }
}
