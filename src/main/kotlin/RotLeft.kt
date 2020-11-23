class RotLeft

// Complete the rotLeft function below.
fun rotLeft(arr: IntArray, d: Int): IntArray {
    var size = arr.size
    var newArray = IntArray(size)
    var newIndex = 0

//    for (i in 0 until size) {
//        newIndex = (i + d) % size
//        newArray[i] = a[newIndex]
//    }

    val n: Int = arr.size

    // Create new array for rotated elements:

    // Create new array for rotated elements:
    val rotated = IntArray(n)

    // Copy segments of shifted elements to rotated array:

    // Copy segments of shifted elements to rotated array:
    System.arraycopy(arr, d, rotated, 0, n - d)
    println(rotated)
    System.arraycopy(arr, 0, rotated, n - d, d)
    println(rotated)

    return newArray
}

fun main(args: Array<String>) {
    val d = 2

    val a = intArrayOf(1, 2, 3, 4, 5)

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}

//# Initial assignments:
//# array = [1, 2, 3, 4]
//# length_of_array = array.length = 4
//# no_of_left_rotation = k = 2
//# new_arr = Array.new(length_of_array)
//# new_arr: [nil, nil, nil, nil]
//
//# NOTE:
//# length_of_array.times do |i|
//# is equivalent to
//# for(i = 0; i < length_of_array; i++)
//
//# Algorithm to calculate new index and update new array for each index (i):
//# new_index = (i + no_of_left_rotation) % length_of_array
//# new_arr[i] = array[new_index]
//
//# LOOP1:
//# i = 0
//# new_index = (0 + 2) % 4 = 2
//# new_arr[i = 0] = array[new_index = 2] = 3
//# new_arr: [3, nil, nil, nil]
//
//# LOOP2:
//# i = 1
//# new_index = (1 + 2) % 4 = 3
//# new_arr[i = 1] = array[new_index = 3] = 4
//# new_arr: [3, 4, nil, nil]
//
//# LOOP3:
//# i = 2
//# new_index = (2 + 2) % 4 = 0
//# new_arr[i = 2] = array[new_index = 0] = 1
//# new_arr: [3, 4, 1, nil]
//
//# LOOP4:
//# i = 3
//# new_index = (3 + 2) % 4 = 1
//# new_arr[i = 3] = array[new_index = 1] = 2
//# new_arr: [3, 4, 1, 2]
//
//# After final loop our new roated array is [3, 4, 1, 2]
//# You can return the output:
//# new_arr.join(' ') => 3 4 1 2