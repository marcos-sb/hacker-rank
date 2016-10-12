object Solution extends App {

  private def triangleFrom(a:Int,b:Int,c:Int) = {
    val triangle = a < b + c && b < a + c && c < a + b
    if(triangle) Some(Array(c,b,a))
    else None
  }

  val it = io.Source.stdin.getLines
  val _ = it.next.trim.toInt
  val arr = it.next.split(" ").map(_.toInt)
  val ord = math.Ordering.Int.reverse
  val sortedArr = arr.sorted(ord)
  var out:Option[Array[Int]] = None
  Stream.range(0,arr.length-2).takeWhile(_ => out.isEmpty).foreach { i =>
    val a = sortedArr(i)
    val b = sortedArr(i+1)
    val c = sortedArr(i+2)
    out = triangleFrom(a,b,c)
  }
  if(out.isEmpty) println("-1")
  else println(out.get.mkString(" "))
}
