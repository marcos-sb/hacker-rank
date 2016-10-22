import collection.mutable

object Solution extends App {

  def reduce(ss:mutable.SortedSet[(Long,Long)], newt:(Long,Long)) = {

    def goR():Long = {
      for(track <- ss) {
        if(newt._2 + 1 < track._1) return newt._2
        if(newt._2 < track._2) return track._2
      }
      newt._2
    }
    def goL(): Long = {
      for(track <- ss) {
        if(newt._1 < track._1) return newt._1
        if(newt._1 <= track._2 + 1) return track._1
      }
      newt._1
    }
    val right = goR()
    val left = goL()
    val removes = ss.filter(track => left <= track._1 && track._2 <= right)
    ss --= removes
    ss += left -> right
  }

  val it = io.Source.stdin.getLines
  val Array(n,m,k) = it.next.split(" ").map(_.toInt)
  val trackInfo = mutable.Map[Int,mutable.SortedSet[(Long,Long)]]()
  for(_ <- 0 until k) {
    val Array(r,cl,cr) = it.next.split(" ").map(_.toInt)
    if(!trackInfo.contains(r-1))
      trackInfo += (r-1) -> mutable.SortedSet()
    reduce(trackInfo(r-1), cl-1.toLong -> (cr-1).toLong)
  }
  var spotCount = 0L
  for((_,sset) <- trackInfo) {
    var pos = 0L
    for((left,right) <- sset; if left >= pos) {
      spotCount += left - pos
      pos = right + 1L
    }
    spotCount += m - pos
  }
  val emptyRows:Long = n - trackInfo.keySet.size
  spotCount += emptyRows * m
  println(spotCount)
}
