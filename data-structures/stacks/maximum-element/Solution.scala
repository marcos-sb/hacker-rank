import scala.reflect.ClassTag

object Solution {

  sealed class LinkedStack[T] (implicit t2o: T => Ordered[T]) {
    private sealed case class Node(
      value: T
    ) {
      var prev: Option[Node] = None
      var prevMax: Option[T] = None

      def max(): T = prevMax filter {_ > value} getOrElse value

    }

    private var top: Option[Node] = None

    def push(el: T) = {
      val newNode = new Node(el)
      newNode.prev = top
      newNode.prevMax = max()
      top = Some(newNode)
    }

    def pop(): T = {
      if(top.isEmpty) throw new IllegalStateException("cannot pop from empty stack")
      val prevTop = top
      top = top.get.prev
      prevTop.get.value
    }

    def peek(): Option[T] = top map {_.value}

    def max(): Option[T] = top map {_.max()}
  }

  def main(args: Array[String]) = {
    val s = new LinkedStack[Int]()
    val it = scala.io.Source.stdin.getLines
    val n = it.next.toInt
    val op1 = """1\s(\d*)""".r
    var i = 0
    while(i < n) {
      i += 1
      it.next match {
        case op1(el2push) => s.push(el2push.toInt)
        case "2" => s.pop()
        case "3" => println(s.max().get)
      }
    }
  }
}
