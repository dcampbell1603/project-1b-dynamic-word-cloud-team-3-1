package hellotest

import scala.collection.mutable

trait OutputHandler:
  def printWordCloud(
      wordFrequency: mutable.Map[String, Int],
      cloudSize: Int,
      minFrequency: Int,
      updateChart: Seq[(String, Int)] => Unit
  ): Unit = {
    val sortedWords = wordFrequency.toSeq
      .filter(_._2 >= minFrequency)
      .sortBy(-_._2)
      .take(cloudSize)

    val wordCloud = sortedWords.map { case (word, freq) => s"$word: $freq" }.mkString(" ")
    println(wordCloud)

    updateChart(sortedWords)
  }
