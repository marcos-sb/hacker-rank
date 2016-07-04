import scala.annotation.tailrec

object Solution {
  def main(args:Array[String]) = {
    val s = io.Source.stdin.getLines.next.trim

    @tailrec
    def go(_s:List[Char], reduced:StringBuilder, replay:Boolean):String = _s match {
      case Nil =>
        if(replay)
          go(reduced.toString.toList,new StringBuilder(),false)
        else reduced.toString
      case h1 :: h2 :: t if h1 == h2 => go(t,reduced,true)
      case h :: t => go(t,reduced.append(h),replay || false)
    }
    val gos = go(s.toList, new StringBuilder(), false)
    if(gos == "") println("Empty String")
    else println(gos.mkString)
  }
}
