object Solution extends App {
  import collection.mutable
  def pairSubsets(set:Set[Char]):Array[(Char,Char)] = {
    val ab = mutable.ArrayBuffer[(Char,Char)]()
    val arr = set.toArray
    for(i <- arr.indices) {
      for(j <- i+1 until arr.length) {
        ab += arr(i) -> arr(j)
      }
    }
    ab.toArray
  }
  val it = io.Source.stdin.getLines
  val _ = it.next
  val s = it.next.trim
  val charSet = s.toSet
  val ps = pairSubsets(charSet)
  var maxLength = 0
  for(pair <- ps) {
    def fnext(_c:Char) = if(_c == pair._1) Some(pair._2)
                         else Some(pair._1)
    def go():Int = {
      var nextChar:Option[Char] = None
      var length = 0
      for(c <- s) {
        if(c == pair._1 || c == pair._2) {
          if(nextChar.isEmpty || nextChar.contains(c)) {
            nextChar = fnext(c)
            length += 1
          } else return 0 // c == pair._1; nextChar == pair._2 => repeated pair._1
        }
      }
      length
    }
    maxLength = math.max(go(),maxLength)
  }
  println(maxLength)
}
