object PairsFromArrays {

  //Given an array arr[] of N integers where N is even, the task is to group the
  // array elements in the pairs (X1, Y1), (X2, Y2), (X3, Y3), …
  // such that the sum min(X1, Y1) + min(X2, Y2) + min(X3, Y3) + … is maximum.


  def main(args: Array[String]): Unit ={
    val input = Array(1,3,2,6,5,4)
    //Sort the array
    scala.util.Sorting.quickSort(input)
    // To store the sum
    var sum = 0
    // Start making pairs of every two
    // consecutive elements as n is even
    for(i <-input.indices by 2){
      System.out.println(s"Pair ${input(i)}, ${input(i+1)}")
      sum = sum+input(i)
    }
   System.out.println(sum)
  }
}
