
import scala.collection.mutable.ListBuffer

object Solution {

  private val inverse = Map[Char,Char](']' -> '[',')' -> '(', '}' -> '{')

  private def balanced(s: String): Boolean = {
    val l = new ListBuffer[Char]()
    for(c <- s) c match {
      case lparen @ ('['|'('|'{') => lparen +=: l
      case rparen @ (']'|'}'|')') =>
        if(l.isEmpty ||
          !inverse.get(rparen).contains(l.head)) return false
        l.trimStart(1)
    }
    l.isEmpty
  }

  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val n = it.next.toInt
    var i = 0
    while(i < n) {
      i += 1
      println(if(balanced(it.next)) "YES" else "NO")
    }
  }
}
