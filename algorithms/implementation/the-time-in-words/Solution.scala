object Solution {

    def toText(h:Int): String = h match {
        case 1 => "one"
        case 2 => "two"
        case 3 => "three"
        case 4 => "four"
        case 5 => "five"
        case 6 => "six"
        case 7 => "seven"
        case 8 => "eight"
        case 9 => "nine"
        case 10 => "ten"
        case 11 => "eleven"
        case 12 => "twelve"
        case 13 => "thirteen"
        case 14 => "fourteen"
        case 15 => "fifteen"
        case 16 => "sixteen"
        case 17 => "seventeen"
        case 18 => "eighteen"
        case 19 => "nineteen"
        case 20 => "twenty"
        case 30 => "thirty"
        case 40 => "forty"
        case 50 => "fifty"
        case n => {
            val n_teens = n / 10
            val n_ones = n - n_teens * 10
            s"${toText(n_teens*10)} ${toText(n_ones)}"
        }
    }

    def toFullText(h:Int, m:Int): String =
        m match {
            case 0 => s"${toText(h)} o' clock"
            case 15 => s"quarter past ${toText(h)}"
            case 30 => s"half past ${toText(h)}"
            case 45 => s"quarter to ${toText(h+1)}"
            case n if n < 30 => s"${toText(m)} minutes past ${toText(h)}"
            case _ => s"${toText(60 - m)} minutes to ${toText(h+1)}"
        }

    def main(args: Array[String]) {
        val it = io.Source.stdin.getLines
        val h = it.next.toInt
        val m = it.next.toInt
        println(toFullText(h,m))
    }
}
