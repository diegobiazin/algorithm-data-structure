package master_coding.strings

fun commonChild(s1: String, s2: String): Int {

    /*
     * s2 will be on the rows, s1 will be on the columns.
     *
     * +1 to leave room at the left for the "".
     */
    val cache = Array(s2.length + 1) { IntArray(s1.length + 1) }

    /*
     * cache[s2.length()][s1.length()] is our original subproblem. Each entry in the
     * table is taking a substring operation against whatever string is on the rows
     * or columns.
     *
     * It goes from index 0 to index s2Row/s1Col (exclusive)
     *
     * So if my s1 = "azb" and s1Col = 2...then my substring that I pass to the
     * lcs() function will be:
     *
     * 0 1 2 "a  z  b"
     *
     * "az" (index 2...our upper bound of the snippet...is excluded)
     */for (s2Row in 0..s2.length) {
        for (s1Col in 0..s1.length) {
            if (s2Row == 0 || s1Col == 0) {
                cache[s2Row][s1Col] = 0
            } else if (s2[s2Row - 1] == s1[s1Col - 1]) {
                cache[s2Row][s1Col] = cache[s2Row - 1][s1Col - 1] + 1
            } else {
                cache[s2Row][s1Col] = Math.max(
                    cache[s2Row - 1][s1Col], cache[s2Row][s1Col - 1]
                )
            }
        }
    }

    return cache[s2.length][s1.length]
}

fun longestCommonSubsequenceLength(s1: String, s2: String): Int {
    /*
     * Base Case
     *
     * lcs("", anything...) == 0 lcs(anything..., "") == 0 lcs("", "") == 0
     *
     * A subproblem where either string is empty will have a result of 0. There can
     * be nothing in common with an empty string and anything else.
     */
    if (s1.length == 0 || s2.length == 0) {
        return 0
    }

    /*
     * Just extracting what we certainly will need and being explicit
     */
    val s1WithoutFinalCharacter = s1.substring(0, s1.length - 1)
    val s2WithoutFinalCharacter = s2.substring(0, s2.length - 1)
    val s1FinalCharacter = s1[s1.length - 1]
    val s2FinalCharacter = s2[s2.length - 1]
    return if (s1FinalCharacter == s2FinalCharacter) {
        /*
        * No competition necessary. A match. The answer to THIS subproblem is 1 PLUS
        * the best answer to the subproblem without either of these characters.
        */
        1 + longestCommonSubsequenceLength(s1WithoutFinalCharacter, s2WithoutFinalCharacter)
    } else {
        /*
        * Character mismatch. Compete subproblems, whoever wins becomes the answer to
        * this subproblem and is hence returned
        */
        Math.max(
            longestCommonSubsequenceLength(s1, s2WithoutFinalCharacter),
            longestCommonSubsequenceLength(s1WithoutFinalCharacter, s2)
        )
    }
}

fun main(args: Array<String>) {
    val result = commonChild("ABCDEF", "FBDAMN")

    println(result)
    println(longestCommonSubsequenceLength("ABCDEF", "FBDAMN"))
}