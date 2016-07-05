import collection.mutable.Stack

object Solution {
  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val Array(h1,h2,h3) = it.next.split(" ").map(_.toInt)
    val s1 = Stack[Int](it.next.split(" ").map(_.toInt) : _*)
    val s2 = Stack[Int](it.next.split(" ").map(_.toInt) : _*)
    val s3 = Stack[Int](it.next.split(" ").map(_.toInt) : _*)
    val ss = Array[(Stack[Int],Int)]((s1,s1.sum),(s2,s2.sum),(s3,s3.sum)).zipWithIndex
    var equals = false
    while(!equals) {
      val max = ss.maxBy(_._1._2)
      val min = ss.minBy(_._1._2)
      if(max._1._2 == min._1._2) equals = true
      else {
        val top = max._1._1.pop
        ss(max._2) = ((max._1._1,max._1._2 - top),max._2)
      }
    }
    println(ss.head._1._2)
  }
}
