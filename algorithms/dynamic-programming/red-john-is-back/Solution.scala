import collection.mutable

object Solution extends App {

  def sieve(n:Int) = {
    val preprimes = Array.fill[Boolean](n)(false)
    var i = 2
    while(i <= math.sqrt(n)) {
      for(j <- i+i until n by i) {
        preprimes(j) = true
      }
      i += 1
      while(preprimes(i)) i += 1
    }
    (for(j <- preprimes.indices.drop(2)) yield j).filter(!preprimes(_))
  }

  val primes = sieve(300000)
  val cache = mutable.Map[Int,Int]()
  def psthan(n:Int):Int = {
    if(cache.contains(n)) return cache(n)
    var smallers_n = 0
    for(i <- primes) {
      if(i > n) {
        cache += (n -> smallers_n)
        return smallers_n
      } else
        smallers_n += 1
    }
    smallers_n
  }
  def placeBricks(sz:Int) = {
    def go(horizontal: Boolean, freeDims:(Int,Int), ways:Int):Int = {
      var _freeDims = freeDims
      if(horizontal) {
        if(_freeDims._1 > 0) _freeDims = (_freeDims._1 - 1,_freeDims._2)
        if(_freeDims._1 == 0) _freeDims = (_freeDims._1,freeDims._2 + 4)
      } else {
        if(_freeDims._1 > 0) _freeDims = (_freeDims._1 - 4,_freeDims._2)
        if(_freeDims._1 == 0) _freeDims = (_freeDims._1,freeDims._2 + 1)
      }
      if(_freeDims == (0,sz))
        return ways + 1
      if(_freeDims._1 < 0 || _freeDims._2 > sz) return ways
      go(true, _freeDims, ways) + go(false, _freeDims, ways)
    }
    go(true,(4,0),0) + go(false,(4,0),0)
  }

  val it = io.Source.stdin.getLines
  val t = it.next.trim.toInt

  for(_ <- 0 until t) {
    val n = it.next.trim.toInt
    println(psthan(placeBricks(n)))
  }
}
