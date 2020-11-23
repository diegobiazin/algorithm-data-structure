import java.util.Collections.max
import kotlin.math.max

class NewYearChaos

fun main(args: Array<String>) {
    minimumBribes(arrayOf(2, 1, 5, 3, 4))
}

fun minimumBribes(q: Array<Int>): Unit {
    var ans = 0
    for (i in q.size - 1 downTo 0) {
        if (q.get(i) - (i + 1) > 2) {
            println("Too chaotic")
            return
        }
        for (j in max(0, q.get(i) - 2) until i)
            if (q.get(j) > q.get(i))
                ans++
    }
    println(ans)
}