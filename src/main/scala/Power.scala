object Power {
   def twoPower(n: Int): Unit ={
     if(n>30){
       throw new ArithmeticException(s"2 ^ ${n} cannot be calculated due to exception")
     }
     for(i <- 1 to n){

//The left-shift operator causes the bit pattern in the first operand to be shifted to the left by the number of bits specified by the second operand. Bits vacated by the shift operation are zero-filled. This is a logical shift instead of a shift-and-rotate operation.
//This means that the user is taking the bits value of 1 and shifting the bits to the left based on the right number.
//That means that in this case, their values will look like this in binary.
//1 << 0 = `0000 0001`
//1 << 1 = `0000 0010`
//1 << 2 = `0000 0100`

       val out = 1 << i
       System.out.println(s" 2 ^ ${i} == ${out}")
     }
   }
  def main(args: Array[String]): Unit ={
    try {
      twoPower(30)
      twoPower(31)
    }catch{
      case e: ArithmeticException => System.out.println(s"Got exception ${e.getMessage}")
    }
  }
}
