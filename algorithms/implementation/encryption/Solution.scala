object Solution {

    def main(args: Array[String]) {
        val word : String = io.Source.stdin.getLines().next()
        val sqrtLenWord : Double = math.sqrt(word.length)
        val h : Integer = math.floor(sqrtLenWord).toInt
        val w : Integer = math.ceil(sqrtLenWord).toInt
        val s : StringBuilder = new StringBuilder()
        var i : Integer = 0
        for(i <- 0 until w) {
            for(j <- i until word.length by w) {
                s += word.charAt(j)
            }
            s += ' '
        }
        println(s)
    }
}
