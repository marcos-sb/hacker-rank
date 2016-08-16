object Solution extends App {
  val it = io.Source.stdin.getLines
  val n = it.next.toInt
  val people = it.next.split(" ").map(_.toInt)
  var loaves = 0
  for(i <- 0 until people.length-1) {
    if(people(i) % 2 == 1) {
      people(i) += 1; people(i+1) +=1
      loaves += 2
    }
  }
  var possible = true
  Stream.range(0,people.length).takeWhile(i => possible).foreach {i =>
    if(people(i) % 2 == 1) possible = false
  }
  if(possible) println(loaves)
  else println("NO")
}
