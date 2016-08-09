import collection.mutable

object Solution extends App {
  val it = io.Source.stdin.getLines
  val Array(n,k) = it.next.split(" ").map(_.toInt)
  var unimportantLuck = 0
  val importants = mutable.ArrayBuffer[Int]()
  for(_ <- 0 until n) {
    val Array(l,important) = it.next.split(" ").map(_.toInt)
    if(important == 0) unimportantLuck += l
    else importants += l
  }
  val importantsSorted = importants.sorted
  val maxLuck = unimportantLuck - importantsSorted.take(importantsSorted.size - k).sum + importantsSorted.drop(importantsSorted.size - k).sum
  println(maxLuck)
}
