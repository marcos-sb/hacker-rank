object Solution extends App {

  def max(a:Char,b:Char):Char = if(a >= b) a else b

  val it = io.Source.stdin.getLines
  val Array(n,k) = it.next.split(" ").map(_.toInt)
  val nums = it.next.toCharArray
  var diffs = 0
  var i = 0
  while(i < n/2) {
    val j = n - 1 - i
    if(nums(i) != nums(j)) diffs += 1
    i += 1
  }
  if(k < diffs) println("-1")
  else {
    var _k = 0
    i = 0
    while(i < n/2) {
      val j = n - 1 - i
      if(nums(i) == nums(j) && nums(i) != '9' && k - _k > diffs + 1) {
        nums(i) = '9'; nums(j) = '9'
        _k += 2
      } else if(nums(i) != nums(j)) {
        if(nums(i) == '9' || nums(j) == '9' || k - _k == diffs) {
          nums(i) = max(nums(i),nums(j))
          nums(j) = nums(i)
          _k += 1
        } else if(k - _k >= diffs + 1) {
          nums(i) = '9'; nums(j) = '9'
          _k += 2
        }
        diffs -= 1
      }
      i += 1
    }
    if(n % 2 != 0 && nums(n/2) < '9' && k > _k) nums(n/2) = '9'
    println(nums.mkString)
  }
}
