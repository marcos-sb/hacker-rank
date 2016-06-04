object Solution {

  private def pangram(s: String):Boolean = {
    val indx = Array.fill[Int]('z' - 'a' + 1)(0)
    s.toLowerCase.filterNot(c => c == ' ').foreach {c =>
      indx(c - 'a') += 1
    }
    for(i <- indx) if(i < 1) return false
    true
  }

  def main(args: Array[String]) = {
    val it = scala.io.Source.stdin.getLines
    val s = it.next.trim()
    println(if(pangram(s)) "pangram" else "not pangram")
  }
}
