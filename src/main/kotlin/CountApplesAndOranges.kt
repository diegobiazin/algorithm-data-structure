fun main() {
    countApplesAndOranges(7, 11, 5, 15, arrayOf(-2, 2, 1), arrayOf(5, -6))
}

fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
    var numberOfApples = 0
    var numberOfOrages = 0

    for (i in apples) {
        if (a + i in s..t)
            numberOfApples++
    }

    for (i in oranges) {
        if (b + i in s..t)
            numberOfOrages++
    }
    print( "$numberOfApples\n")
    print(numberOfOrages)
}