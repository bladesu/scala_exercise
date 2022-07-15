package scala.exercise.component

class LongestCommonPrefixParser {
  
  def parse(list: List[String]): String = {
    var commonPrefix = list(0)
    val remainingElements = list.drop(1)
    val totalCnt = remainingElements.size
    var matchedCnt = 0
    // worst case:
    while (matchedCnt < totalCnt && commonPrefix.length > 0) {

      matchedCnt = remainingElements
        .takeWhile(e => e.startsWith(commonPrefix))
        .size
      
      if (matchedCnt < totalCnt)
        commonPrefix = commonPrefix.substring(0, commonPrefix.length - 1)
    }
  
    commonPrefix
  }
  
  private def keepCommonPrefix(a: String, b: String) = {
  
  }
}
