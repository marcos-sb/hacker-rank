
import scala.collection.mutable

object Solution {
  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val n = it.next.toInt
    val poisonLvls = it.next.split(" ").map(_.toInt)
    var maxDays = 0
    var currMaxDays = 0
    var poisonPivot = poisonLvls(0)
    val st = mutable.Stack[(Int,Int)]()
    for(p <- poisonLvls) {
      currMaxDays = 0
      while(st.nonEmpty && p <= st.top._2)
        currMaxDays = math.max(currMaxDays, st.pop()._1)
      if(st.isEmpty)
        currMaxDays = 0
      else
        currMaxDays += 1

      maxDays = math.max(maxDays, currMaxDays)
      st push ((currMaxDays,p))
    }
    println(maxDays)
  }
}
