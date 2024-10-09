package hellotest
import scala.collection.mutable
import scala.language.unsafeNulls

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
        updateChart: Seq[(String, Int)] => Unit,
    ): Unit = {
        var steps = 0
        val words = 
        lines
        .flatMap { line => Option(line.split("(?U)[^\\p{Alpha}0-9']+").nn).toSeq.flatten }
        .map(word => word.nn.toLowerCase)
        // .filter(word => word != null && word.length >= minLength)
        .filter(word => word.length >= minLength && !ignoreList.contains(word)) // Ignore words from ignore list


        words.foreach { word =>
        this.updateWindow(word, window,wordFrequency, windowSize)
        steps += 1

        // Update and print word cloud every `everyKSteps`
        if (window.size >= windowSize && steps % everyKSteps == 0) {
            this.printWordCloud(wordFrequency, cloudSize, minFrequency, updateChart)
        }
     }
}