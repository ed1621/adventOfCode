val getSlidingWindow: Int => List[Int] => List[List[Int]] = windowSize => report => report.sliding(windowSize).toList

val getSlidingWindowOfTwo = getSlidingWindow(2)
val getSlidingWindowOfThree = getSlidingWindow(3)

val getIncreasesInDepth: List[List[Int]] => List[List[Int]] = windowSums => 
  getSlidingWindowOfTwo(windowSums.map(_.sum))
    .toList
    .filter { case List(prev,curr) => prev < curr }


val countTotalIncreases: List[Int] => Int = report => (getIncreasesInDepth compose getSlidingWindowOfThree)(report).size
