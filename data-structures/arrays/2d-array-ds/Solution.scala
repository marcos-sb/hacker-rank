object Solution {
  def main(args:Array[String]) = {
    val mat = Array.ofDim[Int](6,6)
    var i = 0
    for(arr <- io.Source.stdin.getLines.map(_.split(" "))) {
      for(j <- arr.indices)
        mat(i)(j) = arr(j).toInt
      i += 1
    }

    var maxSum = Int.MinValue
    for(i <- 0 to (mat.length - 3);
        j <- 0 to (mat(i).length - 3)) {

      var sum = 0
      for(m <- j until j+3) {
        sum += mat(i)(m)
        sum += mat(i+2)(m)
      }
      sum += mat(i+1)(j+1)
      if(maxSum < sum) maxSum = sum
    }
    println(maxSum)
  }
}
