class TwoStrings

fun main(args: Array<String>) {
    print(twoStrings("hello", "world"))
}

fun twoStrings(s1: String, s2: String): String {

    val letters = HashSet<Char>()
    s1.forEach {
        letters.add(it)
    }

    s2.forEach {
        if (letters.contains(it))
            return "YES"
    }

    return "NO"
}
