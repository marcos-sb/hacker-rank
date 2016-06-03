
import scala.collection.mutable

object Solution {
    def main(args:Array[String]) = {
        val it = scala.io.Source.stdin.getLines
        val Array(_,k) = it.next.split(" ").map(_.toInt)
        val els = it.next.split(" ").map(_.toInt)
        val pq = mutable.PriorityQueue[Int]()(Ordering[Int].on(-_))

        for(el <- els) pq += el
        var ops = 0
        while(pq.size >= 2 && pq.head < k) {
            val head1 = pq.dequeue
            val head2 = pq.dequeue
            val newEl = head1 + 2 * head2
            pq enqueue newEl
            ops += 1
        }
        println(if(pq.head < k) "-1" else ops)
    }
}
