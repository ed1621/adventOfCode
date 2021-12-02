case class Navigation(direction: String, distance: Int)
case class SubmarinePosition(horizontal: Int, vertical: Int)

val parseInput: List[String] => List[Navigation] = (input: List[String]) => 
  input.map { x => 
    val inputSplit = x.split("\\s")
    Navigation(inputSplit(0), inputSplit(1).toInt)
  }

val calcNewPosition: List[Navigation] => SubmarinePosition = (input: List[Navigation]) => 
  input.foldLeft(SubmarinePosition(0, 0))((agg, curr) => {
    curr.direction match {
      case "forward" => agg.copy(horizontal = agg.horizontal + curr.distance)
      case "down" => agg.copy(vertical = agg.vertical + curr.distance)
      case "up" => agg.copy(vertical = agg.vertical - curr.distance)
      case _ => agg
    }
  })
  
val multiplyFinalHorizontalWithFinalDepth: SubmarinePosition => Int = (finalPosition: SubmarinePosition) => 
  finalPosition.horizontal * finalPosition.vertical

def getResult(input: List[String]): Int = {
  (multiplyFinalHorizontalWithFinalDepth
    compose calcNewPosition
    compose parseInput
    )(input)
}
