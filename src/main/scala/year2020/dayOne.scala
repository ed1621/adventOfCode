package year2020

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._

object dayOne extends App with resourceValues {

  val spark = SparkSession
    .builder()
    .appName("Expense Report")
    .config("spark.master", "local")
    .getOrCreate()

  spark.read.text(s"$resources2020/expenseReport.txt").show()
}
