import scala.annotation.tailrec

object Solution {

  class Trie {

    sealed class Node {
      val next = Array.ofDim[Node]('z' - 'a' + 1)
      var prefixes = 0
      var inSet = false
    }

    var root = new Node()

    private def indx(c: Char) = c - 'a'

    @tailrec
    private def add(s: String, n: Node, d: Int): Int = {
      if (d < s.length) {
        if (n.next(indx(s(d))) == null) n.next(indx(s(d))) = new Node()
        val next = n.next(indx(s(d)))
        next.prefixes += 1
        if (d == s.length - 1) n.inSet = true
        add(s, next, d + 1)
      } else n.prefixes
    }

    def add(s: String):Int =
      if (s != null) add(s, root, 0)
      else -1

    @tailrec
    private def find(s: String, n: Node, d: Int): Int =
      if (d < s.length && n.next(indx(s(d))) != null)
        find(s, n.next(indx(s(d))), d + 1)
      else if (d == s.length) n.prefixes
      else 0

    def find(s: String):Int =
      if (s != null) find(s, root, 0)
      else -1

  }

  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val n = it.next.toInt
    val t = new Trie()
    for(_ <- 0 until n) {
      val Array(op, contact) = it.next.split(" ")
      op(0) match {
        case 'a' => t.add(contact)
        case 'f' => println(t.find(contact))
      }
    }
  }
}
