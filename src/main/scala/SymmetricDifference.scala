import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**Find the Symmetric Difference
The mathematical term symmetric difference (△ or ⊕) of two sets is the set of elements which are in either of the
two sets but not in both. For example, for sets A = {1, 2, 3} and B = {2, 3, 4}, A △ B = {1, 4}.
Symmetric difference is a binary operation, which means it operates on only two elements. So to evaluate an expression
involving symmetric differences among three elements (A △ B △ C), you must complete one operation at a time.
Thus, for sets A and B above, and C = {2, 3}, A △ B △ C = (A △ B) △ C = {1, 4} △ {2, 3} = {1, 2, 3, 4}.
**/
object SymmetricDifference {
  //O(N**2)
   def symmNSquare(arr1: Array[Int], arr2: Array[Int]) :Unit ={
     var symList = new ListBuffer[Int]
     for(a1 <- arr1){
       var visited = false;
       for(a2 <- arr2){
         if(a1 == a2){
           visited = true;
         }
       }
       if(!visited){
         symList += a1
       }
     }

     for(a2 <- arr2){
       var visited = false;
       for(a1 <- arr1){
         if(a2 == a1){
           visited = true;
         }
       }
       if(!visited){
         symList += a2
       }
     }
     System.out.println("A Sym B: "+symList.toList)
   }

  //O(NlogN)
  def symN(arr1: Array[Int], arr2: Array[Int]): Unit ={
    var l = new mutable.TreeSet[Int]
    for(a1 <- arr1){
      //contains for a tree is O(log N)
      if(l.contains(a1)){
        l.remove(a1)
      }else{
        l.add(a1)
      }
    }
    for(a2 <- arr2){
      if(l.contains(a2)){
        l.remove(a2)
      }else{
        l.add(a2)
      }
    }
    System.out.println(l.toList)
  }

  //O(N**2) solution
  def symIndexOf(arr1: Array[Int], arr2: Array[Int]): Unit ={
    var l = new ListBuffer[Int]
    for(a1 <- arr1 ){
      if(arr2.indexOf(a1) == -1){
        l += a1
      }
    }

    for(a2 <- arr2){
      if(arr1.indexOf(a2) == -1){
        l += a2
      }
    }
    System.out.println(l.toList)
  }

  def main(args: Array[String]): Unit ={
    symmNSquare(Array(1,2,3,4), Array(2,3,4,5))
    symmNSquare(Array(1,2,3), Array(5,2,1,4))
    symN(Array(1,2,3,4), Array(2,3,4,5))
    symN(Array(1,2,3), Array(5,2,1,4))
    symIndexOf(Array(1,2,3,4), Array(2,3,4,5))
    symIndexOf(Array(1,2,3), Array(5,2,1,4))
  }
}
