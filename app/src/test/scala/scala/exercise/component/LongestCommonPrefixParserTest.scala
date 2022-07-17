package scala.exercise.component

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LongestCommonPrefixParserTest extends AnyFunSuite {
  
  var longestCommonPrefixParser = new LongestCommonPrefixParser
  
  test("two different word: no common prefix") {
    assert(longestCommonPrefixParser.parse(List("ab","cd")) == "")
  }
  
  test("two same word and one different word: no common prefix") {
    assert(longestCommonPrefixParser.parse(List("ab","ab","cd")) == "")
  }
  
  test("test single word, => whole word is the common prefix") {
    assert(longestCommonPrefixParser.parse(List("ab1")) == "ab1")
  }
  
  test("test two identical word => whole word is the common prefix") {
    assert(longestCommonPrefixParser.parse(List("abc", "abc")) == "abc")
  }
  
  test("test three word with same length with prefix ab") {
    assert(longestCommonPrefixParser.parse(List("ab1","ab2", "ab3")) == "ab")
  }
  
  test("test three word with different length with prefix ab") {
    assert(longestCommonPrefixParser.parse(List("abbb","abbbbbbbbbbbbbbb2", "ab")) == "ab")
  }
  
  test("test parseV2") {
    assert(longestCommonPrefixParser.parseV2(List("abbb","abbbbbbbbbbbbbbb2", "ab")) == "ab")
  }
}
