package TwoPointer

import scala.util.control.Breaks.{break, breakable}

/**
 * Given an array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 *
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
 * where 1 <= answer[0] < answer[1] <= numbers.length.
 *
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 */
object TwoSum {

  def sumWithPointers(n: Array[Int], target: Int): Unit = {
    var i = 0
    var j = n.length - 1
    var found = false
    breakable {
      while (i < j) {
        if (n(i) + n(j) > target) {
          j = j - 1
        }
        if (n(i) + n(j) == target) {
          System.out.println("Found elements " + n(i) + ":" + n(j) + " that sums to " + target)
          found = true
          break()
        }
        if (n(i) + n(j) < target) {
          i = i + 1
        }
      }
    }
    if(!found){
      System.out.println("Cannot identify numbers that sum up to: "+target)
    }
  }

  def main(arr: Array[String]): Unit = {
    val n = Array(1, 2, 3, 4, 5)
    sumWithPointers(n, 10)
  }
}
