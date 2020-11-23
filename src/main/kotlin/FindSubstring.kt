class FindSubstring

fun main(args: Array<String>) {
    print(twoStrings("hello", "world"))
    print(findSubstring("azerdii", 5))
}

fun findSubstring(s: String, k: Int): String {
    var mapOfVowels = HashMap<String, Int>()
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    for (i in 0 until k) {
        if (k+i > s.length)
            break
        var characters = s.substring(i, k+i)
        mapOfVowels[characters] = 0
        if (characters.length == k) {
            characters.forEach {
                if (vowels.contains(it))
                    mapOfVowels[characters] = mapOfVowels[characters]!!+1
            }

        }
    }

    var maxVowels = 0
    var resultSubstring = "Not found!"
    mapOfVowels.forEach {
        if (it.value > maxVowels) {
            resultSubstring = it.key
            maxVowels = it.value
        }
    }

    return resultSubstring
}