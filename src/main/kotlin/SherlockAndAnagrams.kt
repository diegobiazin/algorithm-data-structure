import java.util.*
import kotlin.collections.HashMap

class SherlockAndAnagrams

fun main(args: Array<String>) {
    print(sherlockAndAnagrams("abba"))
}

fun sherlockAndAnagrams(s: String): Int {
    val mapOfAnagrams = HashMap<String, Int>()
    for (i in s.indices) {
        for (j in (i + 1) .. s.length) {
            val s = s.substring(i, j).toCharArray()
            Arrays.sort(s)
            val k = String(s)
            if (mapOfAnagrams[k] != null) {
                mapOfAnagrams[k] = mapOfAnagrams[k]!! + 1
            } else {
                mapOfAnagrams[k] = 1
            }
        }
    }

    var result = 0
    mapOfAnagrams.forEach {
        result += (it.value * (it.value - 1)) / 2
    }

    return result
}
