package hellotest
import scala.collection.mutable

trait InputProcessor
    def processInput(
        lines: Iterator[String],
        minLength: Int,
        window: mutable.Queue[String],
        wordFrequency: mutable.Map[String, Int],
        windowSize: Int,
        everyKSteps: Int,
        cloudSize: Int,
        minFrequency: Int,
        ignoreList: Set[String],
        updateChart: Seq[(String, Int)] => Unit
    ): Unit = {
        var steps = 0
        val words = 
        import scala.language.unsafeNulls
        lines
        .flatMap(l => l.split("(?U)[^\\p{Alpha}0-9']+"))
        .map(_.toLowerCase)
        // .filter(word => word != null && word.length >= minLength)
        .filter(word => word != null && word.length >= minLength && !ignoreList.contains(word)) // Ignore words from ignore list


        words.foreach { word =>
        updateWindow(word, window, wordFrequency, windowSize)
        steps += 1

        // Update and print word cloud every `everyKSteps`
        if (window.size >= windowSize && steps % everyKSteps == 0) {
            printWordCloud(wordFrequency, cloudSize, minFrequency, updateChart)
        }
     }
}