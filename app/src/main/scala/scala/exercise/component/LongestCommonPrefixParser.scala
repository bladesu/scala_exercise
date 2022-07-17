package scala.exercise.component

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
  
}
