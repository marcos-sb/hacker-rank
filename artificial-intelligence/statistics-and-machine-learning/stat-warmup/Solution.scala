
import util.Sorting

object Solution {

  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val n = it.next.toInt
    val nums = it.next.split(" ").map(_.toInt)
    Sorting.quickSort(nums)

    object ModeOrdering extends Ordering[(Int,Int)] {
      override def compare(a:(Int,Int),b:(Int,Int)) = {
        val cmpCounts = a._2 compare b._2
        if(cmpCounts == 0) b._1 compare a._1
        else cmpCounts
      }
    }

    val mean = nums.sum.toDouble / nums.length
    val median = if(nums.length % 2 == 0) {
        (nums(nums.length / 2) + nums(nums.length / 2 - 1)) / 2.0d
      } else nums(nums.length / 2).toDouble
    val mode = nums.groupBy(n => n).mapValues(_.length)
      .max(ModeOrdering)._1
    val sd = math.sqrt(nums.map(n => math.pow(n - mean,2)).sum/nums.length)
    val t = 1.96
    val margin = t * sd / math.sqrt(nums.length)
    val meanIC = (mean - margin, mean + margin)
    println(f"$mean%1.1f")
    println(f"$median%1.1f")
    println(s"$mode")
    println(f"$sd%1.1f")
    println(f"${meanIC._1}%1.1f ${meanIC._2}%1.1f")
  }
}
