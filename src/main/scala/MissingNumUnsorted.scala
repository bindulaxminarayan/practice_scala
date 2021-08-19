import scala.util.control.Breaks._

/** Assume we're given an unsorted array of numbers such as this:
 *
 * [ 2, 5, 1, 4, 9, 6, 3, 7 ]
 * We are told that when this array is sorted, there is a series of n consecutive numbers.
 * You are given a lower bound and an upper bound for this sequence.
 * There is one consecutive number missing, and we need to find it.
 * As an example, look at the below example. We're told that the lower bound is 1 and the upper bound is 9.
 * The number that's missing in the unsorted series bounded by these two number is 8.
 * */
object MissingNumUnsorted {

  /**
   * This solution uses list.contains which is O(n). Hence the solution will be O(n2)
   * @param n
   * @param lowerBound
   * @param upperBound
   * @return
   */
  def missingNumber(n: List[Int], lowerBound: Int, upperBound: Int): Int = {
    var num = 0
    var expectedNum = lowerBound
    breakable {
      for (i <- lowerBound to upperBound) {
        if (!n.contains(i)) { // List.contains is O(n)
          num = i
          break()
        } else {
          expectedNum = expectedNum + 1
        }
      }
    }
    num
  }

  /**
   * If the series always starts with 1 then the sum can be calculated as n*(n+1)/2. when there is a lower bound i.e
   * series does not start with 1, then the sum can be calculated as total pairs(numbers/2)*(lowerbound+upperbound)
   * @param n
   * @param lowerBound
   * @param upperBound
   * @return
   */
  def missingNumberOofN(n:Array[Int], lowerBound: Int, upperBound: Int): Int ={
    val numberOfIntegers = upperBound-lowerBound+1
    val sum = ((numberOfIntegers)*(lowerBound+upperBound)/2)
    var actualSum = 0
    for(i <- n.indices){
      actualSum = actualSum+n(i)
    }
    sum - actualSum
  }

  def main(arr: Array[String]): Unit = {
    val input = Array(-3,2,-1,0,1,3,4,5,6)
    val lowerBound = -3
    val upperBound = 6
    val missingNum = MissingNumUnsorted.missingNumber(input.toList, lowerBound, upperBound)
    System.out.println(s"Missing number is ${missingNum}")
    val ms2 = MissingNumUnsorted.missingNumberOofN(input,lowerBound,upperBound)
    System.out.println(s"Missing number with O(N) is ${ms2}")
  }
}
