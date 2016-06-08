object Solution {

    private def out(b:Boolean):Unit =
        if(b) println("Valid") else println("Invalid")

    private def validate(s:String, max: Int) = {
        val f = s.toDouble
        (f, max) match {
            case (n,m) if n > m => false
            case (n,_) if n < 100 && s.length == 3 => false
            case (n,_) if n < 10 && s.length == 2 => false
            case _ => true
        }
    }

    def main(args: Array[String]) {
        val it = scala.io.Source.stdin.getLines
        val n = it.next.toInt
        val regex = """\([+\-]?(\d{1,2}(\.\d+)?),\s[+\-]?(\d{1,3}(\.\d+)?)\)""".r

        val res = for(s <- it) yield s match {
            case regex(lat, _, lon, _) => validate(lat, 90) && validate(lon, 180)
            case _ => false
        }
        res.foreach(out)
    }
}
