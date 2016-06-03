import scala.collection.mutable.ArrayBuffer

object Solution {

  private def primesTo(q: Int) = {
    val selected = Array.fill(10001)(false)
    for(p <- 2 to math.sqrt(10000).toInt)
      if(!selected(p))
        for(notp <- p+p to 10000 by p)
          selected(notp) = true
    selected.indices.filter(!selected(_)).slice(2,q+2)
  }

  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val Array(n,q) = it.next.split(" ").map(_.toInt)
    val primes = primesTo(q)
    val primesInd = primes.indices
    val els = it.next.split(" ").map(_.toInt).reverse
    val stacks = Array.fill(q+1)(new ArrayBuffer[Int]())
    for(el <- els) {
      stacks(primesInd.find(el % primes(_) == 0).getOrElse(q)) += el
    }
    var i = 0
    stacks.foreach(stack => {
      val _stack =
        if (i == q && q % 2 != 0) stack.reverse
        else if(i == q && q % 2 == 0) stack
        else if(i % 2 == 0) stack.reverse
        else stack

      for(el <- _stack) println(el)
      i += 1
    })
  }
}
