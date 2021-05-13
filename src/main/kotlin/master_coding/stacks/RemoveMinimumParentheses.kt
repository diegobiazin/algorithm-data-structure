package master_coding.stacks

import java.util.*

fun main() {
    print(minRemoveToMakeValid("(ab(cd)"))
}

fun minRemoveToMakeValid(str: String): String {
    val res = str.toCharArray()
    val stack = Stack<Int>()

    for (i in res.indices) {
        if (res[i] == '(') {
            stack.push(i)
        } else if (res[i] == ')' && stack.size > 0) {
            stack.pop()
        } else if (res[i] == ')') {
            res[i] = Char.MIN_VALUE
        }
    }

    while (stack.size > 0) {
        val curIdx = stack.pop();
        res[curIdx] = Char.MIN_VALUE
    }

    return res.concatToString()
}