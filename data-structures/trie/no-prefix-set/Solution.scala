object Solution {
  sealed class TrieSet(min:Char, max:Char) {
    class Node {
      val next = Array.fill[Option[Node]](max - min + 1)(None)
      var in = false
    }
    private val root = new Node()

    def add(s: String) = {
      val (i,node) = longestPrefix(s)
      var curr = node
      for(j <- i until s.length) {
        val n = new Node()
        curr.get.next(index(s(j))) = Some(n)
        curr = Some(n)
      }
      curr.get.in = true
    }
    private def index(c: Char) = {
      c - min
    }
    private def longestPrefix(s: String):(Int,Option[Node]) = {
      if(s == null) return (-1,None)
      var curr: Option[Node] = Some(root)
      var prev: Option[Node] = None
      for(i <- s.indices) {
        if(curr.get.next(index(s(i))).isEmpty) return (i,curr)
        prev = curr
        curr = curr.get.next(index(s(i)))
      }
      (s.length,prev)
    }
    def hasPrefix(s: String) = {
      val lps = longestPrefix(s)
      println(s"$lps; $s")
      lps._1 == s.length || lps._2.get.in
    }

    def contains(s: String) = {
      val lps = longestPrefix(s)
      lps._1 == s.length && lps._2.get.in
    }
  }
  def main(args:Array[String]):Unit = {
    val trie = new TrieSet('a','j')
    val it = io.Source.stdin.getLines
    val n = it.next.trim.toInt
    for(l <- it) trie.hasPrefix(l.trim) match {
      case true =>
        println("BAD SET")
        println(l)
        return
      case false =>
        trie.add(l)
    }
    println("GOOD SET")
  }
}
