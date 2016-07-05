object Solution {

  def main(args:Array[String]) = {
    val it = io.Source.stdin.getLines
    val _ = it.next
    val s = it.next.trim
    //find '010'
    def go(_s:String, pat:String) = {
      var changes = 0
      var i = 0
      while(i < _s.length - 2) {
        if(_s.substring(i,i+3) ==  pat) {
          changes += 1
          i += 3
        } else i += 1
      }
      changes
    }
    println(go(s,"010"))
  }
}
