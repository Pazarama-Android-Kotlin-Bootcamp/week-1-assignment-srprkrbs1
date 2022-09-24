import java.util.Scanner


//First Question

fun CodelandUsernameValidation(str: String): Boolean {

  var bool = str.length in 4..25
  bool = bool && (str[0] in 'a'..'z' || str[0] in 'A'..'Z')

  str.forEach {
    bool = bool && (it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' || it == '_')
  }
  
  return bool
  
}


//Second Question

fun aVeryBigSum(ar: Array<Long>) = ar.sum()



//Fourth Question

fun FirstFactorial(num: Int): Int {

  if(num == 1){
    return 1
  }else{
    return num * FirstFactorial(num - 1)
  }
  
}


//Fifth Question

fun QuestionsMarks(str: String): String {
    var QuestionMarkCounter = 0
    var lastDigit = -1
    var bool = "false"

    for (char in str) {
        if (char.isDigit()) {
            val digit = Integer.valueOf(char.toString())
            val sum = digit + lastDigit
            lastDigit = digit

            if (sum != 10) {
                QuestionMarkCounter = 0
                continue
            }

            bool = if (QuestionMarkCounter == 3)
                "true"
            else
                "false"
            QuestionMarkCounter = 0
        } else if (char == '?') QuestionMarkCounter++
    }

    return bool;
}



fun main() {
  
  println("First Question")
  println(CodelandUsernameValidation("aa_")) //False
  println(CodelandUsernameValidation("u__hello_world123")) //True
  println()

  println("Second Question")
  val scanner  = Scanner(System.`in`)
  val arr = scanner.nextLine().split(" ").map{ it.trim().toLong() }.toTypedArray()
      
  println(aVeryBigSum(arr))
  println()

  println("Fourth Question")
  println(FirstFactorial(4)) // 24
  println(FirstFactorial(8)) // 40320
  println()

  println("Fifth Question")
  println(QuestionsMarks("aa6?9")) //False
  println(QuestionsMarks("acc?7??sss?3rr1??????5")) //True
  println()
}