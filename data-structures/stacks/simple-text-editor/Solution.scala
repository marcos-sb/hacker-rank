
import scala.collection.mutable.Stack

object Solution {
  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val q = it.next.toInt
    val state = Stack[String]()
    var i = 0
    while(i < q) {
      val op = it.next.split(" ")
      op.length match {
        case 1 => state.pop() //undo
        case 2 => op match {
          case Array("1",str) => state.push(state.headOption.getOrElse("") + str) //append
          case Array("2",n) => state.push(state.top.dropRight(n.toInt)) //delete
          case Array("3",n) => println(state.top.charAt(n.toInt - 1))
        }
      }
    }
  }
}
