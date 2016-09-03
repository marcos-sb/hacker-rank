object Solution extends App {
  val it = io.Source.stdin.getLines
  val t = it.next.trim.toInt
  def bestStrat(prices:Array[Int]):Long = {
    var best = 0
    var profit = 0L
    for(price <- prices.reverse) {
      if(price > best) best = price
      profit += best - price
    }
    profit
  }
  for(_ <- 0 until t) {
    val _ = it.next.trim.toInt
    val prices = it.next.split(" ").map(_.toInt)
    val strat = bestStrat(prices)
    println(strat)
  }
}
