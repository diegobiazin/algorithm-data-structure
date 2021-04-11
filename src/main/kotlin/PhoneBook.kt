import java.io.*
import java.math.BigInteger
import java.util.*
import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
//    print(factorial(3))
//    phoneBook(arrayOf("3",
//            "sam 99912222",
//            "tom 11122222",
//            "harry 12299933",
//            "sam",
//            "edward",
//            "harry"))
    extraLongFactorials(1)
}

fun phoneBook(args: Array<String>) {
    val n = readLine()?.toInt()
    val phoneBook = HashMap<String, String>()
    for (i in 0 until n!!) {
        val c = readLine()?.split(" ")
        phoneBook[c!![0]] = c[1]
    }

    var name = readLine()
    while (name != null) {
        val v = readLine()
        val s = phoneBook[v]
        if (s != null)
            print("$v $s\n")
        else
            print("Not found\n")
        name = readLine()
    }

}

// Complete the factorial function below.
fun factorial(n: Int): Int {
    return if (n >= 1)
        n * factorial((n - 1))
    else
        1
}

fun extraLongFactorials(n: Int): Unit {
    var result: BigInteger = n.toBigInteger()
    for (i in 1 until n) {
        result *= (n - i).toBigInteger()

    }
    println(result)
}
