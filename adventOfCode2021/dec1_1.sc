def getThing(report: List[Int]) = {
  val prevCurrentPairs = for {
    window <- report.sliding(2)
  } yield (window(0), window(1))

  prevCurrentPairs.toList.filter{ case (prev,curr) => prev < curr }.size
}
