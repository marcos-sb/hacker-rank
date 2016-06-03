import scala.reflect.ClassTag

object Solution {

  sealed class GrowingArray[T:ClassTag](_length: Int) {
    private var els = Array.ofDim[T](_length)
    private var elCount = 0

    private def doubleArray() = {
      val newEls = Array.ofDim[T](els.length * 2)
      var i = 0
      for(el <- els) {
        newEls(i) = el
        i += 1
      }
      els = newEls
    }

    def append(el: T): Unit = {
      if(els.length >= elCount) doubleArray()
      els(elCount) = el
      elCount += 1
    }

    def apply(i: Int): T = {
      if(i < 0 || i >= els.length)
        throw new IllegalArgumentException("illegal index $i")
      els(i)
    }

    def elAt(i: Int): T = apply(i)

    def length = elCount
  }

  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val Array(n,_) = it.next.split(" ").map(_.toInt)
    val seqs = Array.fill[GrowingArray[Int]](n)(new GrowingArray(16))
    var lastans = 0
    for(Array(op,x,y) <- it.map(_.split(" ").map(_.toInt))) {
      op match {
        case 1 =>
          seqs((x ^ lastans) % seqs.length).append(y)

        case 2 =>
          val seq = seqs((x ^ lastans) % seqs.length)
          val el = seq(y % seq.length)
          lastans = el
          println(el)
      }
    }
  }
}
