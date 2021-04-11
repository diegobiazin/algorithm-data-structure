import kotlin.math.absoluteValue

fun main() {
    print(timeConversion("04:59:59AM"))
}

fun timeConversion(s: String): String {
    val split = s.split(":")
    return if (split[2].contains("AM")) {
        val time = if (split[0].toInt() - 12 == 0) "00" else split[0]
        "$time:${split[1]}:${split[2].substring(0, 2)}"
    } else {
        val time = if (split[0].toInt() + 12 == 24) "12" else (split[0].toInt() + 12).toString()
        "$time:${split[1]}:${split[2].substring(0, 2)}"
    }
}