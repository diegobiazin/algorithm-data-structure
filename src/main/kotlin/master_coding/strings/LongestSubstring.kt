package master_coding

fun main() {
    print(longestSubstring("abccabb"))
    print(longestSubstringOptimal("abccabb"))
}

fun longestSubstring(s: String): Int {
    if (s.length <= 1)
        return s.length

    var longest = 0

    for (left in s.indices) {
        var seenChars = mutableMapOf<Char, Boolean>()
        var currentLength = 0

        for (right in left until s.length) {
            val currentChar = s[right]

            if (seenChars.get(currentChar) == null) {
                currentLength++
                seenChars[currentChar] = true
                longest = Math.max(longest, currentLength)
            } else {
                break
            }
        }
    }

    return longest
}

fun longestSubstringOptimal(s: String): Int {
    if(s.length <= 1)
        return s.length

    val seen = mutableMapOf<Char, Int>()
    var left = 0
    var longest = 0

    for(right in s.indices) {
        val currentChar = s[right]
        val previouslySeenChar = seen[currentChar] ?: -1

        if(previouslySeenChar >= left) {
            left = previouslySeenChar + 1
        }

        seen[currentChar] = right

        longest = Math.max(longest, right - left + 1)
    }

    return longest
}