import scala.reflect.ClassTag

object Solution {
  class MinHeap[T:ClassTag](implicit ord:Ordering[T]) {
    private val arr = Array.ofDim[T](2 << 18)
    private var lastIndx = 0
    private def float(i:Int) = {
      var _i = i
      while(_i > 1 && ord.lt(arr(_i),arr(_i / 2))) {
        val tmp = arr(_i)
        arr(_i) = arr(_i / 2)
        arr(_i / 2) = tmp
        _i /= 2
      }
    }
    def add(el:T) = {
      lastIndx += 1
      arr(lastIndx) = el
      float(lastIndx)
    }
    private def sink(i:Int):Unit = {
      var _i = i
      while(_i*2 <= lastIndx) {
        var _j = _i*2
        if (_j < lastIndx && ord.lt(arr(_j+1),arr(_j))) _j += 1
        if(ord.lteq(arr(_i),arr(_j))) return
        val tmp = arr(_j)
        arr(_j) = arr(_i)
        arr(_i) = tmp
        _i = _j
      }
    }
    def del(el:T):Int = {
      var i = 0
      while(i <= lastIndx && arr(i) != el) i += 1
      if(i >= arr.length) return -1
      arr(i) = arr(lastIndx)
      arr(lastIndx) = null.asInstanceOf[T]
      lastIndx -= 1
      sink(i)
      i
    }
    def peek():T = arr(1)
  }
  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val qn = it.next.trim.toInt
    val heap = new MinHeap[Int]()
    for(_ <- 0 until qn) {
      val q = it.next.split(" ").map(_.toInt)
      q(0) match {
        case 1 => heap.add(q(1))
        case 2 => heap.del(q(1))
        case 3 => println(heap.peek())
      }
    }
  }
}
