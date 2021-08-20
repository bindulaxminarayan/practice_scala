package TwoPointer

/**
 Given an integer array nums sorted in non-decreasing order,
 remove the duplicates in-place such that each unique element appears only once.
 The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages,
you must instead have the result be placed in the first part of the array nums.
More formally, if there are k elements after removing the duplicates,
then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by
modifying the input array in-place with O(1) extra memory.
 */

object RemoveDuplicates {
  def removeDuplicatesExtraSpace(n: Array[Int]): Array[Int] ={
    val output = Array.ofDim[Int](n.length)
    var j=0;
    for(i <-0 to n.length-2){
       if(n(i) != n(i+1)){
         output(j) = n(i)
         j=j+1
       }
    }
    output(j) = n(n.length-1)
    output
  }

  def removingDuplicatesWithoutExtraArray(n:Array[Int]): Array[Int] ={
    var j = 0;
    for(i <- 0 to n.length-2){
      if(n(i) != n(i+1)){
        n(i) = n(i+1)
        j=j+1
      }
      if(i>j){
        n(i)=0
      }
    }
    //Replace the last item
    n(n.length-1)=0
    n
  }

def main(arr: Array[String]): Unit ={
  val input = Array(0,0,1,2,3,3)
  val op = removeDuplicatesExtraSpace(input)
  System.out.println("With Extra space")
  op.foreach(x=> System.out.print(x))
  System.out.println("")
  val op1 = removingDuplicatesWithoutExtraArray(input)
  System.out.println("Without Extra space")
  op1.foreach(x=> System.out.print(x))
}

}
