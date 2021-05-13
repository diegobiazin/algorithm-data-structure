package sort

fun main() {
    print(biggerIsGreater("lmno"))
}

// Complete the biggerIsGreater function below.
fun biggerIsGreater(w: String): String {
    if (w.length == 1)
        return "no answer"

    var last: Int = w.length - 2

    // find the longest non-increasing suffix
    // and find the pivot

    // find the longest non-increasing suffix
    // and find the pivot
    while (last >= 0) {
        if (w[last] < w[last + 1]) {
            break
        }
        last--
    }

    // If there is no increasing pair
    // there is no higher order permutation

    // If there is no increasing pair
    // there is no higher order permutation
    if (last < 0)
        return "no answer"

    var nextGreater: Int = w.length - 1

    // Find the rightmost successor to the pivot

    // Find the rightmost successor to the pivot
    for (i in w.length - 1 downTo last + 1) {
        if (w[i] > w[last]) {
            nextGreater = i
            break
        }
    }

    // Swap the successor and the pivot
    var data: String = w
    val temp: Char = w[nextGreater]
    val newString = StringBuilder()
    var p1 = 0
    while (p1 < w.length) {
        if (p1 == last) {
            newString.append(temp)
            p1++
            continue
        }

        if (p1 == nextGreater) {
            newString.append(w[last])
            p1++
            continue
        }

        newString.append(w[p1])
        p1++
    }

    // Reverse the suffix
    var left = last + 1
    var right = newString.length - 1
    while (left < right) {
        val temp = newString[left].toInt()
        newString[left++] = newString[right]
        newString[right--] = temp.toChar()
    }

    return newString.toString()
}
