package master_coding.stacks

import java.util.*

fun isValidParentheses(s: String): Boolean {
    if (s.isEmpty())
        return true

    val parens = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']'
    )
    val stack = Stack<Char>()

    for (i in s.indices) {
        if (parens.get(s[i]) != null) {
            stack.push(s[i])
        } else {
            val leftBracket = stack.pop()
            val correctBracket = parens[leftBracket]
            if (s[i] != correctBracket)
                return false
        }
    }

    return stack.size == 0
}

fun main() {
    print(isValidParentheses("{()[]}"))
}