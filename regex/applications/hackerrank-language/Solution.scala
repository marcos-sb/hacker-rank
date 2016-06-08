object Solution {

    def main(args: Array[String]) {
        val it = scala.io.Source.stdin.getLines
        val n = it.next.toInt
        val regex = """^\d+\s(C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)$""".r

        val res = for(s <- it) yield s match {
            case regex(_*) => true
            case _ => false
        }
        res.map(if(_) "VALID" else "INVALID").foreach(println)
    }
}
