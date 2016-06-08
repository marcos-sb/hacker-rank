object Solution {

  sealed case class Pos(x:Int,y:Int)

  private var dirtPos = None.asInstanceOf[Option[Pos]]

  def findDirt(board:Array[String]):Pos = {
    if(dirtPos.isEmpty) {
      var found = false
      board.indices.toStream.takeWhile(_ => !found).foreach {
        i =>
          val j = board(i).indexOf('d')
          if(j > -1) { found = true; dirtPos = Some(new Pos(i,j))}
      }
    }
    dirtPos.get
  }

  def findNextMv(currPos:Pos, nextPos:Pos):String = {
    currPos.x - nextPos.x match {
      case d if d < 0 => return "DOWN"
      case d if d > 0 => return "UP"
      case 0 =>
    }
    currPos.y - nextPos.y match {
      case d if d < 0 => "RIGHT"
      case d if d > 0 => "LEFT"
      case 0 =>
        dirtPos = None
        "CLEAN"
    }
  }

  def main(args: Array[String]) = {
      val pos = Console.readLine
      val board = new Array[String](5)
      for (i <- 0 until 5) {
          board.update(i, Console.readLine)
      }
  nextMove(pos, board)
  }

  def nextMove(pos:String, board:Array[String])={
    val Array(x,y) = pos.split(" ").map(_.toInt)
    val initPos = new Pos(x,y)
    val nextPos = findDirt(board)
    println(findNextMv(initPos,nextPos))
  }
}
