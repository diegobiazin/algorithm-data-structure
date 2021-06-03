package master_coding.recursion

fun main() {
    print(findKthLargest(arrayOf(5, 3, 1, 6, 4, 2), 4))
}

fun findKthLargest(nums: Array<Int>, k: Int): Int {
    val indexToFind = nums.size - k;
    quickSelect(nums, 0, nums.size - 1, k)
    return nums[indexToFind]
}

fun quickSort(nums: Array<Int>, left: Int, right: Int) {
    if (left < right) {
        val partitionIndex = getPartition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }
}

fun getPartition(nums: Array<Int>, left: Int, right: Int): Int {
    val pivotElement = nums[right]
    var partitionIndex = left
    for (j in left until right) {
        if (nums[j] <= pivotElement) {
            swap(nums, partitionIndex, j)
            partitionIndex++
        }
    }
    swap(nums, partitionIndex, right)
    return partitionIndex
}

fun getPartitionOptimal(nums: Array<Int>, left: Int, right: Int): Int {
    var i = left
    for (j in left..right) {
        if (nums[j] <= nums[right]) {
            swap(nums, i, j)
            i++
        }
    }
    return i - 1
}

fun quickSelect(nums: Array<Int>, left: Int, right: Int, indexToFind: Int): Int {
    val partitionIndex = getPartition(nums, left, right);

    if (partitionIndex == indexToFind) {
        return nums[partitionIndex]
    } else if (indexToFind < partitionIndex) {
        return quickSelect(nums, left, partitionIndex - 1, indexToFind);
    } else {
        return quickSelect(nums, partitionIndex + 1, right, indexToFind);
    }
}

fun swap(array: Array<Int>, i: Int, j: Int) {
    val temp = array[i]
    array[i] = array[j]
    array[j] = temp
}





