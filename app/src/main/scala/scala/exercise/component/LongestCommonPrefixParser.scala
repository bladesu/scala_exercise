package scala.exercise.component

import scala.collection.parallel.CollectionConverters._

class LongestCommonPrefixParser {
  
  def parse(list: List[String]): String = {
    // choose first one as first candidate of common prefix word
    var commonPrefix = list(0)
    // elements had been validated with common prefix in last run
    var elementsAreMatchedInLastRun = list.empty
    // elements need to check in this run
    var elementsToBeCheckInThisRun = list.drop(1)
    var isSomeElementsRemainedNotChecked = true
    
    while (isSomeElementsRemainedNotChecked && commonPrefix.length > 0) {
      
      // remove first n element which is validated in last loop
      elementsToBeCheckInThisRun = elementsToBeCheckInThisRun.drop(elementsAreMatchedInLastRun.size)
      // This line should the bottle neck, time complexity: O(N)
      elementsAreMatchedInLastRun = elementsToBeCheckInThisRun.takeWhile(e => e.startsWith(commonPrefix))
      // Check if all remaining elements are validated in this run.
      if (elementsAreMatchedInLastRun.size < elementsToBeCheckInThisRun.size) {
        commonPrefix = commonPrefix.substring(0, commonPrefix.length - 1)
      } else {
        isSomeElementsRemainedNotChecked = false
      }
    }
  
    commonPrefix
  }
  
  // parallel version
  def parseV2(list: List[String]): String = {
    list.par.fold(list(0))((w1, w2) => getCommonPrefix(w1, w2))
  }
  
  private def getCommonPrefix(word1: String, word2: String) :String = {
    val charArr1: Array[Char] = word1.toCharArray
    val charArr2: Array[Char]= word2.toCharArray
    charArr1.zip(charArr2)
      .takeWhile(p => p._1 == p._2)
      .map(p => p._1)
      .mkString
  }
  

}
