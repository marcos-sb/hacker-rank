object Solution {
  def movs(arr:Array[Long]) = {
    def go(mid:Int,lefts:Long,rights:Long,mov:Int,lo:Int,hi:Int,le:Int):Int = {
      if(lo > hi) return mov
      if(lefts < rights && mid < hi) {
        if(le == -1) return mov
        go(mid+1,lefts+arr(mid),rights-arr(mid),mov,lo,hi,1)
      } else if(lefts > rights && mid > 0) {
        if(le == 1) return mov
        go(mid-1,lefts-arr(mid-1),rights+arr(mid-1),mov,lo,hi,-1)
      } else if(lefts == rights) {
        val newhil = mid - 1
        val newmidl = (lo + newhil) / 2
        val newrightsl = (for(i <- newmidl to newhil) yield arr(i)).sum
        val newleftsl = lefts - newrightsl
        val msleft = go(newmidl,newleftsl,newrightsl,mov+1,lo,newhil,0)
        val newlor = mid+1
        val newmidr = (newlor + hi) / 2
        val newrightsr = (for(i <- newmidr to hi) yield arr(i)).sum
        val newleftsr = rights - newrightsr
        val msright = go(newmidr,newleftsr,newrightsr,mov+1,newlor,hi,0)
        math.max(msleft,msright)
      } else mov
    }
    val mid = arr.length / 2
    val lefts = (for(i <- 0 until mid) yield arr(i)).sum
    val rights = (for(i <- mid until arr.length) yield arr(i)).sum
    go(mid,lefts,rights,0, 0,arr.length-1,0)
  }

  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val n = it.next.toInt
    for(_ <- 0 until n) {
      val sz = it.next.toInt
      val arr = it.next.split(" ").map(_.toLong)
      if(arr.sum > 0)
        println(movs(arr))
      else println(arr.length - 1)
    }
  }
}
