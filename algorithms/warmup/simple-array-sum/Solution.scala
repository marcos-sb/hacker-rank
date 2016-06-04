object Solution {

    def main(args: Array[String]) {
        for(line <- io.Source.stdin.getLines.drop(1)) {
            println(line.split(" ").map(_.toInt).sum)
        }
    }
}
