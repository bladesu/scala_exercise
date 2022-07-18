package scala.exercise.component

import scala.collection.mutable
import scala.jdk.StreamConverters.IntStreamHasToScala
import scala.util.control.Breaks

class ParenthesesValidator {
  
  private val ketsToBrasMap = Map(
    '}' -> '{',
    ']' -> '[',
    ')' -> '('
  )
  
  private val ketsSet = Set('}', ']', ')')
  
  def isValidated(toCheckWord: String): Boolean = {
    // pre-check (additional)
    if (toCheckWord.isEmpty) return false
    
    // FILO stack,
    // Worst case here the stack will be increased to the size of half the toCheckWord.
    // Space complexity: O(N)
    val stack = new mutable.Stack[Char]
    
    // Wrap up data stream to scala iterator
    val iterator = toCheckWord.chars().toScala(Iterator)
    
    val loop = new Breaks
    loop.breakable {
      // Get first char and push to stack as first element
      stack.push(iterator.next().toChar)
      // Worst case , time complexity: O(N)
      while (iterator.hasNext) {
        val lastCharOpt: Option[Char] = if (stack.isEmpty) None else Some(stack.pop())
        val nextChar: Char = iterator.next().toChar
        
        if (lastCharOpt.isEmpty) { // no element in stack
          stack.push(nextChar)
          if (ketsSet.contains(nextChar)) {
            // nextChar is ket, it is not necessary to iterate all data anymore.
            loop.break()
          }
        } else if (lastCharOpt.get != ketsToBrasMap.get(nextChar).getOrElse(null)) {
          stack.push(lastCharOpt.get)
          stack.push(nextChar)
        }
        // currentChar and nextChar, this pair should be eliminated together.
      }
    }
    stack.isEmpty
  }
}
