object Solution {
  def main(args: Array[String]) = {
    val it = io.Source.stdin.getLines
    val Array(n,k) = it.next.split(" ").map(_.toInt)
    val clouds = it.next.split(" ").map(_.toInt)
    var energy = 100
    var i = 0
    do {
      i = (i + k) % n
      energy -= 1
      if(clouds(i) == 1)
        energy -= 2
    } while(i != 0)
    println(energy)
  }
}
