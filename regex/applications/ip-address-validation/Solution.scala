object Solution {

    def main(args: Array[String]) {
        val it = scala.io.Source.stdin.getLines
        val n = it.next.toInt
        val ipv4RE = """^((([10]?\d?\d)|(2[0-5]{2}))\.){3}(([10]?\d?\d)|(2[0-5]{2}))$""".r
        val ipv6RE = """^([A-Fa-f0-9]{1,4}:){7}[A-Fa-f0-9]{1,4}$""".r

        val res = for(s<-it) yield s.trim match {
            case ipv4RE(_*) => "IPv4"
            case ipv6RE(_*) => "IPv6"
            case _ => "Neither"
        }

        res.foreach(println)
    }
}
