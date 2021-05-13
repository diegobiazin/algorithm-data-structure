package master_coding.arrays

fun main() {
    twoSum(arrayOf(1, 3, 7, 9, 2), 11)
    twoSumOptimal(arrayOf(1, 3, 7, 9, 2), 11)
}

fun twoSum(nums: Array<Int>, target: Int): Array<Int>? {
    for (p1 in nums.indices) {
        val numberToFind = target - nums[p1]
        for (p2 in p1 + 1 until nums.size) {
            if (numberToFind == nums[p2]) {
                print("$p1 $p2")
                return arrayOf(p1, p2)
            }
        }
    }

    return null;
}

fun twoSumOptimal(nums: Array<Int>, target: Int): Array<Int?>? {
    // Find the two index that the sum is equal the target
    val numsMap = mutableMapOf<Int, Int>()

    for(p in nums.indices) {
        val currentMapVal = numsMap[nums[p]]
        if(currentMapVal!= null && currentMapVal >= 0) {
            print("$currentMapVal $p")
            return arrayOf(currentMapVal, p)
        } else {
            val numberToFind = target - nums[p]
            numsMap[numberToFind] = p
        }
    }

    return null
}