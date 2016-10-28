import java.util.PriorityQueue

object Solution extends App {

  // sealed class MovingMedian[T](implicit toOrd: (T) => Ordered[T],
  //   implicit val ord:Ordering[T], implicit val toInt: (T) => Int) {
  sealed class MovingMedian {
    import collection.mutable
    import java.util.PriorityQueue
    private val insOrder = mutable.Queue[Int]()
    private val pqLow = new PriorityQueue[Int]()
    private val pqHigh = new PriorityQueue[Int](16,Ordering[Int].reversed())

    private def balance():Unit = {
      if(pqLow.size != pqHigh.size) {
        if(pqLow.size + 1 < pqHigh.size)
          pqLow.add(pqHigh.poll())
        else if(pqLow.size > pqHigh.size + 1)
          pqHigh.add(pqLow.poll())
      }
    }

    def length(): Int = insOrder.size

    def removeOldest():Unit = {
      if(insOrder.nonEmpty) {
        val toRem = insOrder.dequeue()
        if(!pqHigh.isEmpty && toRem <= pqHigh.peek())
          pqHigh.remove(toRem)
        else if(!pqLow.isEmpty && toRem >= pqLow.peek())
          pqLow.remove(toRem)
        balance()
      }
    }

    def add(v: Int):Unit = {
      insOrder.enqueue(v)
      if(pqHigh.isEmpty) pqHigh.add(v)
      else if(pqHigh.peek() >= v) {
        pqHigh.add(v)
      } else if(pqLow.isEmpty || pqLow.peek() <= v) {
        pqLow.add(v)
      } else {
        pqHigh.add(v)
      }
      balance()
    }
    def median():Double = {
//      println(s"h:${pqHigh.clone.dequeueAll.mkString(" ")} l:${pqLow.clone.dequeueAll.mkString(" ")}")
      if((pqLow.size + pqHigh.size) % 2 == 0) {
        (pqLow.peek() + pqHigh.peek()).toDouble / 2
      } else if(pqHigh.size > pqLow.size) {
        pqHigh.peek()
      } else pqLow.peek().toDouble
    }
  }

  val it = io.Source.stdin.getLines
  val mm = new MovingMedian()
  val Array(_,d) = it.next.split(" ").map(_.toInt)
  val arr = it.next.split(" ").map(_.toInt)
  var notfs = 0
  for(i <- arr.indices) {
    if(i >= d) {
      if(mm.length() > d) mm.removeOldest()
      if(arr(i) >= 2 * mm.median())
        notfs += 1
    }
    mm.add(arr(i))
  }

  println(notfs)
}
