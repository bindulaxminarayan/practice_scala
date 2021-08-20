package TwoPointer

object StringReverse {

  def reverse(s: String): String ={
    val output = new StringBuilder()
    for( i <- s.length-1 to 0 by -1){
      output ++= s.charAt(i).toString
    }
    output.toString()
  }

  def main(arr: Array[String]): Unit ={
    val input = "Hello my name is Lisa"
    System.out.println(s"Output ${ reverse(input)}")
  }

}
