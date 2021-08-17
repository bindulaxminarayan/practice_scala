import scala.util.Random

/**
 * Write a Scala program to compute the sum of the two given integer values.
 * If the two values are the same, then return triples their sum
 **/
object SumOfIntegers {
  //for max integer value - this code breaks
   def sum(a: Int, b: Int) :Int={
     System.out.println(s"Computing Sum of ${a}, ${b}")
     if(a.toLong+b.toLong > Int.MaxValue){
       throw new ArithmeticException("Integer Overflow")
     }else{
       if(a == b) (3*(a+b)) else (a+b)
     }
   }

  def main(args: Array[String]): Unit ={
    try{
      val sum = SumOfIntegers.sum(Random.nextInt(), Random.nextInt())
      System.out.println(s"Sum returned: ${sum}")
    }catch{
      case e: ArithmeticException => System.out.println(s"Arithmetic exception as expected: ${e.getMessage}")
    }
    val integerOverflowEx1 = SumOfIntegers.sum(Int.MaxValue,0)
    System.out.println(s"Sum returned: ${integerOverflowEx1}")
    try{
      val integerOverflowEx2 = SumOfIntegers.sum(Int.MaxValue,1)
      System.out.println(s"Sum returned: ${integerOverflowEx2}")
    }catch{
      case e: ArithmeticException => System.out.println(s"Arithmetic exception as expected: ${e.getMessage}")
    }
  }
}
