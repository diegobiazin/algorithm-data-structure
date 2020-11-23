import kotlin.math.absoluteValue

class RansomNote

fun main(args: Array<String>) {
    var m = arrayOf("ive", "got", "a", "lovely", "bunch", "of", "coconuts")
    var n = arrayOf("ive",  "got", "some", "coconuts")
    print(checkMagazine(m, n))
}

// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {

    var magazineWords = HashMap<String, Int>()
    magazine.forEach {
        if (magazineWords[it] != null) {
            magazineWords[it] = magazineWords[it]!! +1
        } else {
            magazineWords[it] = 1
        }
    }

    var remaingNote = note.size
    note.forEach {
        if (magazineWords[it] != null && magazineWords[it]!! >= 1) {
            magazineWords[it] = magazineWords[it]!! -1
            remaingNote--
        }
    }

    if (remaingNote == 0)
        return print("Yes")

    return print("No")
}
