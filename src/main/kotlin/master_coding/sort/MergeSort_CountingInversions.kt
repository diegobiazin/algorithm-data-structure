package master_coding.sort

fun main() {
    val array = arrayOf(2, 1, 3, 1, 2)
    val array2 = arrayOf(2, 1, 3, 1, 2)

    println(countInversions(array))
    println(countInversions2(array2))
}

fun countInversions(array: Array<Int>): Long {
    return mergeSort(array, Array<Int>(array.size) { 0 }, 0, array.size - 1)
}

fun countInversions2(array: Array<Int>): Long {
    return mergeSort(array, 0, array.size - 1)
}

fun mergeSort(array: Array<Int>, temp: Array<Int>, leftStart: Int, rightEnd: Int): Long {
    if (leftStart >= rightEnd)
        return 0L

    var counter = 0L
    val middle = (leftStart + rightEnd) / 2
    counter += mergeSort(array, temp, leftStart, middle)
    counter += mergeSort(array, temp, middle + 1, rightEnd)
    counter += merge(array, temp, leftStart, rightEnd)

    return counter
}

fun merge(array: Array<Int>, temp: Array<Int>, leftStart: Int, rightEnd: Int): Long {
    val middle = (rightEnd + leftStart) / 2
    val rightStart = middle + 1
    val size = rightEnd - leftStart + 1

    var counter = 0L
    var left = leftStart
    var right = rightStart
    var index = leftStart

    while (left <= middle && right <= rightEnd) {
        if (array[left] < array[right]) {
            temp[index] = array[left]
            left++
        } else {
            temp[index] = array[right]
            right++
            counter += middle - left + 1
        }
        index++
    }

    System.arraycopy(array, left, temp, index, middle - left + 1)
    System.arraycopy(array, right, temp, index, rightEnd - right + 1)
    System.arraycopy(temp, leftStart, array, leftStart, size)
    return counter
}

fun mergeSort(arr: Array<Int>, start: Int, end: Int): Long {
    if (start == end)
        return 0

    val mid = (start + end) / 2
    var count: Long = 0
    count += mergeSort(arr, start, mid) //left inversions
    count += mergeSort(arr, mid + 1, end) //right inversions
    count += merge(arr, start, end) // split inversions.
    return count
}

fun merge(arr: Array<Int>, start: Int, end: Int): Long {
    val mid = (start + end) / 2
    val newArr = Array<Int>(end - start + 1) { 0 }

    var curr = 0
    var left = start
    var right = mid + 1
    var count: Long = 0
    while (left <= mid && right <= end) {
        if (arr[left] > arr[right]) {
            newArr[curr++] = arr[right++]
            count += (mid - left + 1).toLong()
        } else newArr[curr++] = arr[left++]
    }

    while (left <= mid) {
        newArr[curr++] = arr[left++]
    }
    while (right <= end) {
        newArr[curr++] = arr[right++]
    }
    System.arraycopy(newArr, 0, arr, start, end - start + 1)
    return count
}

