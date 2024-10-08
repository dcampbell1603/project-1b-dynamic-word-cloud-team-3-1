package hellotest

import scala.collection.mutable

trait WordCloudProcessor:
  def updateWindow(
      word: String,
      window: mutable.Queue[String],
      wordFrequency: mutable.Map[String, Int],
      windowSize: Int
  ): Unit = {
    window.enqueue(word)
    wordFrequency(word) += 1

    if (window.size > windowSize) {
      val oldWord = window.dequeue()
      wordFrequency(oldWord) -= 1
      if (wordFrequency(oldWord) == 0) {
        wordFrequency.remove(oldWord)
      }
    }
  }
