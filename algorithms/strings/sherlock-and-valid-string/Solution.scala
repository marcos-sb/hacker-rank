import scala.collection.mutable

object Solution {
  def main(args:Array[String]) = {
    val s = scala.io.Source.stdin.getLines.next
    val freqs = Array.ofDim[Int]('z'-'a'+1)
    for(c <- s) {
      freqs(c - 'a') += 1
    }
    val diffs = mutable.Map.empty[Int,Int]
    for(i <- freqs) diffs += (i -> (diffs.getOrElse(i,0) + 1))
    diffs -= 0

    if(diffs.size > 2) println("NO")
    else if(diffs.size == 2) {
      val oneFreqOne = diffs.get(1).contains(1)

      if(oneFreqOne) println("YES")
      else {
        val keys = diffs.keySet.toSeq
        if(math.abs(keys.max - keys.min) == 1 && diffs.get(keys.max).contains(1))
          println("YES")
        else println("NO")
      }
    } else //diffs.size < 2
      println("YES")

  }
}
