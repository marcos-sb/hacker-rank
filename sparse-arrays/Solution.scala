
object Solution {

  sealed class SparseArray[T] (implicit t2o: T => Ordered[T]) {

    sealed case class Node(
      value: T
    ) {
      var times: Int = 1
      var next: Option[Node] = None
    }

    private var head: Option[Node] = None

    private def add(value:T, node:Node): Node = {
      if(value == node.value) {
        node.times += 1
        node
      }
      else if(value < node.value) {
        val newNode = new Node(value)
        newNode.next = Some(node)
        newNode
      } else if(node.next.nonEmpty) {
        node.next = Some(add(value, node.next.get))
        node
      } else { //node.next.isEmpty
        val newNode = new Node(value)
        node.next = Some(newNode)
        node
      }
    }

    def add(value: T): Unit = {
      if(head.isEmpty)
        head = Some(new Node(value))
      else
        head = Some(add(value, head.get))
    }

    private def count(value: T, node:Option[Node], count_ : Int): Int = {
      if(node.isEmpty) return count_
      if(value == node.get.value)
        count(value, node.get.next, count_ + node.get.times)
      else
        count(value, node.get.next, count_)
    }

    def count(value: T): Int = {
      if(head.isEmpty) 0
      else count(value, head, 0)
    }
  }

  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val sparse = new SparseArray[String]()
    val n = it.next.toInt
    for(_ <- 0 until n) sparse.add(it.next)
    val q = it.next.toInt
    for(_ <- 0 until q) println(sparse.count(it.next))
  }
}
