package master_coding

import kotlin.math.floor

fun main() {
    val input = "A man, a plan, a canal: Panama"
    print(palindromeCompareAgainstReverse(input))
    print(palindromeTwoPointerFromOutside(input))
    print(palindromeTwoPointersFromCenter(input))
    print(almostPalindrome("abccdba"))
}

fun palindromeTwoPointersFromCenter(input: String): Boolean {
    val s = input.replace("[^A-Za-z0-9]".toRegex(), "").toLowerCase();

    // initialize left/right pointers to point at the middle index of the string.
    // Remember, indexes start at 0 meaning that we have to floor() the value from dividing length by 2
    // in order to get the index of the center.
    var left = floor(((s.length / 2).toDouble()))
    var right = left

    // if the string is even, move left pointer back by 1 so left/right are pointing at the 2 middle values respectively.
    if (s.length % 2 == 0)
        left--

    // loop through the string while expanding pointers outwards comparing the characters.
    while (left >= 0 && right < s.length) {
        if (s[left.toInt()] != s[right.toInt()])
            return false

        left--
        right++
    }

    return true
}

fun palindromeTwoPointerFromOutside(input: String): Boolean {
    val s = input.replace("[^A-Za-z0-9]".toRegex(), "").toLowerCase();

    // initialize left/right pointers at start and end of string respectively
    var left = 0
    var right = s.length - 1

    // loop through string characters while comparing them, then move the pointers closer to the center
    while (left < right) {
        if (s[left] != s[right]) {
            return false
        }

        left++
        right--
    }

    return true;
}

fun palindromeCompareAgainstReverse(input: String): Boolean {
    val s = input.replace("[^A-Za-z0-9]".toRegex(), "").toLowerCase();
    var rev = ""

    // generate a reverse string using a reverse for loop.
    for (i in s.length - 1 downTo 0)
        rev += s[i]

    return rev == s
}

fun almostPalindrome(input: String): Boolean {
    val s = input.replace("[^A-Za-z0-9]".toRegex(), "").toLowerCase()
    var left = 0
    var right = s.length - 1

    while (left < right) {
        if (s[left] != s[right]) {
            return isValidPalindrome(s, left + 1, right) || isValidPalindrome(s, left, right - 1)
        }

        left++
        right--
    }

    return true
}

fun isValidPalindrome(s: String, start: Int, end: Int): Boolean {
    var subLeft = start
    var subRight = end
    while (subLeft < subRight) {
        if (s[subLeft] != s[subRight]) {
            return false
        }
        subLeft++
        subRight--
    }
    return true
}