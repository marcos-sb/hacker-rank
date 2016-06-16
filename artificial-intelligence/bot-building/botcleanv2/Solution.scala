
import java.nio.file.{Files, Paths}
import java.io.{ObjectInputStream, ObjectOutputStream}

import scala.collection.{SortedSet, mutable}

object Solution {

  val dirtFile = "dirt-state.txt"
  val visitedFile = "vis-file.txt"
  val cleanedFile = "cls-file.txt"

  def fromArray(arr:Array[Int]) = {
    //assert arr.length == 2
    new Pos(arr(0), arr(1))
  }

  object Pos {
    def isVisible(pos:Pos,mat:Array[Array[Char]]) =
      mat(pos.x)(pos.y) != 'o'
    def isValid(pos:Pos,mat:Array[Array[Char]]) =
      pos.x >= 0 && pos.x < mat.length &&
        pos.y >= 0 && pos.y < mat(pos.x).length
    def isDirt(pos:Pos,mat:Array[Array[Char]]) =
      mat(pos.x)(pos.y) == 'd'
    def allVisiblePoss(pos:Pos, mat:Array[Array[Char]]) = {
      pos.allAdjs.filter(isValid(_,mat))
    }
  }

  object PosDistOrdering extends Ordering[PosDist] {
    override def compare(a:PosDist, b:PosDist) = {
      a.d compare b.d
    }

  }

  case class PosDist(p:Pos,d:Int)

  case class Pos(x:Int,y:Int) {
    def l = new Pos(x,y-1)
    def lu = new Pos(x-1,y-1)
    def u = new Pos(x-1,y)
    def ru = new Pos(x-1,y+1)
    def r = new Pos(x,y+1)
    def rd = new Pos(x+1,y+1)
    def d = new Pos(x+1,y)
    def ld = new Pos(x+1,y-1)
    def allAdjs = List(l,lu,u,ru,r,rd,d,ld)
    def allMoves = List(l,u,r,d)
    def dist(other:Pos) =
      new PosDist(other, math.abs(other.x - x) + math.abs(other.y - y))
  }

  import Pos._

  def nextMove(pos:Pos, mat:Array[Array[Char]],
    dp:mutable.Set[Pos], vp:mutable.Set[Pos], cp:mutable.Set[Pos]) = {
    def go(nextPos:Pos):String = {
      nextPos.x - pos.x match {
        case d if d < 0 => return "UP"
        case d if d > 0 => return "DOWN"
        case 0 =>
      }
      nextPos.y - pos.y match {
        case d if d < 0 => "LEFT"
        case d if d > 0 => "RIGHT"
        case 0 =>
          dp -= pos
          cp += pos
          "CLEAN"
      }
    }
    val allVisiblePos = allVisiblePoss(pos,mat)
    vp ++= allVisiblePos
    dp ++= allVisiblePos.filterNot(cp.contains).filter(isDirt(_,mat))
    val nextMove =
      if(dp.nonEmpty) {
        val distsToDirts = SortedSet[PosDist](
          dp.map(pos.dist).toSeq : _*
        )(PosDistOrdering)
        go(distsToDirts.head.p)
      } else {
        val maxNotVisited = pos.allMoves
          .map { p =>
            val allNewVisiblePos = allVisiblePoss(p,mat).filterNot(vp.contains)
            (p, allNewVisiblePos.count(_ => true))
          }.maxBy(_._2)
        if(maxNotVisited._2 > 0) {
          go(maxNotVisited._1)
        } else { //approach one of unvisited cells
          val unvisited =
            (for(i <- mat.indices; j <- mat(i).indices) yield new Pos(i,j)).toSet
          go((unvisited &~ vp).head)
        }
      }
    new ObjectOutputStream(Files.newOutputStream(Paths.get(dirtFile))).writeObject(dp)
    new ObjectOutputStream(Files.newOutputStream(Paths.get(visitedFile))).writeObject(vp)
    nextMove
  }

  def main(args: Array[String]) = {
    val it = io.Source.stdin.getLines
    val pos = fromArray(it.next.split(" ").map(_.toInt))
    val mat = ( for(l <- it) yield { l.toCharArray } ).toArray
    val dirtPositions =
      if(Files.exists(Paths.get(dirtFile)))
        new ObjectInputStream(Files.newInputStream(Paths.get(dirtFile))).readObject().asInstanceOf[mutable.Set[Pos]]
      else
        mutable.Set[Pos]()
    val cleanedPositions =
      if(Files.exists(Paths.get(cleanedFile)))
        new ObjectInputStream(Files.newInputStream(Paths.get(cleanedFile))).readObject().asInstanceOf[mutable.Set[Pos]]
      else
        mutable.Set[Pos]()
    val visitedPositions =
      if(Files.exists(Paths.get(dirtFile)))
        new ObjectInputStream(Files.newInputStream(Paths.get(visitedFile))).readObject().asInstanceOf[mutable.Set[Pos]]
      else
        mutable.Set[Pos]()

    println(nextMove(pos,mat,dirtPositions,visitedPositions, cleanedPositions))
  }
}
