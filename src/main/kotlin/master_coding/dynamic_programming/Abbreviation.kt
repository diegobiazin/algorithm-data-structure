package master_coding.dynamic_programming

fun main() {
    println(abbreviation("daBcd", "ABC"))
}

fun abbreviation(a: String, b: String): String {
    val isValid = Array(a.length + 1) { BooleanArray(b.length + 1) }

    isValid[0][0] = true

    for (i in 1..a.length)
        isValid[i][0] = !Character.isUpperCase(a[i - 1])


    for (i in 1..a.length) {
        for (j in 1..b.length) {
            val prevResut = isValid[i - 1][j - 1]
            val aboveResult = isValid[i - 1][j]

            if (a[i - 1] == b[j - 1]) {
                isValid[i][j] = prevResut
            } else if (Character.toUpperCase(a[i - 1]) == b[j - 1]) {
                isValid[i][j] = prevResut || aboveResult
            } else if (Character.isUpperCase(a[i - 1])) {
                isValid[i][j] = false
            } else {
                isValid[i][j] = aboveResult
            }
        }
    }

    return if (isValid[a.length][b.length]) "YES" else "NO"
}