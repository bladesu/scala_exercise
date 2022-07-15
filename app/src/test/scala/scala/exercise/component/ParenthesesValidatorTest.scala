package scala.exercise.component

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ParenthesesValidatorTest extends AnyFunSuite {
  
  var validator = new ParenthesesValidator
  
  test("empty string should return false") {
    assert(validator.isValidated("") == false)
  }
  
  test("single brackets pairs should return true") {
    assert(validator.isValidated("{}") == true)
    assert(validator.isValidated("[]") == true)
    assert(validator.isValidated("()") == true)
  }
  
  test("sequential closed brackets pairs should return true") {
    assert(validator.isValidated("{}[]()") == true)
    assert(validator.isValidated("(){}[]") == true)
    assert(validator.isValidated("[](){}") == true)
  }
  
  test("not interlaced but closed brackets pairs should return true") {
    assert(validator.isValidated("{[]()}") == true)
    assert(validator.isValidated("{[()]}") == true)
  }
  
  test("interlaced brackets pairs should return true") {
    assert(validator.isValidated("{[]()}") == true)
    assert(validator.isValidated("{[()]}") == true)
  }
  
}
