package master_coding

fun main() {
    bubbleSort(arrayOf(4, 3, 1, 2))
}

fun bubbleSort(array: Array<Int>) {
    val indices = array.indices
    for (i in indices) {
        for (j in indices) {
            if (array[j] > array[j + 1]) {
                //Swap the numbers
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
}

class Node(
    val left: Int? = null,
    val right: Int? = null,
    val value: Int
)